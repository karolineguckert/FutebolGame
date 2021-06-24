package br.univali.eng.karoline.src.game;

import br.univali.eng.karoline.src.validator.GameException;
import br.univali.eng.karoline.src.validator.Validator;

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

    public void insertPlayer(String name,
                             String positionName,
                             int firstAttribute,
                             int secondAttribute,
                             int shirtNumber,
                             int age) throws GameException {
        insertPLayersValidator(shirtNumber, positionName, firstAttribute, secondAttribute);
       players.add(new Player(name, positionName, firstAttribute, secondAttribute, shirtNumber, age));
    }


    public void removePlayer(String name){
        for (int i = 0; i < players.size(); i++) {
            if(players.get(i).getName().equals(name)){
                players.remove(i);
                break;
            }
        }
    }

    private void insertPLayersValidator(int shirtNumber, String positionName, int firstAttribute, int secondAttribute) throws  GameException {
        Validator validator = new Validator();
        validator.validateTeamSize(players.size());
        validator.validatePositionName(positionName);
        validator.validateNumber(players,shirtNumber);
        firstAttributeValidator(positionName, firstAttribute);
        validator.validateAttributeValue(secondAttribute);
    }

    private void firstAttributeValidator(String positionName, int firstAttribute) throws GameException {
        Validator validator = new Validator();
        if(positionName.toUpperCase().equals("GOLEIRO")) {
            validator.validateHeightBound(firstAttribute);
        }else {
            validator.validateAttributeValue(firstAttribute);
        }
    }

    public String getName() {
        return name;
    }

    public int getGoals() {
        return goals;
    }

    public void show(){
        for (Player player : players) {
            System.out.println(player.toString());
        }
    }
}
