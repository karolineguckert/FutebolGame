package br.univali.kob.eng.game;

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

    public void sumScore(int valueToSum) {
        score += valueToSum;
    }

    public void sumVictories() {
        this.victories++;
    }

    public void sumDefeats() {
        this.defeats++;
    }

    public void sumDraws() {
        this.draws++;
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
