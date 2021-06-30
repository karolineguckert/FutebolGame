package br.univali.kob.eng.game;

/**
 * Define o Score de um time
 */
public class TeamScore {

    private final Team team;
    private int score;
    private int victories;
    private int defeats;
    private int draws;

    public TeamScore(Team team) {
        this.team = team;
        this.score = 0;
        this.victories = 0;
        this.defeats = 0;
        this.draws = 0;
    }

    public Team getTeam() {
        return team;
    }

    public int getScore() {
        return score;
    }

    /**
     * Incrementa o Score do time
     * @param valueToSum valor para somar ao score atual
     */
    public void sumScore(int valueToSum) {
        score += valueToSum;
    }

    /**
     * Incrementa o numero de vitorias em 1
     */
    public void sumVictories() {
        this.victories++;
    }

    /**
     * Incrementa o numero de derrotas em 1
     */
    public void sumDefeats() {
        this.defeats++;
    }

    /**
     * Incrementa o numero de empates em 1
     */
    public void sumDraws() {
        this.draws++;
    }

    public int getVictories() {
        return victories;
    }

    public int getDefeats() {
        return defeats;
    }

    public int getDraws() {
        return draws;
    }

    @Override
    public String toString() {
        return "TeamScore{" +
                "team=" + team +
                ", score=" + score +
                ", victories=" + victories +
                ", defeats=" + defeats +
                ", draws=" + draws +
                '}';
    }
}
