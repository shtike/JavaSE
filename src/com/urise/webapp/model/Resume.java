package com.urise.webapp.model;

import java.util.UUID;

/**
 * com.urise.webapp.model.com.urise.webapp.model.Resume class
 */
public class Resume implements Comparable <Resume>{

    public Resume(){
        this(UUID.randomUUID().toString());
    }
    public Resume(String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resume resume = (Resume) o;

        return uuid.equals(resume.uuid);

    }



    @Override
    public int hashCode() {
        return uuid.hashCode();
    }



    // Unique identifier
   public final String uuid;

    @Override
    public String toString() {
        return uuid;
    }

    @Override
    public int compareTo(Resume o) {
        Integer int1 = Integer.parseInt(uuid);
        Integer int2 = Integer.parseInt(o.uuid);
        return int1.compareTo(int2);
    }
}
