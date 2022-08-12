package com.qxy.bitdance.database.converter;

import androidx.room.TypeConverter;

import com.qxy.bitdance.util.StringUtil;

//数据转换器
public class StringArrayConverters {

    @TypeConverter
    public static String[] StringToArray(String value) {
        if (value == null || value.length() == 0) return new String[]{};
        return value.split(",");
    }

    @TypeConverter
    public static String fromString(String[] value) {
        return StringUtil.arrayToString(value);
    }
}
