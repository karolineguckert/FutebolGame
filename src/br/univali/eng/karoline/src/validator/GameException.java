package br.univali.eng.karoline.src.validator;

public class GameException extends Exception {
    public GameException(String exceptionName, String exceptionDescription){
        super(exceptionName + ": " + exceptionDescription);
    }
}
