package org.example.part02.ch06.code;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LazyEvaluationEx {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "apricot", "orange");

        Stream<String> stream = list.stream()
                                    .filter(s -> {
                                        System.out.println("filter: " + s);
                                        return s.startsWith("a");
                                    })
                                    .map(s -> {
                                        System.out.println("map: " + s);
                                        return s.toUpperCase();
                                    });

        System.out.println("중간 연산은 실행되지 않는다.");

        List<String> result = stream.collect(Collectors.toList());

        System.out.println("최종 연산");

        System.out.println(result);
    }
}
