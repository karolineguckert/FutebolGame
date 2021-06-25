package br.univali.eng.karoline;

import br.univali.eng.karoline.src.game.Team;


public class Main {

    public static void main(String[] args) throws Exception {
        Team team = new Team("vikings");
        team.insertPlayer("Junior","Defensor",100,0,2,13);
        team.insertPlayer("Marcos","Defensor",5,100,1,15);
        team.insertPlayer("Felipe","Goleiro",210,0,4,13);
        team.insertPlayer("João","Defensor",1,100,5,15);
        team.show();
    }
}
