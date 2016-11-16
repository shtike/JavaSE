package com.urise.webapp.Util;

import com.urise.webapp.storage.AbstractStorageTest;
import com.urise.webapp.storage.PathStorage;
import com.urise.webapp.storage.serializer.JsonStreamSerializer;

import static org.junit.Assert.*;

/**
 * Created by Admin on 30.10.16.
 */
public class JsonPathStorageTest extends AbstractStorageTest{

    public JsonPathStorageTest() {

        super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new JsonStreamSerializer() ));
    }


}