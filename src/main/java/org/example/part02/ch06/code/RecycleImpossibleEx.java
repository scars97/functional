package org.example.part02.ch06.code;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RecycleImpossibleEx {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "apricot", "orange");

        Stream<String> originStream = list.stream();

        List<String> newList = originStream
                .filter(s -> !s.startsWith("a"))
                .filter(s -> s.length() > 5)
                .collect(Collectors.toList());

        System.out.println(newList);

        List<String> recycleStream = originStream
                .map(s -> s.toUpperCase())
                .collect(Collectors.toList());

        System.out.println(recycleStream);
    }
}
