package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Admin on 14.09.16.
 */
public class MapStorage extends AbstractStorage{


    private Map<String, Resume> mapFName = new HashMap<>();



    @Override
    protected String getSearchKey(String fullname) {

        return String.valueOf(mapFName.get(fullname));
    }

    @Override
    protected void doUpdate(Resume r, Object searchKey) {

    }

    @Override
    protected boolean isExist(Object searchKey) {
        return searchKey != null;
    }

    @Override
    protected void doSave(Resume r, Object searchKey) {

    }

    @Override
    protected Resume doGet(Object searchKey) {
        return null;
    }

    @Override
    protected void doDelete(Object searchKey) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Resume[] getAll() {
        return new Resume[0];
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isResumeExist(Resume resume) {
        return false;
    }
}
