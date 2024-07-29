package org.example.part02.ch14.code.factory;

public class FactoryEx {

    public static void main(String[] args) {

        // 객체 지향
        /*Shape circle = ShapeFactory.newShape(ShapeType.CIRCLE, Color.GREEN);
        Shape square = ShapeFactory.newShape(ShapeType.SQUARE, Color.BLUE);
        Shape triangle = ShapeFactory.newShape(ShapeType.TRIANGLE, Color.RED);

        circle.println();
        square.println();
        triangle.println();

        System.out.println("================");*/

        // 함수적 방식
        Shape funcCircle = FunctionalShapeType.CIRCLE.newInstance(Color.RED);
        funcCircle.println();
    }
}
