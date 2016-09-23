package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Admin on 13.08.16.
 */
public class SortedArrayStorageTest extends AbstractStorageTest {
    public SortedArrayStorageTest() {
        super(new ArrayStorage());
    }

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
    storage.save( new Resume(UUID_1, "Name1"));
    }
    @Test(expected = StorageException.class)
    public void saveOverflow() {

        storage.save( new Resume(UUID_1, "Name1"));
    }

    //////////////---------------------------next In abstract class metods
    @Test
    public void size() throws Exception {
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void get() throws Exception {

        Resume r1 = new Resume(UUID_1, "Name1");
        Assert.assertEquals( r1, storage.get(UUID_1));///////////////////
    }

    @Test
    public void clear() throws Exception {

        storage.clear();
        Storage storageTest = new ArrayStorage();
        Assert.assertEquals(storageTest.getAllSorted(), storage.getAllSorted());     //  Assert.assertEquals(null,storage.get(UUID_1));
    }


    @Test
    public void update() throws Exception {
        storage.update(storage.get(UUID_1));
        Resume r = storage.get(UUID_1);
        Resume r2 = new Resume(UUID_1, "Name1");

        Assert.assertEquals(r, r2);

    }

    @Test
    public void getAll() throws Exception {
        Storage storageTest = new ArrayStorage();
        storageTest.save(new Resume(UUID_1, "Name1"));
        storageTest.save(new Resume(UUID_2, "Name2"));
        storageTest.save(new Resume(UUID_3, "Name3"));
        storageTest.getAllSorted();
        Assert.assertEquals((storageTest.getAllSorted()), storage.getAllSorted());

    }

    @Test
    public void save() throws Exception {
        Storage storageTest = new ArrayStorage();
        storageTest.save(new Resume(UUID_1, "Name1"));
        Assert.assertEquals(storageTest.get(UUID_1), storage.get((UUID_1)));
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() throws Exception {
        Storage storageTest = new ArrayStorage();
        storageTest.save(new Resume(UUID_1, "Name1"));
        storage.delete(UUID_1);
        storageTest.delete(UUID_1);
        Assert.assertEquals(storageTest.get(UUID_1),storage.get(UUID_1));
    }

    @Test
    public void getIndex() throws Exception {
        Storage storageTest = new ArrayStorage();///
        storageTest.save(new Resume(UUID_1, "Name1"));
        storage.get(UUID_1);
        System.out.println(storage.get(UUID_1).getUuid());

    }


    @Test
    public void fillDeletedElement() throws Exception {
        storage.delete(UUID_1);
        Assert.assertEquals(2, storage.size());
    }

    @Test
    public void insertElement() throws Exception {
        storage.save(new Resume(UUID_4,"Name4" ));
        Assert.assertEquals(4, storage.size());

    }


}