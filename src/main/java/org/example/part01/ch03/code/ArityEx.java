package org.example.part01.ch03.code;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class ArityEx {

    public static void main(String[] args) {
        UnaryOperator<String> unaryOp = String::toUpperCase;
        Function<String, String> func = String::toUpperCase;

        acceptsUnary(unaryOp);
        acceptsUnary((UnaryOperator<String>) func);

        acceptsFunction(func);
        acceptsFunction(unaryOp);
    }

    static void acceptsUnary(UnaryOperator<String> unaryOp) {
        System.out.println(unaryOp.apply("hello"));
    }

    static void acceptsFunction(Function<String, String> func) {
        System.out.println(func.apply("hello"));
    }
}
