package org.example.ch03.functionalinterface;

import java.util.function.Supplier;

public class SupplierEx {

    public static void main(String[] args) {
        Supplier<Integer> randomIntegerSupplier = () -> (int) (Math.random() * 100);

        Integer randomNumber = randomIntegerSupplier.get();
        System.out.println(randomNumber);
    }
}
