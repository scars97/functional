package org.example.part02.ch05.code;

import java.lang.reflect.RecordComponent;

public class RecordReflection {

    public static void main(String[] args) {
        RecordComponent[] components = Person.class.getRecordComponents();

        for (RecordComponent component : components) {
            System.out.println(component.getName());
            System.out.println(component.getType());
            System.out.println();
        }
    }

    public record Person(String name, int age) { }

}
