package main.java.impl;

import main.java.impl.factory.PaymentStrategyFactory;
import main.java.model.*;

import java.util.*;

public class ParkingLot {
    private final List<ParkingSpot> parkingSpots;
    private final Map<String, ParkingTicket> activeTickets;

    public ParkingLot(List<ParkingSpot> spots) {
        this.parkingSpots = spots;
        this.activeTickets = new HashMap<>();
    }

    public ParkingTicket parkVehicle(Vehicle vehicle) {
        ParkingSpot spot = findAvailableSpot(vehicle.getType());
        if (spot == null) {
            throw new RuntimeException("No parking spots available for " + vehicle.getType());
        }

        spot.parkVehicle(vehicle);
        ParkingTicket ticket = new ParkingTicket(vehicle, spot);
        activeTickets.put(vehicle.getLicensePlate(), ticket);
        return ticket;
    }

    public void unparkVehicle(String licensePlate) {
        ParkingTicket ticket = activeTickets.get(licensePlate);
        if (ticket == null) {
            throw new RuntimeException("Vehicle not found.");
        }

        ticket.getSpot().removeVehicle();
        activeTickets.remove(licensePlate);
        System.out.println("Payment due: " + calculateFee(ticket));
    }

    private ParkingSpot findAvailableSpot(VehicleType type) {
        for (ParkingSpot spot : parkingSpots) {
            if (spot.isAvailable() && spot.getSpotType().name().equalsIgnoreCase(type.name())) {
                return spot;
            }
        }
        return null;
    }

    private double calculateFee(ParkingTicket ticket) {
        // Use a strategy pattern to calculate fee
        PaymentStrategy strategy = PaymentStrategyFactory.getStrategy(ticket.getVehicle().getType());
        return strategy.calculate(ticket);
    }
}

