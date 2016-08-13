package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public interface Storage {


    void clear();

    void save(Resume r);

    Resume get(String uuid);

    void delete(String uuid);

    Resume[] getAll();


    void update(Resume r);
    public int size();

    boolean isResumeExist(Resume resume);
}


/**
 * Array based storage for Resumes
 */
