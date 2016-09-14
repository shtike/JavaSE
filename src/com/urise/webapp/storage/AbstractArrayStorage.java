package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage {
    protected int storageSize = 10000;
    protected Resume[] storage = new Resume[storageSize];
    protected int size = 0;

    public int size() {
        return size;
    }


    public boolean isResumeExist(Resume r) {
        if (size == storageSize)
            return true;
        else return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }


    @Override
    protected void doUpdate(Resume r, Object index) {
        storage[(Integer) index] = r;
    }


    public Resume[] getAll() {

        return Arrays.copyOfRange(storage, 0, size);


    }

    @Override
    protected void doSave(Resume r, Object index) {
        if (size== storageSize)                 //  !=1
            throw new StorageException("Storage overflow", r.getUuid());
        else {
            insertElement(r, (Integer)index);
            size++;
        }
    }

    @Override
    public void doDelete( Object index) {

            fillDeletedElement((Integer) index);
            storage[size - 1] = null;
            size--;
    }
    public Resume doGet(Object index) {
            return storage[(Integer)index];
    }

    @Override
    protected boolean isExist(Object index) {
        return (Integer) index >=0;
    }

    protected abstract void fillDeletedElement(int index);

    protected abstract void insertElement(Resume r, int index);

    protected abstract Integer getSearchKey(String uuid);
}

