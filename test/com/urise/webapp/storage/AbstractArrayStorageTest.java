package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Admin on 13.08.16.
 */
public abstract class AbstractArrayStorageTest {

    protected Storage storage = new ArrayStorage();
    protected static final String UUID_1 = "uuid1";
    protected static final String UUID_2 = "uuid2";
    protected static final String UUID_3 = "uuid3";

    @Before
    public void setUp() throws Exception{
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));

    }

    @Test
    public void size() throws Exception {

    }

    @Test
    public void get() throws Exception {

    }

    @Test
    public void clear() throws Exception {

    }

    @Test
    public void update() throws Exception {

    }

    @Test
    public void getAll() throws Exception {

    }

    @Test
    public void save() throws Exception {

    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void fillDeletedElement() throws Exception {

    }

    @Test
    public void insertElement() throws Exception {

    }

    @Test
    public void getIndex() throws Exception {

    }

}