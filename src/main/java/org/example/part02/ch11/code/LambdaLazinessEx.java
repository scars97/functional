package org.example.part02.ch11.code;

import java.util.Optional;
import java.util.function.Supplier;

public class LambdaLazinessEx {

    public static void main(String[] args) {
        // 람다 표현식을 사용하여 Supplier 선언
        // 바디는 아직 실행되지 않는다.
        Supplier<String> lazyValue = () -> {
            System.out.println("Calculating...");
            return "Computed Value";
        };

        Optional<String> optional = Optional.empty();

        // orElseGet은 값이 없을 때만 Supplier를 실행
        System.out.println("Before orElseGet");
        String result = optional.orElseGet(lazyValue);
        System.out.println("After orElseGet");

        System.out.println("Result: " + result);

        System.out.println("==============");

        Optional<String> optional2 = Optional.of("asdf");

        System.out.println("Before orElseGet");
        String result2 = optional2.orElseGet(lazyValue);
        System.out.println("After orElseGet");

        System.out.println("Result2: " + result2);
    }
}
