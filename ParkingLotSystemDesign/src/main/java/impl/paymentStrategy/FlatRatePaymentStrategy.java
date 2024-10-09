package main.java.impl.paymentStrategy;

import main.java.model.ParkingTicket;
import main.java.model.PaymentStrategy;

public class FlatRatePaymentStrategy implements PaymentStrategy {
    @Override
    public double calculate(ParkingTicket ticket) {
        return 50.0; // Flat rate for parking
    }
}
