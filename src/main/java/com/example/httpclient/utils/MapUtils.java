package com.example.httpclient.utils;

import java.util.Map;

public class MapUtils {
    public static boolean isNotEmpty(Map map) {
        if (null != map && !map.isEmpty()) {
            return true;
        }
        return false;
    }
}
