package main.java.impl.factory;

import main.java.impl.paymentStrategy.FlatRatePaymentStrategy;
import main.java.impl.paymentStrategy.HourlyPaymentStrategy;
import main.java.model.PaymentStrategy;
import main.java.model.VehicleType;

public class PaymentStrategyFactory {
    public static PaymentStrategy getStrategy(VehicleType type) {
        if (type == VehicleType.CAR) {
            return new HourlyPaymentStrategy();
        } else {
            return new FlatRatePaymentStrategy();
        }
    }
}
