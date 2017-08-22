package com.company.project.demoweb.common;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by wangzhj on 2017/8/11.
 */
public class JsonUtil {

    public static String toJson(Object obj) {
        ObjectMapper mapper = new ObjectMapper();
        String str = null;
        try {
            str = mapper.writeValueAsString(obj);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return str;
    }

    public static <T> T fromJson(String str) {
        ObjectMapper mapper = new ObjectMapper();
        T t = null;
        try {
            t = mapper.readValue(str, new TypeReference<T>() {
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return t;
    }
}
