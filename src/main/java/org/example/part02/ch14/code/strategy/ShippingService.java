package org.example.part02.ch14.code.strategy;

public interface ShippingService {

    default void ship(Parcel parcel,
                      ShippingStrategy strategy) {
        strategy.ship(parcel);
    }
}
