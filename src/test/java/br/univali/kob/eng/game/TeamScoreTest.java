package br.univali.kob.eng.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeamScoreTest {

    private TeamScore teamScore;

    @BeforeEach
    void setUp() {
        Team team = new Team("Test-team");
        this.teamScore = new TeamScore(team);
    }

    @Test
    void sumScore() {
        this.teamScore.sumScore(1);
        this.teamScore.sumScore(3);
        assertEquals(4, this.teamScore.getScore());
    }

    @Test
    void sumVictories() {
        this.teamScore.sumVictories();
        this.teamScore.sumVictories();
        assertEquals(2, this.teamScore.getVictories());
    }

    @Test
    void sumDefeats() {
        this.teamScore.sumDefeats();
        this.teamScore.sumDefeats();
        assertEquals(2, this.teamScore.getDefeats());
    }

    @Test
    void sumDraws() {
        this.teamScore.sumDraws();
        this.teamScore.sumDraws();
        assertEquals(2, this.teamScore.getDraws());
    }

}