package com.urise.webapp.storage;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Created by Admin on 16.09.16.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ArrayStorageTest.class,
        SortedArrayStorageTest.class,
        ListStorageTest.class,
        MapUuidStorageTest.class,
        MapResumeStorageTest.class,
     //   ObjectFileStorageTest.class,
      //  ObjectPathStorageTest.class,
       // XmlPathStorageTest.class,
        //SqlStorageTest.class
})


public class AllStorageTest {

}
