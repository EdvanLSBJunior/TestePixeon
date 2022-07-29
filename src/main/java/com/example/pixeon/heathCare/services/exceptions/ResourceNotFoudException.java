package com.example.pixeon.heathCare.services.exceptions;

public class ResourceNotFoudException extends RuntimeException {

    public ResourceNotFoudException(Object id) {
        super("Resource not found " + id);
    }
}
