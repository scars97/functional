package org.example.part02.ch14.code.strategy;

import org.example.part02.ch14.code.strategy.func.ShippingStrategies;

public class Main {

    public static void main(String[] args) {
        ShippingService service = new ShippingService() {};

        // oo
        Parcel ooParcel = new Parcel();
        ShippingStrategy ooStrategy = new ExpeditedShipping(true);

        service.ship(ooParcel, ooStrategy);

        // func
        Parcel funcParcel = new Parcel();
        service.ship(funcParcel, ShippingStrategies.standard());
        service.ship(funcParcel, ShippingStrategies.expedited(true));
    }
}
