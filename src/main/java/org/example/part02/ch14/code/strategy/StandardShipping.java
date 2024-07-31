package org.example.part02.ch14.code.strategy;

public class StandardShipping implements ShippingStrategy {

    @Override
    public void ship(Parcel parcel) {
        System.out.println("Shipping Parcel with '" + getClass().getSimpleName() + "'");
    }
}
