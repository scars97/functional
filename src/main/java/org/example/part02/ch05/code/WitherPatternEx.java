package org.example.part02.ch05.code;

public class WitherPatternEx {

    public static void main(String[] args) {
        Point point = new Point(4, 5);

        Point withXPoint = point.with().x(32);

        System.out.println(point);
        System.out.println(withXPoint);
        System.out.println(point.equals(withXPoint));
    }

    public record Point(int x, int y) {

        public With with() {
            return new With(this);
        }

        public record With(Point source) {

            public Point x(int newX) {
                return new Point(newX, source.y());
            }

            public Point y(int newY) {
                return new Point(source.x(), newY);
            }

        }
    }
}
