package ir.maktab58.homework9.exceptions;

/**
 * @author Taban Soleymani
 */
public class IllegalPersonnelCode extends OfficeExceptions {
    public IllegalPersonnelCode(String message, int errorCode) {
        super(message, errorCode);
    }
}
