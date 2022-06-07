package org.example.exception;

public class ObjectNotFoundException extends Exception {

    private final String objName;

    public ObjectNotFoundException(String message, String objName) {
        super(message);
        this.objName = objName;
    }
}
