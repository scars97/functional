package org.example.part01.ch03.code.functionalinterface;

import java.util.function.Supplier;

public class SupplierEx {

    public static void main(String[] args) {
        Supplier<Integer> randomIntegerSupplier = () -> (int) (Math.random() * 100);

        Integer randomNumber = randomIntegerSupplier.get();
        System.out.println(randomNumber);
    }
}
