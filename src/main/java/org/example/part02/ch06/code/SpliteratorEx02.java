package org.example.part02.ch06.code;

import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class SpliteratorEx02 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "apricot", "orange");

        Spliterator<String> spliterator1 = list.spliterator();
        Spliterator<String> spliterator2 = spliterator1.trySplit();

        processSpliterator(spliterator1);
        System.out.println("=======");

        if (spliterator2 != null) {
            processSpliterator(spliterator2);
            Spliterator<String> spliterator3 = spliterator2.trySplit();
            if (spliterator3 != null) {
                System.out.println("======");
                processSpliterator(spliterator3);
            }
        }
    }

    private static void processSpliterator(Spliterator<String> spliterator) {
        Consumer<String> action = System.out::println;
        while (spliterator.tryAdvance(action));
    }
}
