package by.it.nikitko.jd02_04;

public class CalcException extends Exception{
    public CalcException() {
    }

    public CalcException(String message) {
        super("ERROR: "+message);
    }

    public CalcException(String message, Throwable cause) {
        super("ERROR: "+message, cause);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }

    public CalcException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super("ERRO: "+message, cause, enableSuppression, writableStackTrace);
    }
}