package org.example.ch03;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionalInterfaceEx {

    public static void main(String[] args) {
        // 데이터 변환
        Function<String, Integer> length = str -> str != null ? str.length() : 0;
        System.out.println(length.apply("fucking hard"));

        // 매핑
        Function<String, String> toUpperCase = String::toUpperCase;

        List<String> names = List.of("park", "seong", "hyeon");
        List<String> upperNames = names.stream()
                                        .map(toUpperCase)
                                        .collect(Collectors.toList());
        System.out.println(names); // park seong hyeon
        System.out.println(upperNames); // PARL SEONG HYEON

        // 파이프라이닝
        Function<String, String> toUpperCase2 = String::toUpperCase;
        Function<String, String> removeWhiteSpace = String::trim;

        Function<String, String> pipeline = toUpperCase2.andThen(removeWhiteSpace);

        String result = pipeline.apply(" hello ");
        System.out.println(result);


    }
}
