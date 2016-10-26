package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import com.urise.webapp.storage.serializer.StreamSerializer1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Admin on 25.10.16.
 */
    public class FileStorage extends AbstractStorage<File> implements Serializable {
        private File directory;
        private StreamSerializer1 streamSerializer1;

        public FileStorage(File directory, StreamSerializer1 streamSerializer1) {
            Objects.requireNonNull(directory, "directory must not be null");
            this.streamSerializer1=streamSerializer1;
            this.directory = directory;
            if (!directory.isDirectory()) {
                throw new IllegalArgumentException(directory.getAbsolutePath() + "is not directory");
            }
            if (!directory.canRead() || !directory.canWrite()) {
                throw new IllegalArgumentException(directory.getAbsolutePath() + "is not readable/writable ");
            }
            this.directory = directory;
        }

        @Override
        public void clear() {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    doDelete(file);
                }
            }
        }

        @Override
        public int size() {
            String[] list = directory.list();
            if (list == null) {
                throw new StorageException("Directory read error" ,null,null);
            }
            return list.length;
        }

        @Override
        protected File getSearchKey(String uuid) {
            return new File(directory, uuid);
        }

        @Override
        protected void doUpdate(Resume r, File file) {
            try {
                streamSerializer1.doWrite(r,new BufferedOutputStream(new FileOutputStream(file)));
            } catch (IOException e) {
                throw new StorageException("File write error", r.getUuid(), e);
            }
        }

        @Override
        protected boolean isExist(File file) {
            return file.exists();
        }

        @Override
        protected void doSave(Resume r, File file) {
            try {
                file.createNewFile();

            } catch (IOException e) {
                throw new StorageException("Could not create file" + file.getAbsolutePath(), file.getName(), e);
            }
            doUpdate(r, file);
        }



        @Override
        protected Resume doGet(File file) {
            try {
                return streamSerializer1.doRead( new BufferedInputStream(new FileInputStream(file)));
            } catch (IOException e) {
                throw new StorageException("File read error", file.getName(), e);
            }
        }

        @Override
        protected void doDelete(File file) {
            if (!file.delete()) {
                throw new StorageException("File delete error", file.getName());
            }
        }

        @Override
        protected List<Resume> doCopyAll() {
            File[] files = directory.listFiles();
            if (files == null) {
                throw new StorageException("Directory read error", null,null);
            }
            List<Resume> list = new ArrayList<>(files.length);
            for (File file : files) {
                list.add(doGet(file));
            }
            return list;
        }


        @Override
        public boolean isResumeExist(Resume resume) {
            return false;
        }
    }


