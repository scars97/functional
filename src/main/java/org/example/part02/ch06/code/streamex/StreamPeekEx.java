package org.example.part02.ch06.code.streamex;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamPeekEx {

    public static void main(String[] args) {
        Stream.of(Shape.square(), Shape.triangle(), Shape.circle())
                .map(Shape::twice)
                .flatMap(List::stream)
                .peek(shape -> System.out.println("current: " + shape))
                .filter(shape -> shape.corners() < 4)
                .collect(Collectors.toList());
    }
}
