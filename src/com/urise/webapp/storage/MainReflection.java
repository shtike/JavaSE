package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.lang.reflect.Field;

/**
 * Created by Admin on 04.08.16.
 */
public class MainReflection {

    public static void main(String[] args) throws IllegalAccessException {

        Resume r = new Resume();
        Field field = r.getClass().getDeclaredFields()[0];
        System.out.println(field.getName());
        field.get(r);
        System.out.println(r);
        //TODO: invoke r.toString via reflection

        System.out.println(field.getName()+ field.get(r)+ field.getModifiers()+ field.toString());
    }
}
