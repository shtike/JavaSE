package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Created by Admin on 04.07.16.
 */
public class SortedArrayStorage extends AbstractArrayStorage {


        @Override
    protected void insertElement(Resume r, int index) {
        //      http://codereview.stackexchange.com/questions/36221/binary-search-for-inserting-in-array#answer-36239
        int insertIdx = -index - 1;
        System.arraycopy(storage, insertIdx, storage, insertIdx + 1, size - insertIdx);
        storage[insertIdx] = r;
    }
 //   @Override
 //   protected void insertElement(Resume r, int index) {             // HANMADE  SAVE!
//        System.out.println( index);
//        if (index == -1)
//            storage[0] = r;
//        else {
//            for (int i = size; i >= -index-1; i--) {
//
//                storage[i] = storage[i - 1];
//                if (i == -index-1)
//                    storage[i] = r;
//            }
//        }
//    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume(uuid);

        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

    public int binarySearch(Resume r) {
        if (size == 0)
            return -1;
        int lowerBound = 0;
        int upperBound = size - 1;
        int seredina = 0;
        while (true) {
            seredina = (upperBound + lowerBound) / 2;
            System.out.println(seredina);
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

    @Override
    public void delete(String uuid) {
        Resume r = new Resume(uuid);

        int index = binarySearch(r);
        if (index < 0)
            System.out.println("ERROR------Resume not exist");
        else {

            fillDeletedElement(index);
            storage[size - 1] = null;
            size--;
        }

    }

    @Override
    protected void fillDeletedElement(int index) {
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(storage, index + 1, storage, index, numMoved);
        }
    }


}

