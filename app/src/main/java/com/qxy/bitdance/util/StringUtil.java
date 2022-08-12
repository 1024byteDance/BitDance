package com.qxy.bitdance.util;


public class StringUtil {

    public static String arrayToString(String[] value) {
        StringBuilder sb = new StringBuilder();
        if (value == null) {
            return "";
        }
        for (String s : value) {
            if (!s.equals(value[0])) {
                sb.append(",");
            }
            sb.append(s);
        }
        return sb.toString();
    }

}
