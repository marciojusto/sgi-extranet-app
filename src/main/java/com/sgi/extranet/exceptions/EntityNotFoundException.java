package com.sgi.extranet.exceptions;

public class EntityNotFoundException extends RuntimeException {

    public <T> EntityNotFoundException(String msg) {
        super(msg);
    }
}
