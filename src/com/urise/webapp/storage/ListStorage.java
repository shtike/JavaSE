package com.urise.webapp.storage;

import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.*;

/**
 * Created by Admin on 30.08.16.
 */
public class ListStorage extends AbstractArrayStorage {
    protected static final String UUID_1 = "uuid1";
    protected static final Resume RESUME_1 = new Resume(UUID_1);

    protected static final String UUID_2 = "uuid2";
    protected static final Resume RESUME_2 = new Resume(UUID_2);

    protected static final String UUID_3 = "uuid3";
    protected static final Resume RESUME_3 = new Resume(UUID_3);

    protected static final String UUID_4 = "uuid4";
    protected static final Resume RESUME_4 = new Resume(UUID_4);

    List<Resume> resumeList = new ArrayList<>();
    ArrayList al2 = new ArrayList();
    ArrayList al = (ArrayList) resumeList;
    Iterator<Resume> iterator = resumeList.iterator();
    Resume resume = new Resume();

    public void clear() {

        resumeList.clear();
    }

    public void save(Resume r) {

        resumeList.add(r);
    }

    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (resumeList.contains(r) == true)
            al.add(index);
        else throw new NotExistStorageException(r.getUuid());

    }

    public void getAll1() {
        for (Resume r : resumeList) {
            System.out.println(r);
        }
    }

    public Resume get(String uuid) {

        for (Resume r : resumeList) {
            r.getUuid().equals(uuid);
            if (r.getUuid() == uuid) {
                return r;
            } else throw new NotExistStorageException(r.getUuid());
        }
        return  null;
    }


    public void delete(String uuid) {
        resumeList.remove(uuid);
    }


    @Override
    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }


    @Override
    protected void fillDeletedElement(int index) {

    }

    @Override
    protected void insertElement(Resume r, int index) {

    }


}
