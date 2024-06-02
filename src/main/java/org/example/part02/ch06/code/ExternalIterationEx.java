package org.example.part02.ch06.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExternalIterationEx {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "apricot", "orange");

        List<String> newList = new ArrayList<>();

        for (String s : list) {
            if (s.startsWith("a")) {
                continue;
            }

            if (s.length() <= 5) {
                continue;
            }

            newList.add(s);
        }

        System.out.println(newList);
    }
}
