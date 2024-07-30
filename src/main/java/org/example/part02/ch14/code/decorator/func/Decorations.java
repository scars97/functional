package org.example.part02.ch14.code.decorator.func;

import java.util.function.Function;

public final class Decorations {

    public static Function<CoffeeMaker, CoffeeMaker> addMilk(MilkCarton milkCarton) {
        return coffeeMaker -> new AddMilkDecorator(coffeeMaker, milkCarton);
    }

    public static Function<CoffeeMaker, CoffeeMaker> addSugar() {
        return AddSugarDecorator::new;
    }
}
