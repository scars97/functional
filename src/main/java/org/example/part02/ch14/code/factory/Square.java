package org.example.part02.ch14.code.factory;

public record Square(Color color) implements Shape {

    @Override
    public int corners() {
        return 4;
    }

    @Override
    public ShapeType type() {
        return ShapeType.SQUARE;
    }
}
