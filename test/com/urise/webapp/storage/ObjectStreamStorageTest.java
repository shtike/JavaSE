package com.urise.webapp.storage;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Admin on 09.10.16.
 */
public class ObjectStreamStorageTest extends AbstractStorageTest{


    public ObjectStreamStorageTest() {
        super(new ObjectStreamStorage(STORAGE_DIR));
    }



}