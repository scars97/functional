package org.example.part02.ch06.code.streamex;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamSelectEx {

    public static void main(String[] args) {
        List<Shape> shapeList = Arrays.asList(Shape.square(), Shape.triangle(), Shape.triangle(), Shape.circle(), Shape.square(), Shape.circle());

        Stream<Shape> stream = shapeList.stream();

        // filter -> 결과가 true인 해당 요소는 선택된다.
        //stream.filter(Shape::hasCorners).forEach(System.out::println);

        // dropWhile -> Predicate가 false가 될 때까지 통과하는 모든 요소를 폐기한다. (false 부터 주워담는다.)
        //stream.dropWhile(Shape::hasCorners).forEach(System.out::println);

        //takeWhile -> false가 될 때까지 요소를 선택한다.
        //stream.takeWhile(Shape::hasCorners).forEach(System.out::println);

        // limit (long maxSize) -> 요소의 최대 개수를 maxSize로 제한한다.

        // skip (long n) -> 앞에서부터 n개의 요소를 건너뛰고, 나머지 요소들을 다음 스트림 연산을 전달

        // distinct - > 중복되지 않은 요소만 반환. 연산을 비교하기 위해 모든 요소를 버퍼에 저장
        //stream.distinct().forEach(System.out::println);

        // sorted -> Comparable이 구현되어 있다면 자연스럽게 정렬된다. 안된 경우 ClasCastException이 발생한다.
        stream.sorted().forEach(System.out::println);
    }

}
