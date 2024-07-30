package org.example.part02.ch14.code.decorator.oo;

import java.util.List;

/**
 * CoffeeMaker 를 장식하는 데 필요한 최소한의 기능을 하나의 타입으로 만든 Decorator
 * Decorator 를 통해 커피에 우유나 설탕 등을 추가할 수 있다.
 */
public class Decorator implements CoffeeMaker {

    private final CoffeeMaker target;

    public Decorator(CoffeeMaker target) {
        this.target = target;
    }

    @Override
    public List<String> getIngredients() {
        return this.target.getIngredients();
    }

    @Override
    public Coffee prepare() {
        return this.target.prepare();
    }
}
