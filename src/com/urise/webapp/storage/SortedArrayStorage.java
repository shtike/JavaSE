package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Created by Admin on 04.07.16.
 */
public class SortedArrayStorage extends AbstractArrayStorage{






    @Override

        public int binaryInsert(Resume r ) {
            if (storageSize == 0)
                return 0;
            int lowerBound = 0;
            int upperBound = storageSize - 1;
            int seredina = 0;
            while (true) {
                seredina = (upperBound + lowerBound) / 2;
                if (storage[seredina]== r) {
                    return seredina;
                } else if (storage[seredina] < r) {
                    lowerBound = seredina + 1; // its in the upper
                    if (lowerBound > upperBound)
                        return seredina + 1;
                } else {
                    upperBound = seredina - 1; // its in the lower
                    if (lowerBound > upperBound)
                        return seredina;
                }
            }
    }


    @Override
    public void save(Resume r) {

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
        return Arrays.binarySearch(storage,0,size,searchKey);
    }
    @Override
    public void update() {


    }


    @Override
    public int size() {
        return size;
    }
}
