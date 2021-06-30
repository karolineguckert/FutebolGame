package br.univali.kob.eng.game;

import br.univali.kob.eng.exception.GameException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Um campeonato com varios times e o total de score deles
 */
public class Championship {

    private final List<TeamScore> teamScoreList;
    private final List<Game> games;

    public Championship() {
        this.games = new ArrayList<>();
        this.teamScoreList = new ArrayList<>();
    }

    public void insertGame(Game game) {
        if (!games.contains(game)) {
            games.add(game);
            addTeamToScoreList(game.getHomeTeam());
            addTeamToScoreList(game.getVisitorTeam());
        }
    }

    public void simulateGames() throws GameException {
        for (Game game: games) {
            GameResult result = game.simulate();
            if (result.isTied()) {
                sumScore(game.getHomeTeam(), 1);
                sumScore(game.getVisitorTeam(), 1);
            } else {
                sumScore(result.getWinner(), 3);
            }
        }
    }

    public List<TeamScore> getTeamScoreList() {
        return teamScoreList;
    }

    private void addTeamToScoreList(Team team) {
        if (teamScoreList.stream().noneMatch(teamScore -> teamScore.getTeam().equals(team))) {
            teamScoreList.add(new TeamScore(team));
        }
    }

    private void sumScore(Team team, int score) {
        Optional<TeamScore> optionalTeamScore = teamScoreList.stream()
                .filter(teamScore -> teamScore.getTeam().equals(team)).findFirst();

        optionalTeamScore.ifPresent(teamScore -> teamScore.sumScore(score));
    }

    @Override
    public String toString() {
        return "Championship{" +
                "teamScoreList=" + teamScoreList +
                '}';
    }
}
