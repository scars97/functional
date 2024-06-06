package org.example.part02.ch06.code.streamex;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamFoldEx {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        // BinaryOperator만 사용하는 reduce
        // 스트림 요소가 없는 경우 Optional을 반환한다.
        Optional<Integer> result = list.stream().reduce((a, b) -> a + b);
        result.ifPresent(System.out::println); // 15

        // Identity와 BinaryOperator를 사용한 reduce
        // 초기값이 0으로 설정되어 결과는 항상 Integer로 반환된다.
        Integer result2 = list.stream().reduce(0, (a, b) -> a + b);
        System.out.println(result2); // 15

        // Identity, BinaryOperator, combiner
        Integer result3 = list.stream().reduce(0, (a, b) -> a + b, Integer::sum);
        System.out.println(result3);

        List<String> list2 = Arrays.asList("apple", "banana", "cherry");
        int result4 = list2.stream()
                .mapToInt(String::length)
                .reduce(0, (a, b) -> a + b);
        System.out.println(result4);
    }
}
