package be.aewyn.kakeify.exceptions;

public class MonthNotFoundException extends RuntimeException {
    public MonthNotFoundException(String message) {
        super(message);
    }
}
