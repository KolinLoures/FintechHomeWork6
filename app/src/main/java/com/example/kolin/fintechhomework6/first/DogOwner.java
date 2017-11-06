package com.example.kolin.fintechhomework6.first;

/**
 * Created by kolin on 06.11.2017.
 */

public class DogOwner {

    private int id;
    private String fio;
    private int age;
    private Dog dog;

    public DogOwner() {
    }

    public DogOwner(int id, String fio, int age, Dog dog) {
        this.id = id;
        this.fio = fio;
        this.age = age;
        this.dog = dog;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "DogOwner{\n" +
                "   id=" + id +
                ",\n        fio='" + fio + '\'' +
                ",\n        age=" + age +
                ",\n        dog=" + dog + " \n" +
                '}';
    }
}
