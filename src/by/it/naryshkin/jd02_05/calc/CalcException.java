package by.it.naryshkin.jd02_05.calc;

public class CalcException extends Exception{
    private static final long serialVersionUID = -5047047319553344779L;
    ResourceManager resourceManager = ResourceManager.INSTANCE;
    public CalcException() {
    }

    public  CalcException(String message) {
        super(message);
        System.out.println(this.getMessage());
        Printer printer = new Printer();
        printer.print(this);

    }

    public CalcException(String message, Throwable cause) {
        super(message, cause);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }

    public CalcException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}