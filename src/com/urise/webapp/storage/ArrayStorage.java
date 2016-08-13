package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {





    public Resume get(String uuid) {

        if (getIndex(uuid) == -1) {
            System.out.println("ERROR----------Resume not exist");
            return null;
        } else
            return storage[getIndex(uuid)];


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
    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }




}