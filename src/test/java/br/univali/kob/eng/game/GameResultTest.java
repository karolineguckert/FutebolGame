package br.univali.kob.eng.game;

import br.univali.kob.eng.exception.GameException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameResultTest {

    @Test
    void createGameResult() throws GameException {
        Game game = createMockGame();
        game.getVisitorTeam().makeScore("Player-Test");

        GameResult result = new GameResult(game);
        assertAll(
                () -> assertEquals(game.getVisitorTeam(), result.getWinner(), "Os visitantes ganham"),
                () -> assertEquals(game.getHomeTeam(), result.getLooser(), "Os de casa perdem"),
                () -> assertFalse(result.isTied(), "Não foi impate")
        );
    }

    @Test
    void createGameResultTied() throws GameException {
        Game game = createMockGame();

        GameResult result = new GameResult(game);
        assertAll(
                () -> assertNull(result.getWinner()),
                () -> assertNull(result.getLooser()),
                () -> assertTrue(result.isTied())
        );
    }

    private Game createMockGame() throws GameException {
        Team teamA = new Team("teamA");
        teamA.insertPlayer("Player-Test", "Atacante", 3, 2, 1, "19/10/1999");

        Team teamB = new Team("teamB");
        teamB.insertPlayer("Other-Test", "Atacante", 3, 2, 1, "19/10/1999");

        return new Game(teamA, teamB);
    }
}