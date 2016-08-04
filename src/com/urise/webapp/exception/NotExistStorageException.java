package com.urise.webapp.exception;

/**
 * Created by Admin on 04.08.16.
 */
public class NotExistStorageException extends StorageException {
    public NotExistStorageException(String uuid) {
        super("Resume "+uuid +" not exist " , uuid);
    }
}
