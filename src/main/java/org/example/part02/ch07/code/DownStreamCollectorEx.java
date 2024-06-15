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
                // 사람들을 도시별로 그룹화 -> groupingBy은 상위 컬렉터
                .collect(Collectors.groupingBy(
                        Person::getCity,
                        // 그룹 내에서 이름을 리스트로 수집 -> mapping은 다운스트림 사용된다.
                        Collectors.mapping(Person::getName, Collectors.toList())
                ));

        System.out.println(peopleByCity);
        // {New York=[John, Jane, Gary], Los Angeles=[Jake, Mary]}
    }
}
