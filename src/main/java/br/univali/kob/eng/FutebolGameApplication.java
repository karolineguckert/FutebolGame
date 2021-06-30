package br.univali.kob.eng;

import br.univali.kob.eng.game.Championship;
import br.univali.kob.eng.game.Game;
import br.univali.kob.eng.game.GameResult;
import br.univali.kob.eng.game.Team;

public class FutebolGameApplication {

    public static void main(String[] args) throws Exception {
        Team teamA = new Team("vikings");
        teamA.insertPlayer("Junior","Defensor",100,0,2,"26/06/2021");
        teamA.insertPlayer("Marcos","Defensor",5,100,1,"15/12/2000");
        teamA.insertPlayer("Felipe","Goleiro",210,0,4,"15/12/2000");
        teamA.insertPlayer("Joao","Atacante",99,100,5,"15/12/2000");
        System.out.println(teamA.show());


        Team teamB = new Team("japoneses");
        teamB.insertPlayer("Goku","Defensor",0,0,2,"26/06/2021");
        teamB.insertPlayer("Gohan","Defensor",0,0,1,"15/12/2000");
        teamB.insertPlayer("Vegeta","Goleiro",110,0,4,"15/12/2000");
        teamB.insertPlayer("Piccolo","Atacante",100,100,5,"15/12/2000");
        System.out.println(teamB.show());

        Game game = new Game(teamA, teamB);

        Championship championship = new Championship();
        championship.insertGame(game);
        championship.simulateGames();

        System.out.println(championship);




    }

}
