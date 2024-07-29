package org.example.part02.ch14.code.factory;

public interface Shape {

    int corners();

    Color color();

    ShapeType type();

    default void println() {
        System.out.println("type: " + type());
        System.out.println("color: " + color());
        System.out.println("corners: " + corners());
    }
}
