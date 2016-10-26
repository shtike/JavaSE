package com.urise.webapp.storage.serializer;

import com.urise.webapp.model.Resume;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Admin on 25.10.16.
 */
public interface StreamSerializer1 {

    void doWrite(Resume r, OutputStream os)throws IOException;

    Resume doRead(InputStream is) throws  IOException;
}
