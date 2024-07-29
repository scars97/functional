package org.example.part02.ch14.code.factory;


public record Circle(Color color) implements Shape {

    @Override
    public int corners() {
        return 0;
    }

    @Override
    public ShapeType type() {
        return ShapeType.CIRCLE;
    }
}
