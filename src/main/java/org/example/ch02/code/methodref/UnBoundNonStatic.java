package org.example.ch02.code.methodref;

import java.util.function.Function;

public class UnBoundNonStatic {

    public static void main(String[] args) {
        Function<String, String> toLowerCaseRef = String::toLowerCase;

        System.out.println(toLowerCaseRef.apply("ASDF"));
    }
}
