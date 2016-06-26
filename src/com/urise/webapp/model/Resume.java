package com.urise.webapp.model;

/**
 * com.urise.webapp.model.com.urise.webapp.model.Resume class
 */
public class Resume {

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    // Unique identifier
   public String uuid;

    @Override
    public String toString() {
        return uuid;
    }
}
