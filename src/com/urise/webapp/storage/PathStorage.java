package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import com.urise.webapp.storage.serializer.StreamSerializer1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Admin on 10.10.16.
 */
public class PathStorage extends AbstractStorage<Path> {

    private Path directory;
    private   StreamSerializer1 streamSerializer1;


    public PathStorage(String dir, StreamSerializer1 streamSerializer1) {
        directory = Paths.get(dir);
        Objects.requireNonNull(dir, "directory must not be null");
        this.streamSerializer1=streamSerializer1;
        if (!Files.isDirectory(directory) || Files.isWritable(directory)) {
            throw new IllegalArgumentException(dir + "is not directory or is not writable");
        }
        this.directory = directory;
    }

    @Override
    public void clear() {

        getFilesList().forEach(this::doDelete);
    }

    @Override
    public int size() {

        return (int) getFilesList().count();
    }



    @Override
    protected Path getSearchKey(String uuid) {

        return directory.resolve(uuid);
    }

    @Override
    protected void doUpdate(Resume r, Path Path) {
        try {
            streamSerializer1.doWrite(r, new BufferedOutputStream(Files.newOutputStream(Path)));
        } catch (IOException e) {
            throw new StorageException("Path write error", r.getUuid(), e);
        }
    }

    @Override
    protected boolean isExist(Path path) {

        return Files.isRegularFile(path);

    }

    @Override
    protected void doSave(Resume r, Path path) {
        try {
            Files.createFile(path);
        } catch (IOException e) {
            throw new StorageException("Could not create path" + path, getFileName(path), e);
        }
        doUpdate(r, path);
    }

    @Override
    protected void doDelete(Path path) {
        try {
            Files.delete(path);
        } catch (IOException e) {
            throw new StorageException("Path delete error", getFileName(path), e);
        }
    }

    @Override
    protected Resume doGet(Path path) {
        try {
            return streamSerializer1.doRead(new BufferedInputStream(Files.newInputStream(path)));
        } catch (IOException e) {
            throw new StorageException("Path read error", getFileName(path), e);
        }
    }

    @Override
    protected List<Resume> doCopyAll() {
        return getFilesList().map(PathStorage.this::doGet).collect(Collectors.toList());
    }

    private String getFileName(Path path) {
        return path.getFileName().toString();
    }

    private Stream<Path> getFilesList() {
        try {
            return Files.list(directory);
        } catch (IOException e) {
            throw new StorageException("Directory read error", e);
        }
    }

    @Override
    public boolean isResumeExist(Resume resume) {
        return false;
    }
}