package com.urise.webapp.storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


/**
 * Created by Admin on 25.09.16.
 */
public class MainFile {
    public static void main(String[] args) {
        String filepath = ".\\.gitignore";
        File file = new File("D:\\JAVA---PROEKT\\resume-storage");
        try {
            System.out.println(file.getCanonicalPath());
        } catch (IOException e) {
            throw new RuntimeException("Error", e);
        }
        File dir = new File("D:\\JAVA---PROEKT\\resume-storage\\src\\com\\urise\\webapp");
        System.out.println(dir.isDirectory());
        String[] list = dir.list();
        if (list != null) {
            for (String name : dir.list()) {
                System.out.println(name);
            }
        }
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(filepath);
            System.out.println(fis.read());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            printDirectoryDeeply(dir);
        }

        System.out.println("-------------------------------");
    }

    public static void printDirectoryDeeply(File dir) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("         File:" + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println("Directory:" + file.getName());
                    printDirectoryDeeply(file);
                }
            }
        }
    }

}

