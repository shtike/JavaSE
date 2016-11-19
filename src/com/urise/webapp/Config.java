package com.urise.webapp;



import com.urise.webapp.storage.SqlStorage;
import com.urise.webapp.storage.Storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Admin on 15.11.16.
 */
public class Config {

    private static final File PROPS = new File("config\\resumes.properties ");
    private static final Config INSTANCE = new Config();

    private final File storageDir;
    private final Storage storage;

    public static Config get() {
        return INSTANCE;
    }

    private Config() {
        try {
            try (InputStream is = new FileInputStream(PROPS)) {
                Properties props = new Properties();
                props.load(is);
                storageDir=new File(props.getProperty("storage.dir"));
                storage= new SqlStorage(props.getProperty("db.url"), props.getProperty("db.user"), props.getProperty("db.password"));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Invalid config file"+ PROPS.getAbsolutePath());


        }
    }

    public File getStorageDir() {
        return storageDir;
    }

    public Storage getStorage() {
        return storage;
    }
}
