package org.example.part02.ch14.code.decorator.oo;

import java.util.List;

public interface CoffeeMaker {

    List<String> getIngredients();

    Coffee prepare();
}
