package com.example.scurity.exception;

public class DuplicateResourceException extends RuntimeException {

    public DuplicateResourceException(String entityName, String field, Object value) {
        super(entityName + " already exists with " + field + ": " + value);
    }
}
