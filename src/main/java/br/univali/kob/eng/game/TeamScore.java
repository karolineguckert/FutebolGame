package br.univali.kob.eng.game;

//TODO o programa deve controlar os resultados
//obtidos pelo time (vitórias, empates e derrotas)
public class TeamScore {

    private final Team team;
    private int score;

    public TeamScore(Team team) {
        this.team = team;
        this.score = 0;
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

    @Override
    public String toString() {
        return "TeamScore{" +
                "team=" + team +
                ", score=" + score +
                '}';
    }
}
