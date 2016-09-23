package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.List;

/**
 * Array based storage for Resumes
 */
public interface Storage {


    void clear();

    void save(Resume r);

    Resume get(String uuid);

    void delete(String uuid);

    List<Resume> getAllSorted();


    void update(Resume r);
    public int size();

    boolean isResumeExist(Resume resume);
}


/**
 * Array based storage for Resumes
 */
