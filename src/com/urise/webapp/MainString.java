package com.urise.webapp;

/**
 * Created by Admin on 04.08.16.
 */
public class MainString {
    public static void main(String[] args) {
        String[] strArray = new String[]{"1","2","3","4","5"};
        //String result ="";
        StringBuilder sb = new StringBuilder();
        for (String str:strArray) {
            sb.append(str).append(",");        //result = result + str + ",";
        }
        System.out.println(sb);
        String str1 = "abc";
        String str3 = "c";
        String str2 = ("ab"+str3).intern();
        System.out.println(str1==str2);
    }

}
