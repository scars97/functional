package org.example.part02.ch07.code;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DownStreamCollectorEx {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("John", "New York"),
                new Person("Jane", "New York"),
                new Person("Jake", "Los Angeles"),
                new Person("Mary", "Los Angeles"),
                new Person("Gary", "New York")
        );

        Map<String, List<String>> peopleByCity = people.stream()
                .collect(Collectors.groupingBy(
                        Person::getCity,
                        Collectors.mapping(Person::getName, Collectors.toList())
                ));

        System.out.println(peopleByCity);
    }
}
