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
//        FileInputStream fis = null;
//        try {
//             fis  = new FileInputStream(filepath);
//            System.out.println(fis.read());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } finally {
//            if (fis!=null){
//                try {
//                    fis.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
//        }

        System.out.println("-------------------------------");
        File dirrecu= new File("D:\\JAVA---PROEKT\\resume-storage\\src");
        System.out.println( dirrecu.toString());
        File files[]=dirrecu.listFiles();
        for (File direccu: files){
            if (direccu!=null)
                System.out.println(direccu.getName()+file.isFile());

        }
public static void printDirectoryDeeply(){

        }


    }

}
