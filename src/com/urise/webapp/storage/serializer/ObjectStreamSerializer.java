package com.urise.webapp.storage.serializer;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import com.urise.webapp.storage.ObjectStreamStorage;
import org.omg.CORBA.portable.InputStream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;



/**
 * Created by Admin on 09.10.16.
 */
public class ObjectStreamSerializer implements StreamSerializer1{



    @Override
    public void doWrite(Resume r, OutputStream os) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(os)) {
            oos.writeObject(r);
        }

    }

    @Override
    public Resume doRead(java.io.InputStream is) throws IOException {
        ObjectInputStream ois = new ObjectInputStream(is);
        try {
            return (Resume) ois.readObject();
        } catch (ClassNotFoundException e) {
            throw new StorageException("Error read resume", null, e);
        }
    }







}