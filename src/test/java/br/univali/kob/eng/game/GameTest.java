package br.univali.kob.eng.game;

import br.univali.kob.eng.exception.GameException;
import br.univali.kob.eng.mock.TeamMock;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void simulateWinner() throws GameException {
        Team strongTeam = TeamMock.createStrongTeam();
        Team weakTeam = TeamMock.createWeakTeam();
        Game game = new Game(weakTeam, strongTeam);
        GameResult result = game.simulate();
        assertEquals(strongTeam, result.getWinner(), "O time com melhores skills vence");
    }

    @Test
    void simulateTied() throws GameException {
        Team strongTeamA = TeamMock.createStrongTeam();
        Team strongTeamB = TeamMock.createStrongTeam();
        Game game = new Game(strongTeamA, strongTeamB);
        GameResult result = game.simulate();
        assertTrue(result.isTied());
    }

    @Test
    void getVisitorTeam() {
        Team strongTeam = TeamMock.createStrongTeam();
        Team weakTeam = TeamMock.createWeakTeam();
        Game game = new Game(weakTeam, strongTeam);
        assertEquals(weakTeam, game.getVisitorTeam());
    }

    @Test
    void getHomeTeam() {
        Team strongTeam = TeamMock.createStrongTeam();
        Team weakTeam = TeamMock.createWeakTeam();
        Game game = new Game(weakTeam, strongTeam);
        assertEquals(strongTeam, game.getHomeTeam());
    }

}