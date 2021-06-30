package br.univali.kob.eng.game;

import br.univali.kob.eng.exception.GameException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    private static final String INVALID_POSITION_MESSAGE = "PositionNotFound: A posição que foi inserida não existe ou está escrita de forma equivocada";
    private static final String INVALID_HEIGHT_MESSAGE = "InvalidHeightBound: Altura do Goleiro está fora do intervalo permitido. A altura deve ser Maior igual a 110cm, e Menor igual a 210cm";
    private static final String INVALID_ATTRIBUTE_MESSAGE = "InvalidAttributeBound: O valor inserido para o atributo deve estar de 0 á 100";
    private static final String INVALID_DATE_MESSAGE = "InvalidDateValue: Não é possível inserir uma data após o dia de hoje ou igual";
    private static final String INVALID_DATE_PATTERN_MESSAGE = "InvalidDateValue: Formato de data inserido sai do padrão dd/MM/yyyy";

    @Test
    void createPlayerWithWrongPositionName() {
        assertThrows(
                GameException.class,
                () -> {
                    new Player("Junior","Invalid",100,0,2,"26/06/2021");
                },
                INVALID_POSITION_MESSAGE
        );
    }

    @Test
    void createGoleiroWithInvalidHeight() {
        validateRangeException(
                GameException.class,
                () -> {
                    new Player("Felipe","Goleiro",109,0,4,"15/12/2000");
                },
                () -> {
                    new Player("Felipe","Goleiro",211,0,4,"15/12/2000");
                },
                INVALID_HEIGHT_MESSAGE
        );
    }

    @Test
    void createPlayerWithInvalidAttributeValue() {
        validateRangeException(
                GameException.class,
                () -> {
                    new Player("Felipe","Atacante",101,0,4,"15/12/2000");
                },
                () -> {
                    new Player("Felipe","Atacante",-1,0,4,"15/12/2000");
                },
                INVALID_ATTRIBUTE_MESSAGE
        );
    }

    @Test
    void createPlayerWithInvalidDate() {
        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String todayPlusFiveDays = LocalDate.now().plusDays(5).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        validateRangeException(
                GameException.class,
                () -> {
                    new Player("Felipe","Atacante",10,0,4, today);
                },
                () -> {
                    new Player("Felipe","Atacante",3,0,4, todayPlusFiveDays);
                },
                INVALID_DATE_MESSAGE
        );
    }

    @Test
    void createPlayerWithInvalidDatePattern() {
        assertThrows(
                GameException.class,
                () -> {
                    new Player("Felipe","Atacante",10,0,4, "02022000");
                },
                INVALID_DATE_PATTERN_MESSAGE
        );
    }

    @Test
    void createPlayerWithInvalidSecondAttributeValue() {
        validateRangeException(
                GameException.class,
                () -> {
                    new Player("Felipe","Atacante",10,101,4,"15/12/2000");
                },
                () -> {
                    new Player("Felipe","Atacante",10,-3,4,"15/12/2000");
                },
                INVALID_ATTRIBUTE_MESSAGE
        );
    }

    @Test
    void createGoleiroWithValidHeight() {
        assertDoesNotThrow(
                () -> {
                    new Player("Junior","Goleiro",170,0,2,"26/06/2021");
                },
                INVALID_HEIGHT_MESSAGE
        );
    }

    @Test
    void createPlayerWithValidAttributeValue() {
        assertDoesNotThrow(
                () -> {
                    new Player("Junior","Atacante",99,87,2,"26/06/2021");
                },
                INVALID_ATTRIBUTE_MESSAGE
        );
    }

    private <T extends Throwable> void validateRangeException(
            Class<T> expectedType,
            Executable executableStartRange,
            Executable executableEndRange,
            String message
    ) {
        assertAll(
                () -> assertThrows(expectedType, executableStartRange, message),
                () -> assertThrows(expectedType, executableEndRange, message)
        );
    }

}