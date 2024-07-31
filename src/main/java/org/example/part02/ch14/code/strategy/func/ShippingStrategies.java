package org.example.part02.ch14.code.strategy.func;

import org.example.part02.ch14.code.strategy.ExpeditedShipping;
import org.example.part02.ch14.code.strategy.ShippingStrategy;
import org.example.part02.ch14.code.strategy.StandardShipping;


public final class ShippingStrategies {

    public static ShippingStrategy standard() {
        return new StandardShipping();
    }

    public static ShippingStrategy expedited(boolean requiresSignature) {
        return new ExpeditedShipping(requiresSignature);
    }
}
