package org.example.part02.ch14.code.decorator.func;

public class Main {

    public static void main(String[] args) {

        // Single Decoration
        CoffeeMaker decoratedCoffeeMaker =
                Barista.decorate(new BlackCoffeeMaker(),
                                coffeeMaker -> new AddMilkDecorator(coffeeMaker, new MilkCarton()));
        CoffeeMaker finalCoffeeMaker = Barista.decorate(decoratedCoffeeMaker, AddSugarDecorator::new);

        // add Sugar
        CoffeeMaker lastDecoratedCoffeeMaker = new AddSugarDecorator(decoratedCoffeeMaker);

        System.out.println(lastDecoratedCoffeeMaker.getIngredients());

        // Multi Decoration
        CoffeeMaker maker = Barista.decorate(new BlackCoffeeMaker(),
                                            Decorations.addMilk(new MilkCarton()),
                                            Decorations.addSugar());
        System.out.println(maker.getIngredients());
    }
}
