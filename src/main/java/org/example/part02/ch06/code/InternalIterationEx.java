package org.example.part02.ch06.code;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InternalIterationEx {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "apricot", "orange");

        List<String> newList = list.stream()
                .filter(s -> !s.startsWith("a"))
                .filter(s -> s.length() > 5)
                .collect(Collectors.toList());

        System.out.println(newList);
    }
}
