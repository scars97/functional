package org.example.part02.ch14.code.decorator.oo;

public class DecoratorEx {

    public static void main(String[] args) {
        CoffeeMaker coffeeMaker = new BlackCoffeeMaker();

        System.out.println(coffeeMaker.prepare() + " : " + coffeeMaker.getIngredients());

        CoffeeMaker decoratedCoffeeMaker = new AddMilkDecorator(coffeeMaker, new MilkCarton());

        System.out.println(decoratedCoffeeMaker.prepare() + " : " + decoratedCoffeeMaker.getIngredients());

        CoffeeMaker lastDecoratedCoffeeMaker = new AddSugarDecorator(decoratedCoffeeMaker);

        System.out.println(lastDecoratedCoffeeMaker.prepare() + " : " + lastDecoratedCoffeeMaker.getIngredients());
    }
}
