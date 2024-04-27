package org.example.ch01;

import java.util.function.Function;

public class Foundation {

    public static void main(String[] args) {
        Function<Integer, Integer> q =
                value -> value + value;

        System.out.println();
    }
}
