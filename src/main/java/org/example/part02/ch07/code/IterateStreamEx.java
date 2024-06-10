package org.example.part02.ch07.code;

import java.util.UUID;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IterateStreamEx {

    public static void main(String[] args) {
        // 1
        /*for (int i = 1; i < 5 ; i++) {
            System.out.println(i);
        }*/

        // 2
        //IntStream.iterate(1, idx -> idx + 1).limit(4L).forEachOrdered(System.out::println);

        Stream.generate(UUID::randomUUID).limit(5L).forEach(System.out::println);
    }
}
