package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Admin on 13.08.16.
 */
public class ArrayStorageTest extends AbstractArrayStorageTest{

//get -------notExist-----///////  getIndex -1//    overflow size==StoreageSize



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
}
