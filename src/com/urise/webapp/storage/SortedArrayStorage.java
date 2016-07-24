package com.urise.webapp.storage;

import com.sun.org.apache.xpath.internal.SourceTree;
import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

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


//    @Override
//    public void sortSave(Resume r) {
//        Arrays.sort(storage,0,size);
//        Resume[] sortedstor = new Resume[storageSize];
//        System.arraycopy(storage, 0, sortedstor, 0, storageSize);
//       System.out.println("tgt"+(sortedstor));
//    }


    @Override
    public void save(Resume r) {
        int index = Arrays.binarySearch(storage, 0, size, r);

        if (size == storageSize) {
            System.out.println("Storage overflow");
        } else if (index < 0) {

            index = -index - 1;
            System.arraycopy(storage, index, storage, index + 1, storage.length - index - 1);
            storage[index] = r;
            size++;

//        if (size == storageSize)
//            System.out.println("Can not add more elements.");
//        int index = Arrays.binarySearch(storage, 0, size, r);
//        System.out.println(index);
//        if (index < 0) {
//            // this is a new value to insert (not a duplicate).
//            index = -index - 1;
//
//        }
//        System.arraycopy(storage, index, storage, index + 1, size - index);
//        storage[index] = r;
//        size++;
        }
else{
            System.out.println("Already exist");}
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
    public void update(Resume r) {

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
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

    @Override
    public void update() {


    }


    @Override
    public int size() {
        return size;
    }
}
