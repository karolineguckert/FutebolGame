package br.univali.kob.eng.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    void calculateSkillGoleiro() {
        assertEquals(10, Position.GOLEIRO.calculateSkill(1, 1));
    }

    @Test
    void calculateSkillAtacante() {
        assertEquals(10, Position.ATACANTE.calculateSkill(1, 1));
    }

    @Test
    void calculateSkillDefensor() {
        assertEquals(10, Position.DEFENSOR.calculateSkill(1, 1));
    }

    @Test
    void getFirstMultiplierGoleiro() {
        assertEquals(4, Position.GOLEIRO.getFirstMultiplier());
    }

    @Test
    void getFirstMultiplierAtacante() {
        assertEquals(4, Position.ATACANTE.getFirstMultiplier());
    }

    @Test
    void getFirstMultiplierDefensor() {
        assertEquals(6, Position.DEFENSOR.getFirstMultiplier());
    }

    @Test
    void getSecondMultiplierGoleiro() {
        assertEquals(6, Position.GOLEIRO.getSecondMultiplier());
    }

    @Test
    void getSecondMultiplierAtacante() {
        assertEquals(6, Position.ATACANTE.getSecondMultiplier());
    }

    @Test
    void getSecondMultiplierDefensor() {
        assertEquals(4, Position.DEFENSOR.getSecondMultiplier());
    }

    @Test
    void getMaximumPlayerPositionGoleiro() {
        assertEquals(
                1,
                Position.GOLEIRO.getMaximumPlayerPosition(),
                "Um time pode ter apenas 1 goleiro"
        );
    }

    @Test
    void getMaximumPlayerPositionAtacante() {
        assertEquals(
                2,
                Position.ATACANTE.getMaximumPlayerPosition(),
                "Um time pode ter no maximo 2 atacantes"
        );
    }

    @Test
    void getMaximumPlayerPositionDefensor() {
        assertEquals(
                2,
                Position.DEFENSOR.getMaximumPlayerPosition(),
                "Um time pode ter no maximo 2 defensores"
        );
    }
}