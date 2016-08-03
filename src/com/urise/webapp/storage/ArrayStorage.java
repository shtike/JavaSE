package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {


    public void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    public void save(Resume r) {
        if (isResumeExist(r))
            System.out.println("ERROR---------Storage is full");

        else if(getIndex(r.getUuid()) != -1)
            System.out.println("ERROR------- "+ r.getUuid() +" --Resume allready exist");
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
    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

//    public void update(Resume r) {
//
//        int index = getIndex(r.getUuid());
//        if (index ==-1){
//            System.out.println("Resume"+r.getUuid()+"not exist");
//        } else {
//            storage[index] = r;
//        }


    // }


}