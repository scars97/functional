package org.example.part02.ch14.code.factory;

public record Triangle(Color color) implements Shape {

    @Override
    public int corners() {
        return 3;
    }

    @Override
    public ShapeType type() {
        return ShapeType.TRIANGLE;
    }
}
