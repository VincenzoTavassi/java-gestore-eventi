package org.learning.java.eventi;

public class EventException extends Exception {
    private String message;

    public EventException(String message) {
        this.message = message;
    }
}
