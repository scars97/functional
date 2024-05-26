package org.example.part02.ch05.code;

public class InterfaceRecordEx {

    public static void main(String[] args) {
        Point point = new Point(4, 5);
        System.out.println(point.origin());

        Rectangle rectangle = new Rectangle(4, 5, 10, 15);
        System.out.println(rectangle.area());

        Circle circle = new Circle(4, 5, 15);
        System.out.println(circle.area());
    }

    public record Point(int x, int y) implements Origin{ }
    public record Rectangle(int x, int y, int width, int height) implements Origin, Area {
        @Override
        public float area() {
            return (float) (width() * height());
        }
    }
    public record Circle(int x, int y, int radius) implements Origin, Area {
        @Override
        public float area() {
            return (float) Math.PI * radius() * radius();
        }
    }

    public interface Origin {
        int x();

        int y();

        default String origin() {
            return String.format("(%d/%d)", x(), y());
        }
    }

    public interface Area {
        float area();
    }
}
