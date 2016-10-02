package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * Created by Admin on 25.09.16.
 */
public abstract class AbstractFileStorage extends AbstractStorage<File> {
    private File directory;

    public AbstractFileStorage(File directory) {
        Objects.requireNonNull(directory, "directory must not be null");
        this.directory = directory;
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + "is not directory");
        }
        if (!directory.canRead() || !directory.canWrite()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + "is not readable/writable ");
        }
    this.directory=directory;
    }

    @Override
    public void clear() {
directory.delete();
    }

    @Override
    public int size() {
        directory.isFile();
        return 0;
    }

    @Override
    protected File getSearchKey(String uuid) {
        return new File(directory,uuid );
    }

    @Override
    protected void doUpdate(Resume r, File file) {

    }

    @Override
    protected boolean isExist(File file) {
        return file.exists();
    }

    @Override
    protected void doSave(Resume r, File file) {
        try {
            file.createNewFile();
            doWrite(r,file);
        } catch (IOException e) {
            throw new StorageException("IO error",file.getName(),e);
        }
    }

    protected abstract void doWrite(Resume r, File file);

    @Override
    protected Resume doGet(File file) {
        return null;
    }

    @Override
    protected void doDelete(File file) {

    }

    @Override
    protected List<Resume> doCopyAll() {
        return null;
    }


    @Override
    public boolean isResumeExist(Resume resume) {
        return false;
    }
}
