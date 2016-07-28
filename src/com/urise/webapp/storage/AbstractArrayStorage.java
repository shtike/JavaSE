package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
abstract class AbstractArrayStorage implements Storage {
    protected int storageSize = 10000;
    protected Resume[] storage = new Resume[storageSize];
    int size = 0;

    public int size() {
        return size;
    }


    public boolean isResumeExist(Resume r) {
        if (size == storageSize)
            return true;
        else return false;
    }


    public Resume get(String uuid) {

        if (getIndex(uuid) == -1) {
            System.out.println("ERROR----------Resume not exist");

            return null;
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


    protected abstract int getIndex(String uuid);

    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index > 0) {
            System.out.println("Resume " + r.getUuid() + " not exist");
        } else {
            storage[index] = r;
        }
    }


    public Resume[] getAll() {

        return Arrays.copyOfRange(storage, 0, size);


    }
}

