package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {
    int storageSize = 10000;
    Resume[] storage = new Resume[storageSize];
    public int size = 0;

    public void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    public void save(Resume r) {

        if (getIndex(r.getUuid()) != -1)
            System.out.println("ERROR---------Resume allready exist");
        else {
            if (size < storageSize)
                storage[size] = r;
            size++;
        }
    }

    public Resume get(String uuid) {

        if (getIndex(uuid) == -1) {
            System.out.println("ERROR----------Resume not exist");
            return null;
        } else
            return storage[getIndex(uuid)];


    }

    public void delete(String uuid) {
        if (getIndex(uuid) == -1)
            System.out.println("ERROR------Resume not exist");
        else {
            storage[getIndex(uuid)] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {

        return Arrays.copyOfRange(storage, 0, size);

//        com.urise.webapp.model.Resume[] nepustoy = new com.urise.webapp.model.Resume[size];
//        for (int i = 0; i < size; i++) {
//            nepustoy[i] = storage[i];
//        }
//        return nepustoy;
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

    public int update() {
        return size;
    }

    public int size() {
        return size;
    }
}