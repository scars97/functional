package org.example;


import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;

public class Main {
    public static void main(String[] args) {
        int result1 = add(2, 3);
        System.out.println(result1);

        IntUnaryOperator addTwo = curriedAdd(2).apply(3);
        int result2 = addTwo.applyAsInt(4);
        System.out.println(result2);
    }

    static int add(int x, int y) {
        return x + y;
    }

    static IntFunction<IntUnaryOperator> curriedAdd(int x) {
        return y -> z -> x + y + z;
    }
}