package br.univali.kob.eng.mock;

import br.univali.kob.eng.game.Game;
import br.univali.kob.eng.game.Team;

/**
 * Cria mock de Jogos
 */
public abstract class GameMock {

    public static Game createGameHomeWinner() {
        Team home = TeamMock.createStrongTeam();
        Team visitor = TeamMock.createWeakTeam();
        return new Game(visitor, home);
    }

    public static Game createGameVisitorWinner() {
        Team home = TeamMock.createWeakTeam();
        Team visitor = TeamMock.createStrongTeam();
        return new Game(visitor, home);
    }

    public static Game createGameTied() {
        Team home = TeamMock.createStrongTeam();
        Team visitor = TeamMock.createStrongTeam();
        return new Game(visitor, home);
    }
}
