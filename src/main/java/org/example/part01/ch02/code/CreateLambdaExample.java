package org.example.part01.ch02.code;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class CreateLambdaExample {

    public static void main(String[] args) {
        var values = Arrays.asList("a", null, "c");

        var result1 = filter1(values, value -> value != null);
        var result2 = filter2(values, value -> value != null);

        System.out.println(result1.get(0));

        Predicate<Integer> greaterThan = isGreaterThan(5);

        System.out.println(greaterThan.test(3));
    }

    static Predicate<Integer> isGreaterThan(int value) {
        return compareValue -> compareValue > value;
    }

    static List<String> filter1(List<String> values, Predicate<String> predicate) {
        return values;
    }

    static List<String> filter2(List<String> values, LikePredicate<String> predicate) {
        return values;
    }
    interface LikePredicate<T> {
        boolean test(T value);
    }
}
