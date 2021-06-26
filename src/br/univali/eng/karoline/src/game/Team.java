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

    private void insertPLayersValidator(int shirtNumber, String positionName, int firstAttribute, int secondAttribute) throws  GameException {
        Validator validator = new Validator();
        validator.validateTeamSize(players.size());
        validator.validateTeamMembers(players,positionName.toUpperCase());
        validator.validateNumber(players,shirtNumber);
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

    public void makeScore(String name){
        for (Player player : players) {
            if (player.getName().equals(name)){
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
