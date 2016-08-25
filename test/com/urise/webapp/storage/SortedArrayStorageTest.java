package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Admin on 13.08.16.
 */
public class SortedArrayStorageTest extends AbstractArrayStorageTest {

    //getindex not   //save exist //overflow


    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("dummy");
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() {
        storage.delete("dummy");
    }

    @Test(expected = ExistStorageException.class)
    public void saveAlreadyExist() {
         final String UUID_1 = "uuid1";
    storage.save( new Resume(UUID_1));
    }
    @Test(expected = StorageException.class)
    public void saveOverflow() {

        storage.save( new Resume(UUID_1));
    }

    //////////////---------------------------next In abstract class metods
    @Test
    public void size() throws Exception {
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void get() throws Exception {
        storage.get("uuid1");

    }

    @Test
    public void clear() throws Exception {
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void update() throws Exception {

    }

    @Test
    public void getAll() throws Exception {
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void save() throws Exception {
        storage.save( new Resume(UUID_4));
        Assert.assertEquals(4, storage.size());
    }

    @Test
    public void delete() throws Exception {
        storage.delete("uuid1");
        Assert.assertEquals(2, storage.size());
    }

    @Test
    public void getIndex() throws Exception {
        storage.get (UUID_1);
        Assert.assertEquals(UUID_1,UUID_1);

    }


    @Test
    public void fillDeletedElement() throws Exception {
        storage.delete(UUID_1);
        Assert.assertEquals(2,storage.size());
    }

    @Test
    public void insertElement() throws Exception {
        storage.save(new Resume(UUID_4));
        Assert.assertEquals(4,storage.size());
    }

}