package com.urise.webapp.storage;

import com.urise.webapp.storage.serializer.ObjectStreamSerializer;

/**
 * Created by Admin on 09.10.16.
 */
public class ObjectPathStorageTest extends AbstractStorageTest{


    public ObjectPathStorageTest() {

        super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new ObjectStreamSerializer()));
    }



}