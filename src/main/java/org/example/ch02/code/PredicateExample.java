package org.example.ch02.code;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // 짝수 필터링 정의
        Predicate<Integer> isEven = num -> num % 2 == 0;

        // 필터링 결과 출력
        numbers.stream()
                .filter(isEven)
                .forEach(num -> System.out.println(num + " "));
    }
}
