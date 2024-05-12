package org.example.ch03.functionalinterface;

import java.util.function.Consumer;

public class ConsumerEx {

    public static void main(String[] args) {
        Consumer<String> println = str -> System.out.println(str);
        println.accept("Hello");


        println("hello");
    }

    static void println(String str) {
        System.out.println(str);
    }
}
