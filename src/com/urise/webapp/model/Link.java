package com.urise.webapp.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by Admin on 23.09.16.
 */
public class Link implements Serializable{

    private static final long serialVersionUID = 1L;

    public final String name;
    public final String url;


    public Link(String name, String url) {
        Objects.requireNonNull(name, "name must not be null");
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "Link{" +
                "name='" + name + ',' +
                ", url='" + url + ',' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Link link = (Link) o;

        if (!name.equals(link.name)) return false;
        return url != null ? url.equals(link.url) : link.url == null;

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }
    public static void main(String args[]) {

        int[] index = new int[4];
        index[0] = 1;
        index[1] = 4;
        index[2] = 0;
        index[3] = 2;

        String[] islands = new String[4];
        islands[0] = "Бермуды";
        islands[1] = "Фиджи";
        islands[2] = "Азорские";
        islands[3] = "Косумель";
        int y = 0;
        int ref;

        while (y < 4) {

            ref = index[y];

            System.out.print("острова = ");

            System.out.println(islands[ref]);

            y = y + 1;
        }

    }
}
