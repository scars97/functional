package org.example.part02.ch14.code.factory;

import java.util.Objects;

public class ShapeFactory {

    public static Shape newShape(ShapeType type, Color color) {
        Objects.requireNonNull(color);

        return switch (type) {
            case CIRCLE -> new Circle(color);
            case SQUARE -> new Square(color);
            case TRIANGLE -> new Triangle(color);
            default -> throw new IllegalArgumentException("Unknown type: " + type);
        };
    }
}
