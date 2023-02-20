package com.co.blankfactor.rest.utils;

import com.google.gson.Gson;

import java.util.Map;

public class JsonUtilities {
    public static <T> String getJson(T object){
        final Gson gson = new Gson();
        return gson.toJson(object);
    }

    public static Map convertJson(String object){
        final Gson gson = new Gson();
        return gson.fromJson(object, Map.class);
    }
}
