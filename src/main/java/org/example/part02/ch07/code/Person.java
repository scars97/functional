package org.example.part02.ch07.code;

public class Person {

    String name;
    String city;

    Person(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return name;
    }
}
