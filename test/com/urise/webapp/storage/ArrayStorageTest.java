package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.*;

/**
 * Created by Admin on 05.08.16.
 */
public class ArrayStorageTest extends AbstractArrayStorageTest{


    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("dummy");
    }
 }

