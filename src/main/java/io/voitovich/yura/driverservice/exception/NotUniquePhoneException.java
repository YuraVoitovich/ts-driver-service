package io.voitovich.yura.driverservice.exception;

public class NotUniquePhoneException extends RuntimeException {
    public NotUniquePhoneException() {
    }

    public NotUniquePhoneException(String message) {
        super(message);
    }

    public NotUniquePhoneException(String message, Throwable cause) {
        super(message, cause);
    }
}
