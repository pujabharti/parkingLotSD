package main.java.impl.paymentStrategy;

import main.java.model.ParkingTicket;
import main.java.model.PaymentStrategy;
import java.time.LocalDateTime;

public class HourlyPaymentStrategy implements PaymentStrategy {
    @Override
    public double calculate(ParkingTicket ticket) {
        long hoursParked = java.time.Duration.between(ticket.getEntryTime(), LocalDateTime.now()).toHours();
        return hoursParked * 10.0; // $10 per hour
    }
}
