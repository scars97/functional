package org.example.part02.ch11.code;

import java.util.function.IntSupplier;

public class StrictnessEx {

    public static void main(String[] args) {
        int result = add(() -> 5, () -> 1 / 0);
        System.out.println(result);
    }

    static int add(IntSupplier x, IntSupplier y) {
        int actualX = x.getAsInt();
        return actualX + actualX;
    }

}
