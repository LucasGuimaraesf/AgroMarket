package exceptions;

public class FeiraJaAbertaException extends Exception {
    public FeiraJaAbertaException(String nomeFeira) {
        super("A feira '" + nomeFeira + "' ja esta aberta.");
    }
}