package br.univali.kob.eng.game;

import br.univali.kob.eng.enums.Position;
import br.univali.kob.eng.exception.GameException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeamTest {

    private static final String TEAM_NAME = "Test Team";

    private Team team;

    @BeforeEach
    void setUp() {
        team = new Team(TEAM_NAME);
    }

    @Test
    void insertPlayerSameShirtNumber() throws GameException {
        team.insertPlayer("Name Test", "Atacante", 3, 2, 10, "19/10/1999");
        assertThrows(
                GameException.class,
                () -> {
                    team.insertPlayer("Other Test", "Atacante", 3, 2, 10, "19/10/1992");
                }
        );
    }

    @Test
    void insertPlayerExceedsLimit() throws GameException {
        team.insertPlayer("Name Test", "Atacante", 3, 2, 1, "19/10/1999");
        team.insertPlayer("Name Test", "Atacante", 3, 2, 2, "19/10/1999");
        team.insertPlayer("Name Test", "Goleiro", 160, 2, 3, "19/10/1999");
        team.insertPlayer("Name Test", "Defensor", 3, 2, 4, "19/10/1999");
        team.insertPlayer("Name Test", "Defensor", 3, 2, 5, "19/10/1999");
        assertThrows(
                GameException.class,
                () -> {
                    team.insertPlayer("Name Test", "Defensor", 3, 2, 10, "19/10/1999");
                }
        );
    }

    @Test
    void insertPlayerExceedsLimitPerPosition() throws GameException {
        team.insertPlayer("Name Test", "Goleiro", 160, 2, 1, "19/10/1999");
        assertThrows(
                GameException.class,
                () -> {
                    team.insertPlayer("Name Test", "Goleiro", 160, 2, 2, "19/10/1999");
                }
        );
    }

    @Test
    void removePlayer() throws GameException {
        team.insertPlayer("Name Test", "Atacante", 3, 2, 1, "19/10/1999");
        team.removePlayer("Name Test");
        assertEquals(0, team.getPlayersByPosition(Position.ATACANTE).size());
    }

    @Test
    void makeScore() throws GameException {
        team.insertPlayer("Name Test", "Atacante", 3, 2, 1, "19/10/1999");
        team.makeScore("Name Test");
        assertEquals(1, team.getGoals());
    }

    @Test
    void getName() {
        assertEquals(TEAM_NAME, team.getName());
    }

    @Test
    void getPlayersByPosition() throws GameException {
        team.insertPlayer("Name Test", "Atacante", 3, 2, 1, "19/10/1999");
        team.insertPlayer("Name Test", "Atacante", 3, 2, 2, "19/10/1999");
        team.insertPlayer("Name Test", "Goleiro", 160, 2, 3, "19/10/1999");
        assertEquals(2, team.getPlayersByPosition(Position.ATACANTE).size());
    }
}