package com.urise.webapp.exception;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;

/**
 * Created by Admin on 04.08.16.
 */
public class StorageException extends RuntimeException implements Serializable{
    private final String uuid;

    public StorageException(String message) {
        this(message, null, null);

    }

    public StorageException(String message, String uuid) {
        super(message);
        this.uuid = uuid;
    }

    public StorageException(String message,  Exception e) {
       this(message,null,e);

    }

    public StorageException(String message, String uuid, Exception e) {
        super(message,e);
        this.uuid = uuid;
    }

    public StorageException(Exception e) {
        this(e.getMessage(),e);
    }

    public String getUuid() {
        return uuid;
    }


}
