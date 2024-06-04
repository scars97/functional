package org.example.part02.ch06.code;

import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;

public class SpliteratorEx01 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "apricot", "orange");

        Spliterator<String> spliterator1 = list.spliterator();

        Spliterator<String> spliterator2 = spliterator1.trySplit();

        Spliterator<String> spliterator3 = spliterator2.trySplit();

        Spliterator<String> spliterator4 = spliterator3.trySplit();

        spliterator1.forEachRemaining(System.out::println);
        System.out.println("===========");
        spliterator2.forEachRemaining(System.out::println);
        System.out.println("===========");
        spliterator3.forEachRemaining(System.out::println);
        System.out.println("===========");
        spliterator4.forEachRemaining(System.out::println);
    }
}
