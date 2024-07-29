package org.example.part02.ch14.code.factory;

import java.util.Objects;
import java.util.function.Function;

public enum FunctionalShapeType {

    CIRCLE(Circle::new),
    TRIANGLE(Triangle::new),
    SQUARE(Square::new);

    public final Function<Color, Shape> factory;

    FunctionalShapeType(Function<Color, Shape> factory) {
        this.factory = factory;
    }

    public Shape newInstance(Color color) {
        Objects.requireNonNull(color);
        Function<Shape, Shape> shapePrint =
            shape -> {
                System.out.println("type: " + shape.type() + "\ncolor: " + shape.color() + "\ncorners: " + shape.corners());
                return shape;
            };

        return this.factory.andThen(shapePrint).apply(color);
    }
}
