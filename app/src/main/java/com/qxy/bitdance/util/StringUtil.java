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

    public static String  numNarrow(long l) {
        if (l < 10000) {
            return String.valueOf(l);
        } else {
            return String.format("%.1f万",l / 10000.0);
        }
    }

    public static String arrayToStringTop5(String[] value) {
        if (value == null) {
            return "";
        }
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < 5 && i < value.length) {
            sb.append(value[i ++]);
            if (i != 5 && i != value.length)
                sb.append("/");
        }
        return sb.toString();
    }
}
