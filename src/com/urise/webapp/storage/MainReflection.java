package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by Admin on 04.08.16.
 */
public class MainReflection {

    public static void main(String[] args) throws IllegalAccessException {

        Resume r = new Resume();
        Field field = r.getClass().getDeclaredFields()[0];
        Method m = r.getClass().getDeclaredMethods()[1];
        System.out.println(field.getName());
        field.get(r);
        System.out.println(r);
        System.out.println(m.getName());



        System.out.println((r.poehaliToString())+"------------------------------------");

        //TODO: invoke r.toString via reflection

        Class clazz = MainReflection.class;
        System.out.println(clazz.getSimpleName());
        Package p = clazz.getPackage();
        System.out.println("Package " + p.getName() + ";");
        System.out.println(clazz.getDeclaredFields());
        int modifiers = clazz.getModifiers();
        System.out.println(clazz.getModifiers());
        System.out.print("class " + clazz.getSimpleName() + " ");
        System.out.println("Extends " + clazz.getSuperclass().getSimpleName());
//        for (java.lang.reflect.Method  m :clazz.getClass().getDeclaredMethods()) {
//            System.out.println(m.getName());
//
//        }
    }

}
