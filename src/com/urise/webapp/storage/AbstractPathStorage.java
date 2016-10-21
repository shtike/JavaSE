package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * Created by Admin on 10.10.16.
 */
public abstract class AbstractPathStorage extends AbstractStorage<Path> {

    private Path directory;



    protected abstract void doWrite(Resume r, OutputStream os) throws IOException;

    protected abstract Resume doRead(InputStream is) throws IOException;

    protected AbstractPathStorage(String dir) {
        directory = Paths.get(dir);
        Objects.requireNonNull(directory, "directory must not be null");
        if (!Files.isDirectory(directory) || Files.isWritable(directory)) {
            throw new IllegalArgumentException(dir + "is not directory or is not writable");
        }
        this.directory = directory;
    }

    @Override
    public void clear() {
        try {
            Files.list(directory).forEach(this::doDelete);
        } catch (IOException e) {
            throw new StorageException("Path delete error", null);
        }

    }

    @Override
    public int size() {
//        String[] list = directory();
//        if (list == null) {
//            throw new StorageException("Directory read error", null);
//        }
        return 0;
    }

    @Override
    protected Path getSearchKey(String uuid) {

        return directory.resolve(uuid);
    }

    @Override
    protected void doUpdate(Resume r, Path searchKey) {

    }

    @Override
    protected boolean isExist(Path searchKey) {

        return Files.isDirectory(searchKey);

    }

    @Override
    protected void doSave(Resume r, Path searchKey) {

    }

    @Override
    protected void doDelete(Path searchKey) {
        try {
            Files.delete(directory) ;
        } catch (IOException e) {
            throw new StorageException("Directory delete error", null);
        }
    }

    @Override
    protected Resume doGet(Path searchKey) {

        return null;
    }

    @Override
    protected List<Resume> doCopyAll() {
        return null;
    }

}