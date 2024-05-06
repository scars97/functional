package org.example;


public class Main {
    public static void main(String[] args) {
        capture();
    }

    static void capture() {
        int theAnswer = 43;

        Runnable printAnswer = () -> System.out.println("the answer is " + theAnswer);

        run(printAnswer);
    }

    static void run(Runnable r) {
        r.run();
    }
}