package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Created by Admin on 04.07.16.
 */
public class SortedArrayStorage extends AbstractArrayStorage{




    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    @Override
    public void save(Resume r) {
        if (getIndex(r.getUuid()) != -1)
            System.out.println("ERROR---------Resume allready exist");
        else {
            if (size < storageSize)
                storage[size] = r;
            size++;
        }
    }

    @Override
    public Resume get(String uuid) {

        if (getIndex(uuid) == -1) {
            System.out.println("ERROR----------Resume not exist");
            return null;
        } else
            return storage[getIndex(uuid)];


    }
    @Override
    public void delete(String uuid) {
        if (getIndex(uuid) == -1)
            System.out.println("ERROR------Resume not exist");
        else {
            storage[getIndex(uuid)] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
    }

     @Override
    public Resume[] getAll() {
        return new Resume[0];
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage,0,size,uuid);
    }
    @Override
    public int update() {
        return size;
    }


    @Override
    public int size() {
        return size;
    }
}
