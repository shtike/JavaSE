package com.urise.webapp.exception;

/**
 * Created by Admin on 04.08.16.
 */
public class StorageException extends RuntimeException{
    private final String uuid;

    public StorageException(String message, String uuid) {
        super(message);
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }


}
