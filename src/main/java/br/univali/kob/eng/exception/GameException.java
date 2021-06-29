package br.univali.kob.eng.exception;

public class GameException extends Exception {
    public GameException(String exceptionName, String exceptionDescription){
        super(exceptionName + ": " + exceptionDescription);
    }
}
