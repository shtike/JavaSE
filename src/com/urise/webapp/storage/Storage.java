package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.Objects;

/**
 * Array based storage for Resumes
 */
public interface Storage {


    void clear();

    void save(Resume r);

    Resume get(String uuid);

    void delete(String uuid);

    Resume[] getAll();


    int update();

}

/**
 * Array based storage for Resumes
 */
