package com.urise.webapp.storage;

import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Admin on 30.08.16.
 */
public class MapStorage extends AbstractArrayStorage {

    Map<String, Resume> resumeMap = new HashMap<>();
    Resume resume = new Resume();

    public void save(String Resume) {
        resumeMap.put(resume.getUuid(), resume);
    }

    public void delete(String uuid) {
        resumeMap.remove(uuid);
    }

    public Resume get(String uuid) {
        return resumeMap.get(uuid);
    }

    public void update(Resume r) {
        for (Map.Entry<String, Resume> entry : resumeMap.entrySet()) {
            if (entry.getValue() == r) {
                r = entry.getValue();
            } else {
                throw new NotExistStorageException(r.getUuid());
            }
        }
        resumeMap.get(r);
    }

    public void getAll2() {
        for (Map.Entry<String, Resume> entry : resumeMap.entrySet()) {
            entry.getValue();
        }
    }

    public void clear() {
        resumeMap.clear();
    }


    @Override
    protected void fillDeletedElement(int index) {

    }

    @Override
    protected void insertElement(Resume r, int index) {

    }

    @Override
    protected int getIndex(String uuid) {
        return 0;
    }
}
