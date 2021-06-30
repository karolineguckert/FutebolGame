package br.univali.kob.eng.game;

import br.univali.kob.eng.exception.GameException;
import br.univali.kob.eng.mock.GameMock;
import br.univali.kob.eng.mock.TeamMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChampionshipTest {

    private Championship championship;

    @BeforeEach
    void setUp() {
        this.championship = new Championship();
    }

    @Test
    void insertGame() {
        Team teamA = TeamMock.createTeam();
        Team teamB = TeamMock.createTeam();
        Game game = new Game(teamA, teamB);
        championship.insertGame(game);
        assertEquals(2, championship.getTeamScoreList().size());
    }

    @Test
    void simulateGamesWinner() throws GameException {
        Game game = GameMock.createGameHomeWinner();

        championship.insertGame(game);
        championship.simulateGames();

        TeamScore homeTeamScore = championship.getTeamScore(game.getHomeTeam());
        TeamScore visitorTeamScore = championship.getTeamScore(game.getVisitorTeam());

        assertAll(
                () -> assertEquals(3, homeTeamScore.getScore(), "Vencedor ganha 3 pontos"),
                () -> assertEquals(1, homeTeamScore.getVictories(), "Vencedor tem 1 vitoria"),
                () -> assertEquals(0, homeTeamScore.getDefeats(), "Vencedor tem 0 derrotas"),
                () -> assertEquals(0, homeTeamScore.getDraws(), "Vencedor tem 0 empates"),
                () -> assertEquals(0, visitorTeamScore.getScore(), "Perdedor ganha 0 pontos"),
                () -> assertEquals(0, visitorTeamScore.getVictories(), "Perdedor tem 0 vitoria"),
                () -> assertEquals(1, visitorTeamScore.getDefeats(), "Perdedor tem 1 derrotas"),
                () -> assertEquals(0, visitorTeamScore.getDraws(), "Perdedor tem 0 empates")
        );
    }

    @Test
    void simulateGamesTied() throws GameException {
        Game game = GameMock.createGameTied();

        championship.insertGame(game);
        championship.simulateGames();

        TeamScore homeTeamScore = championship.getTeamScore(game.getHomeTeam());
        TeamScore visitorTeamScore = championship.getTeamScore(game.getVisitorTeam());

        assertAll(
                () -> assertEquals(1, homeTeamScore.getScore(), "Time de casa ganha 1 pontos"),
                () -> assertEquals(0, homeTeamScore.getVictories(), "Time de casa tem 0 vitoria"),
                () -> assertEquals(0, homeTeamScore.getDefeats(), "Time de casa tem 0 derrotas"),
                () -> assertEquals(1, homeTeamScore.getDraws(), "Time de casa tem 1 empates"),
                () -> assertEquals(1, visitorTeamScore.getScore(), "Time de fora ganha 1 pontos"),
                () -> assertEquals(0, visitorTeamScore.getVictories(), "Time de fora tem 0 vitoria"),
                () -> assertEquals(0, visitorTeamScore.getDefeats(), "Time de fora tem 0 derrotas"),
                () -> assertEquals(1, visitorTeamScore.getDraws(), "Time de fora tem 1 empates")
        );
    }

    @Test
    void simulateTwoGames() throws GameException {
        Game firstGame = GameMock.createGameHomeWinner();
        Team winnerTeam = firstGame.getHomeTeam();
        Team weakTeam = TeamMock.createWeakTeam();
        Game secondGame = new Game(weakTeam, winnerTeam);

        championship.insertGame(firstGame);
        championship.insertGame(secondGame);

        championship.simulateGames();

        TeamScore winnerTeamScore = championship.getTeamScore(winnerTeam);
        TeamScore looserTeamA = championship.getTeamScore(firstGame.getVisitorTeam());
        TeamScore looserTeamB = championship.getTeamScore(weakTeam);

        assertAll(
                () -> assertEquals(6, winnerTeamScore.getScore(), "Time de casa ganha 6 pontos"),
                () -> assertEquals(2, winnerTeamScore.getVictories(), "Time de casa tem 2 vitoria"),
                () -> assertEquals(0, winnerTeamScore.getDefeats(), "Time de casa tem 0 derrotas"),
                () -> assertEquals(0, winnerTeamScore.getDraws(), "Time de casa tem 0 empates"),
                () -> assertEquals(0, looserTeamA.getVictories(), "Primeiro time perdedor tem 0 vitorias"),
                () -> assertEquals(0, looserTeamB.getVictories(), "Segundo time perdedor tem 0 vitorias")
        );
    }

}