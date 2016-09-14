package com.urise.webapp.storage;

import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {





    public Resume get(String uuid) {

        if (getSearchKey(uuid) == -1) {
            throw new NotExistStorageException(uuid);
           // return null;
        } else
            return storage[getSearchKey(uuid)];


    }

    @Override
    public boolean isResumeExist(Resume resume) {
        if (size==storageSize)
            return true;
        else

        return false;
    }

    @Override
    protected void fillDeletedElement(int index) {
        storage[index] = storage[size - 1];
    }

    @Override
    protected void insertElement(Resume r, int index) {
        storage[size] = r;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return Integer.valueOf(-1);
    }




}