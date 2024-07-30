package org.example.part02.ch14.code.decorator.oo;

import java.util.ArrayList;
import java.util.List;

public class AddSugarDecorator extends Decorator {

    public AddSugarDecorator(CoffeeMaker target) {
        super(target);
    }

    @Override
    public List<String> getIngredients() {
        List<String> newIngredients = new ArrayList<>(super.getIngredients());
        newIngredients.add("Sugar");
        return newIngredients;
    }

    @Override
    public Coffee prepare() {
        return super.prepare();
    }
}
