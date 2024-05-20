package org.example.part01.ch02.code;

public class CaptureExample {
    public static void main(String[] args) {
        capture();
    }

    static void capture() {
        int theAnswer = 43;

        Runnable printAnswer = () -> System.out.println("the answer is " + theAnswer);

        // 컴파일 에러
        // theAnswer = 24;

        run(printAnswer);
    }

    static void run(Runnable r) {
        r.run();
    }
}
