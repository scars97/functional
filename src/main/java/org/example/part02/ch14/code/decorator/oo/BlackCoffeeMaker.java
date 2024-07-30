package org.example.part02.ch14.code.decorator.oo;

import java.util.List;

public class BlackCoffeeMaker implements CoffeeMaker {

    @Override
    public List<String> getIngredients() {
        return List.of("Robusta Beans", "Water");
    }

    @Override
    public Coffee prepare() {
        return Coffee.BLACK_COFFEE;
    }
}
