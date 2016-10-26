package com.urise.webapp.storage.serializer;

import com.urise.webapp.Util.XmlParser;
import com.urise.webapp.model.*;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Created by Admin on 26.10.16.
 */
public class XmlStreamSerializer implements StreamSerializer1{

     private XmlParser xmlParser;

    public XmlStreamSerializer(){
        xmlParser= new XmlParser(
                Resume.class, Organization.class, Link.class,
                OrganizationSection.class, TextSection.class, ListSection.class,Organization.Position.class
        );
    }


    @Override
    public  void doWrite(Resume r, OutputStream os) throws IOException{
        try (Writer w = new OutputStreamWriter(os, StandardCharsets.UTF_8)) {
        xmlParser.marshall(r, w);
        }
    }

    @Override
    public Resume doRead(InputStream is)throws IOException{
        try (Reader r = new InputStreamReader(is, StandardCharsets.UTF_8)){
        return xmlParser.unmarshall(r);
        }
    }
}
