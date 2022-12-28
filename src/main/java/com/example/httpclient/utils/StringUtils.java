package com.example.httpclient.utils;

public class StringUtils {

    public static boolean isNotBlank(String str) {
        if (null!=str&&str.length()>0){
            return true;
        }
        return false;
    }
}
