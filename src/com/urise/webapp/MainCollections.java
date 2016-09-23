package com.urise.webapp;

import com.urise.webapp.model.Resume;

import java.util.*;

/**
 * Created by Admin on 27.08.16.
 */
public class MainCollections {
    protected static final String UUID_1 = "uuid1";
    protected static final Resume RESUME_1 = new Resume(UUID_1,"Name1" );

    protected static final String UUID_2 = "uuid2";
    protected static final Resume RESUME_2 = new Resume(UUID_2,"Name2" );

    protected static final String UUID_3 = "uuid3";
    protected static final Resume RESUME_3 = new Resume(UUID_3, "Name3");

    protected static final String UUID_4 = "uuid4";
    protected static final Resume RESUME_4 = new Resume(UUID_4,"Name4" );

    public static void main(String[] args) {


        Collection<Resume> collection = new ArrayList<>();
        collection.add(RESUME_1);
        collection.add(RESUME_2);
        collection.add(RESUME_3);
        ArrayList al = (ArrayList) collection;


        for (Resume r:collection) {
            System.out.println(r);
            if (Objects.equals(r.getUuid(),UUID_1)){
             //   collection.remove(r);
            }
            System.out.println(collection.toString());
        }
        Iterator<Resume> iterator = collection.iterator();
        while (iterator.hasNext()){
            Resume r = iterator.next();
            System.out.println(r);
            if (Objects.equals(r.getUuid(),UUID_1)){
                iterator.remove();
            }
        }
        System.out.println(collection.toString()+"ctS");
        Map<String, Resume > map =new HashMap<>();
        map.put(UUID_1,RESUME_1);
        map.put(UUID_2,RESUME_2);
        map.put(UUID_3,RESUME_3);
        for (String uuid:map.keySet()){
            System.out.println(map.get(uuid));
        }
        for (Map.Entry<String,Resume> entry:map.entrySet()){
            System.out.println(entry.getValue());
        }
//        {
//            collection.clear();}
        System.out.println(al.size());
            collection.remove(RESUME_2);

        for (Resume r : collection) {
            System.out.println(r +"ura");
        }
        System.out.println("gde");


            for (Map.Entry<String,Resume>entry : map.entrySet()) {
                System.out.println(entry.getValue());
            }
        List<Resume> resumes = Arrays.asList(RESUME_1, RESUME_2, RESUME_3);
resumes.remove(1);
        System.out.println(resumes);
    }
    }

