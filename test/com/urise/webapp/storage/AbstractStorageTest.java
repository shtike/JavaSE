package com.urise.webapp.storage;

import com.urise.webapp.Config;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.*;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Admin on 13.08.16.
 */
public abstract class AbstractStorageTest {

    public static final File STORAGE_DIR = Config.get().getStorageDir();
    protected Storage storage = new ArrayStorage();
    protected static final String UUID_1 = "uuid1";
    protected static final String UUID_2 = "uuid2";
    protected static final String UUID_3 = "uuid3";
    protected static final String UUID_4 = "uuid4";

    private static Resume R1 = new Resume(UUID_1, "Name1");
    private static Resume R2 = new Resume(UUID_2, "Name2");
    private static Resume R3 = new Resume(UUID_3, "Name3");
    private static Resume R4 = new Resume(UUID_4, "Name4");

    static {
        R1 = new Resume(UUID_1, "Name1");
        R2 = new Resume(UUID_2, "Name2");
        R3 = new Resume(UUID_3, "Name3");
        R4 = new Resume(UUID_4, "Name4");
        R1.addContact(ContactType.MAIL, "mail@ya.ru");
        R1.addContact(ContactType.PHONE, "11111");
        R1.addSection(SectionType.OBJECTIVE, new TextSection("Objective1"));
        R1.addSection(SectionType.ACHIEVEMENT, new ListSection("Achivment11", "Achivment12", "Achivment13"));
        R1.addSection(SectionType.QUALIFICATIONS, new ListSection("Java", "SQL", "Javascript"));
        R1.addSection(SectionType.EXPERIENCE,
                new OrganizationSection(
                        new Organization("Organization11", "http://Organization11.ru",
                                new Organization.Position(2005, Month.JANUARY, "position1", "content1"),
                                new Organization.Position(2001, Month.MARCH, 2005, Month.JANUARY, "position2", "content2"))));
        R1.addSection(SectionType.EDUCATION,
                new OrganizationSection(
                        new Organization("institute", null,
                                new Organization.Position(1996, Month.JANUARY, 2000, Month.DECEMBER, "aspirant", null),
                                new Organization.Position(2001, Month.MARCH, 2005, Month.JANUARY, "student", "IT facultet")),
                        new Organization("Organization12", "http://Organization12.ru")));
        R2.addContact(ContactType.SKYPE, "skype2");
        R2.addContact(ContactType.PHONE, "2222");
        R1.addSection(SectionType.EXPERIENCE,
                new OrganizationSection(
                        new Organization("Organization2", "http://Organization2.ru",
                                new Organization.Position(2015, Month.JANUARY, "position1", "content1"))));


    }


    public AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(new Resume(UUID_1, "Name1"));
        storage.save(new Resume(UUID_2, "Name2"));
        storage.save(new Resume(UUID_3, "Name3"));

    }

    @Test
    public void size() throws Exception {
        assertSize(3);
    }

    @Test
    public void get() throws Exception {
        assertGet(R1);
        assertGet(R2);
        assertGet(R3);
    }

    @Test
    public void clear() throws Exception {
        storage.clear();
        assertSize(0);
    }

    @Test
    public void update() throws Exception {
        storage.delete(UUID_1);
        Resume newResume = new Resume(UUID_1, "New Name");
        storage.save(newResume);
        assertTrue(newResume.equals(storage.get(UUID_1)));
    }

    @Test
    public void getAllSorted() throws Exception {
        List<Resume> list = storage.getAllSorted();
        assertEquals(3, list.size());
        assertEquals(list, Arrays.asList(R1, R2, R3));

    }

    @Test
    public void save() throws Exception {
        storage.save(R4);
        assertSize(4);
        assertEquals(R4, storage.get(UUID_4));
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() throws Exception {
        storage.delete(UUID_1);
        assertSize(2);
        storage.get(UUID_1);
    }


    @Test
    public void fillDeletedElement() throws Exception {

    }

    @Test
    public void insertElement() throws Exception {

    }


    @Test
    public void getIndex() throws Exception {

    }

    private void assertGet(Resume r) {
        assertEquals(r, storage.get(r.uuid));
    }

    private void assertSize(int size) {
        assertEquals(size, storage.size());
    }


}