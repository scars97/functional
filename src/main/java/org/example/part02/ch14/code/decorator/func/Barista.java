package org.example.part02.ch14.code.decorator.func;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class Barista {

    // 단일 함수
    public static CoffeeMaker decorate(CoffeeMaker coffeeMaker,
                                       Function<CoffeeMaker, CoffeeMaker> decorator) {
        return decorator.apply(coffeeMaker);
    }

    // 가변 함수
    @SafeVarargs
    public static CoffeeMaker decorate(CoffeeMaker coffeeMaker,
                                       Function<CoffeeMaker, CoffeeMaker>... decorators) {
        Function<CoffeeMaker, CoffeeMaker> reducedDecorations =
                Arrays.stream(decorators)
                        .reduce(Function.identity(),
                                Function::andThen);
        return reducedDecorations.apply(coffeeMaker);
    }

    private Barista() {
    }
}
