package org.example.part02.ch06.code.streamex;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamMappingEx {

    public static void main(String[] args) {
        List<Shape> shapeList = Arrays.asList(Shape.square(), Shape.triangle(), Shape.triangle(), Shape.circle(), Shape.square(), Shape.circle());

        Stream<Shape> stream = shapeList.stream();

        // map -> 함수가 요소에 적용되고 새로운 요소가 스트림으로 반환된다.
        // map 함수의 반환 타입(Integer)으로 새로운 요소가 반환된다.
        // Stream<Integer> integerStream = stream.map(Shape::corners);
        //stream.map(Shape::corners).forEach(System.out::println);

        // flatMap -> 컬렉션, Optional 같은 컨테이너 형태의 요소를 펼쳐서 새로운 다중 요소로 포함하는 새로운 스트림을 반환
        // Stream<List<Shape>> listStream = stream.map(Shape::twice);
        // Stream<Shape> shapeStream = listStream.flatMap(List::stream);
        stream.map(Shape::twice).flatMap(List::stream).forEach(System.out::println);

    }
}
