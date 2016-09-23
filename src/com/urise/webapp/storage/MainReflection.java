package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Admin on 04.08.16.
 */
public class MainReflection {

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {

        Resume r = new Resume("Name");
        Field field = r.getClass().getDeclaredFields()[0];
        //---------KAK INVOKE SDELAL GRIGORIY------------
        Class<? extends Resume> resumeClass = r.getClass();
        field.setAccessible(true);
        System.out.println(field.getName());
        System.out.println(field.get(r));
        field.set(r, "new uuid");
        Method method = resumeClass.getMethod("toString");
        Object result = method.invoke(r);
        System.out.println(result);

        //---------KAK INVOKE SDELAL YA------------


        Method m = r.getClass().getDeclaredMethods()[1];
        System.out.println(m + "-+-+-+-+-+-");

        field.get(r);
        System.out.println(r + " This is r resume");
        System.out.println(m.getName() + "   *************");
        //System.out.println(m.invoke(new Resume(),null));
        System.out.println(m.invoke(r).toString());

        System.out.println((r.toString()) + "------------------------------------");


        // System.out.println((r.poehaliToString()) + "-------------------------------------");

        //TODO: invoke r.toString via reflection

//        Class clazz = MainReflection.class;
//        System.out.println(clazz.getSimpleName());
//        Package p = clazz.getPackage();
//        System.out.println("Package " + p.getName() + ";");
//        System.out.println(clazz.getDeclaredFields());
//        int modifiers = clazz.getModifiers();
//        System.out.println(clazz.getModifiers());
//        System.out.print("class " + clazz.getSimpleName() + " ");
//        System.out.println("Extends " + clazz.getSuperclass().getSimpleName());
//        for (int i =0; i<6; i++)
//                //(java.lang.reflect.Method mx :clazz.getClass().getDeclaredMethods()) {
//        { System.out.println(m.getName());
//        }
//        Method method = cls.getDeclaredMethod("printIt", noparams);
//        method.invoke(m, null);
    }

}
