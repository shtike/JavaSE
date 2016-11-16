package com.urise.webapp.storage.serializer;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.ContactType;
import com.urise.webapp.model.Resume;

import java.io.*;
import java.util.Map;

/**
 * Created by Admin on 31.10.16.
 */
public class DataStreamSerializer implements StreamSerializer1 {


    @Override
    public void doWrite(Resume r, OutputStream os) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(os)) {
            dos.writeUTF(r.getUuid());
            dos.writeUTF(r.getFullName());
            Map<ContactType, String> contacts = r.getContacts();
            dos.writeInt(contacts.size());
            for (Map.Entry<ContactType, String> entry : r.getContacts().entrySet()) {
                dos.writeUTF(entry.getKey().name());
                dos.writeUTF(entry.getValue());
            }
            //TODO implem sections
        }

    }

    @Override
    public Resume doRead(InputStream is) throws IOException {
        try (DataInputStream dis = new DataInputStream(is)) {
            String uuid = dis.readUTF();
            String fullName = dis.readUTF();
            Resume resume = new Resume(uuid, fullName);
        int size= dis.readInt();
            for (int i=0; i<size; i++){
                ContactType contactType = ContactType.valueOf(dis.readUTF());
               String value = dis.readUTF();
                resume.addContact(contactType, value);
            }

            //TODO implem sections
            return resume;
        }


    }


}
