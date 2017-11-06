package com.example.kolin.fintechhomework6.first;

/**
 * Created by kolin on 06.11.2017.
 */

public class Dog {

    private String name;
    private int type;

    public Dog() {
    }

    public Dog(String name, int type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Dog{\n" +
                "           name='" + name + '\'' +
                ",\n            type=" + type + " \n        "+
                '}';
    }
}
