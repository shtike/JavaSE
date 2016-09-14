package com.urise.webapp.storage;

import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;

/**
 * Created by Admin on 30.08.16.
 */
public class MapUuidStorage extends AbstractStorage {

    private Map<String, Resume> map = new HashMap<>();


    @Override
    protected String getSearchKey(String uuid) {

        return uuid;
    }

    @Override
    protected void doUpdate(Resume r, Object searchKey) {

        for (Map.Entry<String, Resume> entry : map.entrySet()) {
            if (entry.getValue() == r) {
                r = entry.getValue();
            }
        }
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return searchKey != null;
    }

    @Override
    protected void doSave(Resume r, Object searchKey) {
        map.put(r.getUuid(), r);
    }

    @Override
    protected Resume doGet(Object searchKey) {

        return map.get(searchKey);
    }

    @Override
    protected void doDelete(Object searchKey) {
        map.remove(searchKey);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Resume[] getAll() {
        String[][] array = new String[map.size()][2];
        int count = 0;
        for (Map.Entry<String, Resume> entry : map.entrySet()) {
            array[count][0] = entry.getKey();
            array[count][1] = String.valueOf(entry.getValue());
            count++;
        }
        return null;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isResumeExist(Resume resume) {
        return false;
    }


//    Map<String, Resume> resumeMap = new HashMap<>();
//    Resume resume = new Resume();
//
//    public void save(String Resume) {
//        resumeMap.put(resume.getUuid(), resume);
//    }
//
//    public void delete(String uuid) {
//        resumeMap.remove(uuid);
//    }
//
//    public Resume get(String uuid) {
//        return resumeMap.get(uuid);
//    }
//
//    public void update(Resume r) {
//        for (Map.Entry<String, Resume> entry : resumeMap.entrySet()) {
//            if (entry.getValue() == r) {
//                r = entry.getValue();
//            } else {
//                throw new NotExistStorageException(r.getUuid());
//            }
//        }
//        resumeMap.get(r);
//    }
//
//    public void getAll2() {
//        for (Map.Entry<String, Resume> entry : resumeMap.entrySet()) {
//            entry.getValue();
//        }
//    }
//
//    public void clear() {
//        resumeMap.clear();
//    }
//
//
//    @Override
//    protected void fillDeletedElement(int index) {
//
//    }
//
//    @Override
//    protected void insertElement(Resume r, int index) {
//
//    }
//
//    @Override
//    protected Integer getSearchKey(String uuid) {
//        return 0;
//    }
}
