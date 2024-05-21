package org.example.part02.ch04.code;

import java.util.*;

public class ImmutableCollection {

    public static void main(String[] args) {

        // 변경 불가능한 컬렉션
        List<String> list = new ArrayList<>();
        list.add("1");
        System.out.println(list.get(0));

        List<String> immutableList = Collections.unmodifiableList(list);

        /*immutableList.add("1");
        System.out.println(immutableList.get(0));*/

        list.add("2");

        System.out.println(immutableList.size());

        // 불변 컬렉션 팩토리 메서드
        List<String> listOf = List.of("1", "2");

        listOf.add("3");
        System.out.println(list.size());

        // 불변 복제
        List<String> original = new ArrayList<>();
        original.add("blue");
        original.add("red");

        List<String> copy = List.copyOf(original);
        original.add("green");

        System.out.println(original);
        System.out.println(copy);
    }
}
