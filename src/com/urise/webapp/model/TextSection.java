package com.urise.webapp.model;

import java.util.Objects;

/**
 * Created by Admin on 21.09.16.
 */
public class TextSection extends Section {
    private static final long serialVersionUID = 1L;

    private String content;

    public TextSection() {
    }

    public TextSection(String content) {
        Objects.requireNonNull(content,"organizations must not be null");
        this.content = content;

    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return content;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TextSection that = (TextSection) o;

        return content.equals(that.content);

    }

    @Override
    public int hashCode() {
        return content.hashCode();
    }
}
