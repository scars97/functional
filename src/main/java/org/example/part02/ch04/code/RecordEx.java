package org.example.part02.ch04.code;

public class RecordEx {

    public static void main(String[] args) {
        RecordPerson recordPerson = new RecordPerson("성현", 28);
        RecordPerson recordPerson2 = new RecordPerson("성현", 28);

        System.out.println(recordPerson.name());
        System.out.println(recordPerson.age());
        System.out.println(recordPerson.equals(recordPerson2));

        Person person = new Person("성현", 28);
        Person person2 = new Person("성현", 28);
        System.out.println(person.equals(person2));
    }

    public record RecordPerson(String name, int age) {}

    public static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}
