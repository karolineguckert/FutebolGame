package br.univali.kob.eng.game;

import br.univali.kob.eng.enums.Position;
import br.univali.kob.eng.exception.GameException;

import java.time.LocalDateTime;
import java.util.List;

public class Game {

    private final Team visitorTeam;
    private final Team homeTeam;
    private final LocalDateTime date;
    private TeamAttacking teamAttacking;
    private GameResult result;

    public Game(Team visitorTeam, Team homeTeam){
        this.date = LocalDateTime.now();
        this.visitorTeam = visitorTeam;
        this.homeTeam = homeTeam;
    }

    /**
     * Simula o jogo e retorna o resultado
     * São executadas 10 rodadas, a cada rodada o time que faz gol é definido pela segunte formula
     * skills de um atacante > (skills de um denfensor + skills do goleiro)
     * O time de casa começa atacando, oque da uma vantagem
     * a cada turno é invertido o time que está atacando
     * @return Game result -> resultado do jogo
     * @throws GameException Pode ser lançada ao invocar o makeScore
     */
    public GameResult simulate() throws GameException {
        this.teamAttacking = TeamAttacking.HOME;
        for (int i = 0; i < 10; i++) {
            Team[] attackingDefending = getTeamAttackingAndDefensing();
            Team attackingTeam = attackingDefending[0];
            Team defendingTeam = attackingDefending[1];

            List<Player> attackers = attackingTeam.getPlayersByPosition(Position.ATACANTE);
            Player attackerThisTurn = attackers.get(getRandomNumber(attackers.size()));

            List<Player> defenders = defendingTeam.getPlayersByPosition(Position.DEFENSOR);
            Player defenderThisTurn = defenders.get(getRandomNumber(defenders.size()));

            Player goalkeeper = defendingTeam.getPlayersByPosition(Position.GOLEIRO).get(0);

            int attackerPoints = attackerThisTurn.getSkillPoints();
            int defensePoints = (goalkeeper.getSkillPoints() + defenderThisTurn.getSkillPoints());
            if (attackerPoints > defensePoints) {
                attackingTeam.makeScore(attackerThisTurn.getName());
            }

            toggleTeamAttacking();
        }

        this.result = new GameResult(this);
        return this.result;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Team getVisitorTeam() {
        return visitorTeam;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public GameResult getResult() {
        return result;
    }

    private void toggleTeamAttacking() {
        this.teamAttacking = this.teamAttacking.equals(TeamAttacking.HOME) ? TeamAttacking.VISITOR : TeamAttacking.HOME;
    }

    private Team[] getTeamAttackingAndDefensing() {
        if (this.teamAttacking.equals(TeamAttacking.HOME)) {
            return new Team[] { homeTeam, visitorTeam };
        }
        return new Team[] { visitorTeam, homeTeam };
    }

    public <T> int getRandomNumber(int max) {
        int min = 0;
        return (int) ((Math.random() * (max - min)) + min);
    }

}
