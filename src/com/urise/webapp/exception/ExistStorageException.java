package com.urise.webapp.exception;

/**
 * Created by Admin on 04.08.16.
 */
public class ExistStorageException extends StorageException {
    public ExistStorageException(String uuid) {
        super("Resume "+uuid +" already exist ",uuid);
    }

}
