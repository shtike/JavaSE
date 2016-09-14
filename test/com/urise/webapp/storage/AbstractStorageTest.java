package com.urise.webapp.storage;

import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;

import static org.junit.Assert.*;

/**
 * Created by Admin on 13.08.16.
 */
public abstract class AbstractStorageTest {

   protected Storage storage = new ArrayStorage();
    protected static final String UUID_1 = "uuid1";
    protected static final String UUID_2 = "uuid2";
    protected static final String UUID_3 = "uuid3";
    protected static final String UUID_4 = "uuid4";

      static Resume RESUME_1 = new Resume(UUID_1);
    private static Resume RESUME_2 = new Resume(UUID_2);
    private static Resume RESUME_3 = new Resume(UUID_3);
    private static Resume RESUME_4 = new Resume(UUID_4);

    static {
        RESUME_1 = new Resume(UUID_1);
        RESUME_2 = new Resume(UUID_2);
        RESUME_3 = new Resume(UUID_3);
        RESUME_4 = new Resume(UUID_4);
    }


    public AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));

    }

    @Test
    public void size() throws Exception {
        assertSize(3);
    }

    @Test
    public void get() throws Exception {
        assertGet(RESUME_1);
        assertGet(RESUME_2);
        assertGet(RESUME_3);
    }

    @Test
    public void clear() throws Exception {
        storage.clear();
        assertSize(0);
    }

    @Test
    public void update() throws Exception {
        storage.delete(UUID_1);
        Resume newResume = new Resume(UUID_1);
        storage.save(newResume);
        assertTrue(newResume == storage.get(UUID_1));
    }

    @Test
    public void getAll() throws Exception {
        Resume[] array = storage.getAll();
        assertEquals(3, array.length);
        assertEquals(RESUME_1, array[0]);
        assertEquals(RESUME_2, array[1]);
        assertEquals(RESUME_3, array[2]);
    }

    @Test
    public void save() throws Exception {
        storage.save(RESUME_4);
        assertSize(4);
        assertEquals(RESUME_4, storage.get(UUID_4));
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() throws Exception {
        storage.delete(UUID_1);
        assertSize(2);
        storage.get(UUID_1);
    }
//TODO: remain only for Arrays implementations
    @Test(timeout = 100 ,expected = StorageException.class)
    public void saveOverflow() throws Exception {
        try {
            for (int i = 4; i <= 10000; i++) {
                storage.save(new Resume());
            }
        } catch (StorageException e) {
            Assert.fail();
        }
        storage.save(new Resume());

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

    private void assertGet(Resume r) {
        assertEquals(r, storage.get(r.uuid));
    }

    private void assertSize(int size) {
        assertEquals(size, storage.size());
    }


}