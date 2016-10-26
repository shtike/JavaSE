package com.urise.webapp.storage;

import com.urise.webapp.storage.serializer.ObjectStreamSerializer;
import com.urise.webapp.storage.serializer.XmlStreamSerializer;

/**
 * Created by Admin on 09.10.16.
 */
public class XmlPathStorageTest extends AbstractStorageTest{


    public XmlPathStorageTest() {

        super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new XmlStreamSerializer() ));
    }



}