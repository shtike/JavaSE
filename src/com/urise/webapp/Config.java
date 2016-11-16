package com.urise.webapp;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Admin on 15.11.16.
 */
public class Config {
    private static final Config INSTANCE = new Config();
    protected static final File PROPS = new File("config\\resumes.properties ");
    private Properties props = new Properties();
    private File storageDir;

    public static Config get() {
        return INSTANCE;
    }

    private Config() {
        try {
            try (InputStream is = new FileInputStream(PROPS)) {
                props.load(is);
                storageDir=new File(props.getProperty("storage.dir"));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Invalid config file"+ PROPS.getAbsolutePath());


        }
    }

    public File getStorageDir() {
        return storageDir;
    }
}
