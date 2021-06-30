package br.univali.kob.eng.game;

import br.univali.kob.eng.exception.GameException;
import br.univali.kob.eng.mock.GameMock;
import br.univali.kob.eng.mock.TeamMock;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void simulateHomeWinner() throws GameException {
        Game game = GameMock.createGameHomeWinner();
        GameResult result = game.simulate();
        assertEquals(game.getHomeTeam(), result.getWinner(), "O time com melhores skills vence");
    }

    @Test
    void simulateVisitorWinner() throws GameException {
        Game game = GameMock.createGameVisitorWinner();
        GameResult result = game.simulate();
        assertEquals(game.getVisitorTeam(), result.getWinner(), "O time com melhores skills vence");
    }

    @Test
    void simulateTied() throws GameException {
        Game game = GameMock.createGameTied();
        GameResult result = game.simulate();
        assertTrue(result.isTied());
    }

    @Test
    void getVisitorTeam() {
        Team teamA = TeamMock.createTeam();
        Team teamB = TeamMock.createTeam();
        Game game = new Game(teamB, teamA);
        assertEquals(teamB, game.getVisitorTeam());
    }

    @Test
    void getHomeTeam() {
        Team teamA = TeamMock.createTeam();
        Team teamB = TeamMock.createTeam();
        Game game = new Game(teamB, teamA);
        assertEquals(teamA, game.getHomeTeam());
    }

}