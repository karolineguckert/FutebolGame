package br.univali.eng.karoline;

import br.univali.eng.karoline.src.game.Team;


public class Main {

    public static void main(String[] args) throws Exception {
        Team team = new Team("vikings");
        team.insertPlayer("Junior","Defensor",100,0,2,"26/06/2021");
        team.insertPlayer("Marcos","Defensor",5,100,1,"15/12/2000");
        team.insertPlayer("Felipe","Goleiro",210,0,4,"15/12/2000");
        team.insertPlayer("Joao","Atacante",1,100,5,"15/12/2000");
        System.out.println(team.show());
        team.makeScore("joao");
        System.out.println(team.show());
    }
}
