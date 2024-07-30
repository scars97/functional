package org.example.part02.ch14.code.decorator.oo;

import java.util.ArrayList;
import java.util.List;

public class AddMilkDecorator extends Decorator {

    private final MilkCarton milkCarton;

    public AddMilkDecorator(CoffeeMaker target, MilkCarton milkCarton) {
        super(target);
        this.milkCarton = milkCarton;
    }

    @Override
    public List<String> getIngredients() {
        List<String> newIngredients = new ArrayList<>(super.getIngredients());
        newIngredients.add("Milk");
        return newIngredients;
    }

    @Override
    public Coffee prepare() {
        Coffee coffee = super.prepare();
        return this.milkCarton.pourInfo(coffee);
    }
}
