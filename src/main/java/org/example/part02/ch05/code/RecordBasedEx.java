package org.example.part02.ch05.code;

public class RecordBasedEx {

    public static void main(String[] args) {
        record Point(int x, int y) {}

        var point = new Point(23, 42);

        // 자바 19 이후 사용가능
        /*if (point instanceof Point(int x, int y)) {
            System.out.println(x + y);
        }*/


    }
}
