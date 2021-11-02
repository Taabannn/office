package ir.maktab58.homework9.exceptions;

/**
 * @author Taban Soleymani
 */
public class OfficeExceptions extends RuntimeException {
    private int errorCode;

    public OfficeExceptions (String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
