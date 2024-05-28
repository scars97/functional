package org.example.part02.ch05.code;

import java.io.*;

public class SerializableRecord {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Point1 point1 = new Point1(24, 42);

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("point.data"))) {
            out.writeObject(point1);
        }

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("point.data"));
        var readPoint = in.readObject();

        System.out.println(readPoint);

        System.out.println();

        Point2 point2 = new Point2(24, 52);
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("point2.data"))) {
            out.writeObject(point1);
        }

        ObjectInputStream in2 = new ObjectInputStream(new FileInputStream("point2.data"));
        var readPoint2 = in2.readObject();

        System.out.println(readPoint2);
    }

    public record Point1(int x, int y) implements Serializable {
    }

    public static class Point2 implements Serializable {
        private int x;
        private int y;

        public Point2(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


}
