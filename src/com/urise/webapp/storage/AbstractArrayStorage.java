package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
abstract class AbstractArrayStorage implements Storage {
    protected int storageSize = 10000;
    protected Resume[] storage = new Resume[storageSize];
    protected int size = 0;

    public int size() {
        return size;
    }


//    public boolean isResumeExist(Resume r) {
//        if (size == storageSize)
//            return true;
//        else return false;
//    }


    public Resume get(String uuid) {

        if (getIndex(uuid) < 0) {
            throw new NotExistStorageException(uuid);

        } else
            return storage[getIndex(uuid)];
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }


    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index > 0) {
            throw new NotExistStorageException(r.getUuid());
        } else {
            storage[index] = r;
        }
    }


    public Resume[] getAll() {

        return Arrays.copyOfRange(storage, 0, size);


    }

    public void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (isResumeExist(r))
            throw new StorageException("Storage overflow", r.getUuid());

        else if (getIndex(r.getUuid()) >=0)                 //  !=1
            throw new ExistStorageException(r.getUuid());
        else {
            insertElement(r, index);
            size++;

        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (getIndex(uuid) < 0)
            throw new NotExistStorageException(uuid);
        else {
            fillDeletedElement(index);
            storage[size - 1] = null;
            size--;
        }
    }

    protected abstract void fillDeletedElement(int index);

    protected abstract void insertElement(Resume r, int index);

    protected abstract int getIndex(String uuid);
}

