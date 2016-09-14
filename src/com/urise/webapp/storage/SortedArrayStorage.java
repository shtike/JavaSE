package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Admin on 04.07.16.
 */
public class SortedArrayStorage extends AbstractArrayStorage {
    //    static class ResumeComparator implements Comparator<Resume> {
//        @Override
//        public int compare(Resume o1, Resume o2) {
//            return o1.getUuid().compareTo(o2.getUuid());
//        }
//    }
    private static final Comparator<Resume> RESUME_COMPARATOR = (o1, o2) -> o1.getUuid().compareTo(o2.getUuid());


    public Method poehaliToString() {
        Resume r = new Resume();
        Method mo = r.getClass().getDeclaredMethods()[1];
        return mo;
    }

    @Override
    protected void fillDeletedElement(int index) {
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(storage, index + 1, storage, index, numMoved);
        }
    }

    @Override
    protected void insertElement(Resume r, int index) {
        //      http://codereview.stackexchange.com/questions/36221/binary-search-for-inserting-in-array#answer-36239
        int insertIdx = -index - 1;
        System.arraycopy(storage, insertIdx, storage, insertIdx + 1, size - insertIdx);
        storage[insertIdx] = r;
    }

    @Override
    protected Integer getSearchKey(String uuid) {
        Resume searchKey = new Resume(uuid);

        return Arrays.binarySearch(storage, 0, size, searchKey, RESUME_COMPARATOR);
    }


    @Override
    public boolean isResumeExist(Resume resume) {

        return false;
    }


}
