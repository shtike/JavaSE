package com.urise.webapp.storage;

import com.urise.webapp.storage.serializer.ObjectStreamSerializer;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Admin on 09.10.16.
 */
public class ObjectFileStorageTest extends AbstractStorageTest{


    public ObjectFileStorageTest() {
        super(new FileStorage(STORAGE_DIR, new  ObjectStreamSerializer()));
    }



}