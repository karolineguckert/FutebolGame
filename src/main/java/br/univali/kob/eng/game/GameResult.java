package br.univali.kob.eng.game;

/**
 * Define o resultado de um jogo
 */
public class GameResult {

    private final Team winner;
    private final Team looser;
    private final boolean tied;

    public GameResult(Game game) {
        if (game.getHomeTeam().getGoals() == game.getVisitorTeam().getGoals()) {
            this.tied = true;
            this.winner = null;
            this.looser = null;
        } else if (game.getHomeTeam().getGoals() > game.getVisitorTeam().getGoals()) {
            this.tied = false;
            this.winner = game.getHomeTeam();
            this.looser = game.getVisitorTeam();
        } else {
            this.tied = false;
            this.winner = game.getVisitorTeam();
            this.looser = game.getHomeTeam();
        }
    }

    public Team getWinner() {
        return winner;
    }

    public Team getLooser() {
        return looser;
    }

    public boolean isTied() {
        return tied;
    }

    @Override
    public String toString() {
        return "GameResult{" +
                "winner=" + winner +
                ", looser=" + looser +
                ", tied=" + tied +
                '}';
    }
}
