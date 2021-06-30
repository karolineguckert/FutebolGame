package br.univali.kob.eng.mock;

import br.univali.kob.eng.exception.GameException;
import br.univali.kob.eng.game.Team;

/**
 * Cria Mock de times
 */
public abstract class TeamMock {

    /**
     * Cria um time com skills altas
     * @return Time com skills altas
     */
    public static Team createStrongTeam() {
        try {
            Team team = new Team("Strong" + + Math.random());
            team.insertPlayer("Player1", "Defensor", 100, 100, 1, "26/06/2021");
            team.insertPlayer("Player2", "Defensor", 100, 100, 2, "15/12/2000");
            team.insertPlayer("Player3", "Goleiro", 210, 100, 3, "15/12/2000");
            team.insertPlayer("Player4", "Atacante", 100, 100, 4, "15/12/2000");
            team.insertPlayer("Player5", "Atacante", 100, 100, 5, "15/12/2000");
            return team;
        } catch (GameException ex) {
            return null;
        }
    }

    /**
     * Cria um time com skills baixas
     * @return Time com skills baixas
     */
    public static Team createWeakTeam() {
        try {
            Team team = new Team("Weak" + + Math.random());
            team.insertPlayer("Player1" + Math.random(), "Defensor", 0, 0, 1, "26/06/2021");
            team.insertPlayer("Player2" + Math.random(), "Defensor", 0, 0, 2, "15/12/2000");
            team.insertPlayer("Player3" + Math.random(), "Goleiro", 110, 0, 3, "15/12/2000");
            team.insertPlayer("Player4" + Math.random(), "Atacante", 0, 0, 4, "15/12/2000");
            team.insertPlayer("Player5" + Math.random(), "Atacante", 0, 0, 5, "15/12/2000");
            return team;
        } catch (GameException ex) {
            return null;
        }
    }

    /**
     * Cria um time com skills aleatorias
     * @return Time com skills aleatorias
     */
    public static Team createTeam() {
        try {
            Team team = new Team("Random" + + Math.random());
            team.insertPlayer("Player1" + Math.random(), "Defensor", getRandomNumber(0, 100), getRandomNumber(0, 100), 1, "26/06/2021");
            team.insertPlayer("Player2" + Math.random(), "Defensor", getRandomNumber(0, 100), getRandomNumber(0, 100), 2, "15/12/2000");
            team.insertPlayer("Player3" + Math.random(), "Goleiro", getRandomNumber(110, 210), getRandomNumber(0, 100), 3, "15/12/2000");
            team.insertPlayer("Player4" + Math.random(), "Atacante", getRandomNumber(0, 100), getRandomNumber(0, 100), 4, "15/12/2000");
            team.insertPlayer("Player5" + Math.random(), "Atacante", getRandomNumber(0, 100), getRandomNumber(0, 100), 5, "15/12/2000");
            return team;
        } catch (GameException ex) {
            return null;
        }
    }

    private static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

}
