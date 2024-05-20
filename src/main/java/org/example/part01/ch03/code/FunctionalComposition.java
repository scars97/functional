package org.example.part01.ch03.code;

import java.util.function.Function;

public class FunctionalComposition {

    public static void main(String[] args) {
        Function<Integer, Integer> func = num -> num + num;
        Function<Integer, Integer> composeFunc = num -> num * num;

        Integer apply = func.compose(composeFunc).apply(5);
        System.out.println(apply);

        Function<Integer, Integer> func2 = num -> num + num;
        Function<Integer, Integer> andThenFunc = num -> num * num;

        // func이 먼저 실행된 후, andThenFunc 실행
        Integer apply2 = func2.andThen(andThenFunc).apply(5);
        System.out.println(apply2); // 5 + 5 -> 10 * 10 -> 100
    }
}
