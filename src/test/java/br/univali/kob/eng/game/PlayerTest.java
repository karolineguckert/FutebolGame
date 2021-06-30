package br.univali.kob.eng.game;

import br.univali.kob.eng.exception.GameException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void createPlayerWithWrongPositionName() {
        assertThrows(
                GameException.class,
                () -> {
                    new Player("Junior","Invalid",100,0,2,"26/06/2021");
                }
        );
    }

    @Test
    void createGoleiroWithInvalidHeight() {
        validateRangeException(
                () -> {
                    new Player("Felipe","Goleiro",109,0,4,"15/12/2000");
                },
                () -> {
                    new Player("Felipe","Goleiro",211,0,4,"15/12/2000");
                }
        );
    }

    @Test
    void createPlayerWithInvalidAttributeValue() {
        validateRangeException(
                () -> {
                    new Player("Felipe","Atacante",101,0,4,"15/12/2000");
                },
                () -> {
                    new Player("Felipe","Atacante",-1,0,4,"15/12/2000");
                }
        );
    }

    @Test
    void createPlayerWithInvalidDate() {
        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String todayPlusFiveDays = LocalDate.now().plusDays(5).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        validateRangeException(
                () -> {
                    new Player("Felipe","Atacante",10,0,4, today);
                },
                () -> {
                    new Player("Felipe","Atacante",3,0,4, todayPlusFiveDays);
                }
        );
    }

    @Test
    void createPlayerWithInvalidDatePattern() {
        assertThrows(
                GameException.class,
                () -> {
                    new Player("Felipe","Atacante",10,0,4, "02022000");
                }
        );
    }

    @Test
    void createPlayerWithInvalidSecondAttributeValue() {
        validateRangeException(
                () -> {
                    new Player("Felipe","Atacante",10,101,4,"15/12/2000");
                },
                () -> {
                    new Player("Felipe","Atacante",10,-3,4,"15/12/2000");
                }
        );
    }

    @Test
    void createGoleiroWithValidHeight() {
        assertDoesNotThrow(
                () -> {
                    new Player("Junior","Goleiro",170,0,2,"26/06/2021");
                }
        );
    }

    @Test
    void createPlayerWithValidAttributeValue() {
        assertDoesNotThrow(
                () -> {
                    new Player("Junior","Atacante",99,87,2,"26/06/2021");
                }
        );
    }

    @Test
    void makeScoreTest() throws GameException {
        Player player = new Player("Junior","Atacante",99,87,2,"26/06/2021");
        player.makeScore();
        assertEquals(1, player.getGoals());
    }

    private <T extends Throwable> void validateRangeException(
            Executable executableStartRange,
            Executable executableEndRange
    ) {
        assertAll(
                () -> assertThrows(GameException.class, executableStartRange),
                () -> assertThrows(GameException.class, executableEndRange)
        );
    }

}