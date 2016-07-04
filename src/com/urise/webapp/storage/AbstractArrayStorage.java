package com.urise.webapp.storage;

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


    public Resume get(String uuid) {

        if (getIndex(uuid) == -1) {
            System.out.println("ERROR----------Resume not exist");

            return null;
        } else

            return storage[getIndex(uuid)];
    }

    protected abstract int getIndex(String uuid);

}
   