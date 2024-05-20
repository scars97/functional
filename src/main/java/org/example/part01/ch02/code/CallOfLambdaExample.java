package org.example.part01.ch02.code;

import java.util.function.Function;

public class CallOfLambdaExample {

    public static void main(String[] args) {
        Function<Integer, String> test = name -> "hello, " + name + "!";

    }
}
