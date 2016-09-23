package com.urise.webapp;

import com.urise.webapp.model.SectionType;

/**
 * Created by Admin on 19.09.16.
 */
public class TestSingleton {
    private static TestSingleton ourInstance = new TestSingleton();

    public static TestSingleton getInstance() {
        return ourInstance;
    }

    private TestSingleton() {
    }

    public static void main(String[] args) {
        TestSingleton.getInstance().toString();
    Singleton instance=Singleton.valueOf("INSTANSE");
        System.out.println(instance);
        System.out.println(instance.ordinal());

        for (SectionType type:SectionType.values()
             ) {
            System.out.println(type.getTitle());
        }
    }
public enum Singleton{
    INSTANSE
}
}
