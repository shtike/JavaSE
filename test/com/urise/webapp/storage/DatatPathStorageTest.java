package com.urise.webapp.storage;

import com.urise.webapp.storage.serializer.DataStreamSerializer;
import com.urise.webapp.storage.serializer.ObjectStreamSerializer;

/**
 * Created by Admin on 09.10.16.
 */
public class DatatPathStorageTest extends AbstractStorageTest{


    public DatatPathStorageTest() {

        super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new DataStreamSerializer()));
    }



}