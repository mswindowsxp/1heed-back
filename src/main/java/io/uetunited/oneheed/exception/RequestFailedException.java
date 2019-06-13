package io.uetunited.oneheed.exception;

public class RequestFailedException extends Exception {
    public RequestFailedException(String message) {
        super(message);
    }

    public RequestFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
