package com.urise.webapp.Util;

/**
 * Created by Admin on 05.11.16.
 */
public class LazySingleton {
    int i;
    volatile private static LazySingleton INSTANCE;
    double sin = Math.sin(12.4);

    private LazySingleton() {
    }

    private static class LazySingletonHolder {
        private static final LazySingleton INSTANCE = new LazySingleton();


//        public static LazySingleton getInstance() {
//            return LazySingleton.INSTANCE;
//            if (INSTANCE == null) {
//                synchronized (LazySingleton.class) {
//                    //if (INSTANCE == null) {
//                    //int i=13;
//                    // INSTANCE = new LazySingleton();
//                    //}
//                    //}
//                }
//                return INSTANCE;
//            }
//        }
    }
}
