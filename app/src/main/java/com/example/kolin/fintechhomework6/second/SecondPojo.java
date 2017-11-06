package com.example.kolin.fintechhomework6.second;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

/**
 * Created by kolin on 06.11.2017.
 */

public class SecondPojo {
    private String name;
    @SerializedName("any_map")
    private Map<String, String> anyMap;

    public SecondPojo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getAnyMap() {
        return anyMap;
    }

    public void setAnyMap(Map<String, String> anyMap) {
        this.anyMap = anyMap;
    }

    @Override
    public String toString() {
        return "SecondPojo{\n" +
                "   name='" + name + '\'' +
                ",\n   anyMap=" + anyMap + "\n" +
                '}';
    }
}
