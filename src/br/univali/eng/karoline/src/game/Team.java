package br.univali.eng.karoline.src.game;

import br.univali.eng.karoline.src.enums.Position;
import br.univali.eng.karoline.src.exception.GameException;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private List<Player> players;
    private String name;
    private int goals;

    public Team(String name){
        this.players = new ArrayList<>();
        this.name = name;
        this.goals = 0;
    }

    private void validateTeamSize (int length) throws GameException {
        if (length > 5){
            throw new GameException("InvalidListBound", "Não é possível inserir mais que 5 jogadores em um time");
        }
    }

    private void validatePlayerName(List<Player> players, String name) throws GameException {
        boolean isAPlayer = false;
        for (Player player: players) {
            if (player.getName().toUpperCase().equals(name.toUpperCase())){
                isAPlayer = true;
                break;
            }
        }
        if (!isAPlayer) throw new GameException("InvalidPlayerName","Não existe jogador com este nome");
    }

    private void validateTeamMembers(List<Player> players, String positionName) throws GameException {
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

    private void validateAmountPosition(int count, Position position) throws GameException {
        if (count == position.getMaximumPlayerPosition()){
            throw new GameException("InvalidAmountPosition", "Não é possível inserir mais de " +
                    position.getMaximumPlayerPosition() + " na posição de " + position.name());
        }
    }

    private void validateInsertPLayers(int shirtNumber, String positionName) throws  GameException {
        validateTeamSize(players.size());
        validateTeamMembers(players,positionName.toUpperCase());
        validateNumber(players,shirtNumber);
    }

    public void validateNumber(List<Player> teams, int newNumber) throws GameException {
        for (Player team : teams) {
            if (team.getShirtNumber() == newNumber) {
                throw new GameException("RepeatedShirtNumber", "O número de camiseta informado já existe no time");
            }
        }
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

    public void insertPlayer(String name,
                             String positionName,
                             int firstAttribute,
                             int secondAttribute,
                             int shirtNumber,
                             String age) throws GameException {
        validateInsertPLayers(shirtNumber, positionName);
       players.add(new Player(name, positionName, firstAttribute, secondAttribute, shirtNumber, age));
    }

    public void removePlayer(String name) throws GameException {
        validatePlayerName(players,name);

        for (int i = 0; i < players.size(); i++) {
            if(players.get(i).getName().toUpperCase().equals(name.toUpperCase())){
                players.remove(i);
                break;
            }
        }
    }

    public void makeScore(String name) throws GameException {
        validatePlayerName(players,name);

        for (Player player : players) {
            if (player.getName().toUpperCase().equals(name.toUpperCase())){
                player.makeScore();
                goals++;
                break;
            }
        }
    }

    public String getName() {
        return name;
    }

    public int getGoals() {
        return goals;
    }

    public String show(){
        StringBuilder result = new StringBuilder();
        for (Player player : players) {
            result.append(player.toString()).append("\n");
        }
        return result.toString();
    }
}
