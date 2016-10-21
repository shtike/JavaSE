package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.io.*;

/**
 * Created by Admin on 09.10.16.
 */
public class ObjectStreamStorage extends AbstractFileStorage {

    public ObjectStreamStorage(File directory) {
        super(directory);
    }

    @Override
    protected void doWrite(Resume r, OutputStream os) throws IOException {
        try(ObjectOutputStream oos = new ObjectOutputStream(os)){
        oos.writeObject(r);
}
    }

    @Override
    protected Resume doRead(InputStream is) throws IOException {
        try(ObjectInputStream ois = new ObjectInputStream(is)){
            try {
                return (Resume) ois.readObject();
            } catch (ClassNotFoundException e) {
                throw new StorageException("Error read resume",null, e);
            }
        }
    }
}
