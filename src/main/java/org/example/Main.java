package org.example;


import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;

public class Main {
    public static void main(String[] args) {
         Calculator adder = (a, b) -> a + b;

        int calculate = adder.calculate(3, 5);
        System.out.println(calculate);
    }

    interface Calculator {
        int calculate(int a, int b);
    }
}