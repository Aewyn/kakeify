package be.aewyn.kakeify.exceptions;

public class MonthAlreadyExistsException extends RuntimeException {
    public MonthAlreadyExistsException(String message) {
        super(message);
    }
}
