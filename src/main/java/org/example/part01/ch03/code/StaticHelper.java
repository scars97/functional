package org.example.part01.ch03.code;

import java.util.function.Consumer;
import java.util.function.Function;

public class StaticHelper {

    public static void main(String[] args) {
        Function<String, String> removeLowerCaseA = str -> str.replace("a", "");
        Function<String, String> upperCase = String::toUpperCase;

        Function<String, String> stringOperations =
                removeLowerCaseA.andThen(upperCase);

        String apply = stringOperations.apply("abcd");
        System.out.println(apply);
    }
}
