package br.univali.eng.karoline.model.game;

import java.util.List;

public class Team {
    private List<Player> players;
    private String name;
    private int goals;

    public Team(List<Player> players, String name, int goals){
        this.players = players;
        this.name = name;
        this.goals = goals;
    }

    public void insertPlayer(Player player){
       players.add(player);
    }

    public void removePlayer(String name){
        for (int i = 0; i < players.size(); i++) {
            if(players.get(i).getName().equals(name)){
                players.remove(i);
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
}
