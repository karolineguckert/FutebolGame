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
            Team team = new Team("Strong");
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
            Team team = new Team("Strong");
            team.insertPlayer("Player1", "Defensor", 0, 0, 1, "26/06/2021");
            team.insertPlayer("Player2", "Defensor", 0, 0, 2, "15/12/2000");
            team.insertPlayer("Player3", "Goleiro", 110, 0, 3, "15/12/2000");
            team.insertPlayer("Player4", "Atacante", 0, 0, 4, "15/12/2000");
            team.insertPlayer("Player5", "Atacante", 0, 0, 5, "15/12/2000");
            return team;
        } catch (GameException ex) {
            return null;
        }
    }

}
