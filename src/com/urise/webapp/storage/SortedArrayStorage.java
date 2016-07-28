package com.urise.webapp.storage;

import com.sun.org.apache.xpath.internal.SourceTree;
import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

/**
 * Created by Admin on 04.07.16.
 */
public class SortedArrayStorage extends AbstractArrayStorage {


    public int binaryInsert(Resume r) {
        if (storageSize == 0)
            return -1;
        int lowerBound = 0;
        int upperBound = storageSize - 1;
        int seredina = 0;
        while (true) {
            seredina = (upperBound + lowerBound) / 2;
            if (storage[seredina] == r) {
                return seredina;
            } else if (Integer.parseInt(storage[seredina].getUuid()) < Integer.parseInt(r.getUuid())) {
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


    public void save(Resume r) {
        // int index = Arrays.binarySearch(storage, 0, size, r);
        int index = getIndex(r.uuid);
        if (isResumeExist(r)) {
            System.out.println("Storage overflow");
        } else if (index < 0) {

            index = -index - 1;
            System.arraycopy(storage, index, storage, index + 1, storage.length - index - 1);
            storage[index] = r;
            size++;

        } else {
            System.out.println("uuid" + r.uuid + "Already exist");
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
        int index = getIndex(uuid);
        if (index < 0)
            System.out.println("ERROR------Resume not exist");
        else {

            System.arraycopy(storage,index+1,storage,index,storage.length-size-index);
        }
//            for (int i = index; i < size; i++) {
//                storage[i] = storage[i + 1];
//            }
//            size--;
//      }

        size--;
    }


    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

    @Override
    public int size() {
        return size;
    }
}
