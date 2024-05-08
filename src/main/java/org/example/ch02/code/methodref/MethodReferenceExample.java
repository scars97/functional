package org.example.ch02.code.methodref;

import java.time.LocalDate;
import java.util.function.Function;
import java.util.function.Predicate;

public class MethodReferenceExample {

    public static void main(String[] args) {
        // 기본 람다 사용
        Function<Integer, String> asLambda = i -> Integer.toHexString(i);

        // 정적 메서드 참조
        Function<Integer, String> asRef = Integer::toHexString;

        System.out.println(asLambda.apply(1));

        // 바운드 비정적 메서드 참조
        Predicate<LocalDate> isAfterNowAsRef = LocalDate.now()::isAfter;
        System.out.println(isAfterNowAsRef.test(LocalDate.now()));

        // 정적 필드 바인딩
        Function<Object, String> castToStr = String.class::cast;

        System.out.println(castToStr.apply("1"));


    }
}
