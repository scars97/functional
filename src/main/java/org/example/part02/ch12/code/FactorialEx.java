package org.example.part02.ch12.code;

public class FactorialEx {

    public static void main(String[] args) {
        int number = 4;
        //int result = factorial(number);
        int result = factorialHead(number);
        //int result = factorialTail(number, 1);
        System.out.println("Factorial of " + number + " is " + result);
    }

    static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    static int factorialHead(int n) {
        if (n == 0) {
            return 1;
        }

        int nextN = n - 1;

        return n * factorialHead(nextN);
    }

    static int factorialTail(int n, int accumulator) {
        if (n == 0) {
            return accumulator;
        } else {
            return factorialTail(n - 1, n * accumulator);
        }
    }
}
