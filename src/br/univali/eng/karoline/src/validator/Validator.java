package br.univali.eng.karoline.src.validator;

import br.univali.eng.karoline.src.enums.Position;
import br.univali.eng.karoline.src.game.Player;
import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.List;

public class Validator {

    public void validateNumber(List<Player> teams, int newNumber) throws GameException {
        for (Player team : teams) {
            if (team.getShirtNumber() == newNumber) {
                throw new GameException("RepeatedShirtNumber", "O número de camiseta informado já existe no time");
            }
        }
    }

    public void validatePositionName(String positionName) throws GameException {
        try {
            Position.valueOf(positionName.toUpperCase());
        }catch(IllegalArgumentException e){
            throw new GameException("PositionNotFound","A posição que foi inserida não existe ou está escrita de forma equivocada");
        }
    }

    public void validateAttributeValue(int attribute) throws GameException {
        if (attribute < 0 || attribute > 100){
            throw new GameException("InvalidAttributeBound","O valor inserido para o atributo deve estar de 0 á 100");
        }
    }

    public void validateHeightBound (int height) throws GameException {
        if (height <110 || height > 210){
            throw new GameException("InvalidHeightBound", "Altura do Goleiro está fora do intervalo permitido. A altura deve ser Maior igual a 110cm, e Menor igual a 210cm");
        }
    }

    public void validateTeamSize (int length) throws GameException {
        if (length > 5){
            throw new GameException("InvalidListBound", "Não é possível inserir mais que 5 jogadores em um time");
        }
    }

    private void validateAmountPosition(int count, Position position) throws GameException {
        if (count == position.getMaximumPlayerPosition()){
            throw new GameException("InvalidAmountPosition", "Não é possível inserir mais de " +
                    position.getMaximumPlayerPosition() + " na posição de " + position.name());
        }
    }

    public void validateTeamMembers(List<Player> players, String positionName) throws GameException {
        int count;
        if (positionName.equals(Position.DEFENSOR.name())) {
            count = countMembers(players,Position.DEFENSOR);
        } else {
            if (positionName.equals(Position.ATACANTE.name())) {
                count = countMembers(players,Position.ATACANTE);
            } else {
                count = countMembers(players,Position.GOLEIRO);
            }
        }
        validateAmountPosition(count,Position.valueOf(positionName));
    }

    private int countMembers(List<Player> players, Position position){
        int count = 0;
        for (Player player : players) {
            if (player.getPosition().equals(position)) {
                count += 1;
            }
        }

        return count;
    }
}
