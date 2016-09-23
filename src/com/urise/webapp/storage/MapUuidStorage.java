package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;

/**
 * Created by Admin on 30.08.16.
 */
public class MapUuidStorage extends AbstractStorage<String> {

    private Map<String, Resume> map = new HashMap<>();


    @Override
    protected String getSearchKey(String uuid) {

        return uuid;
    }

    @Override
    protected void doUpdate(Resume r, String uuid) {
        map.put( uuid,r);
    }

    @Override
    protected boolean isExist(String uuid) {
        return map.containsKey(uuid);
    }

    @Override
    protected void doSave(Resume r, String uuid) {
        map.put( uuid,r);
    }

    @Override
    protected Resume doGet(String uuid) {

        return   map.get( uuid);
    }

    @Override
    protected void doDelete(String uuid) {
        map.remove( uuid);
    }

    @Override
    protected List<Resume> doCopyAll() {

        return new ArrayList<>(map.values());
    }

    @Override
    public void clear() {
        map.clear();
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
