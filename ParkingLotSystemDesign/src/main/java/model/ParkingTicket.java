package main.java.model;

import main.java.model.Vehicle;
import java.time.LocalDateTime;

public class ParkingTicket {
    private final Vehicle vehicle;
    private final ParkingSpot spot;
    private final LocalDateTime entryTime;

    public ParkingTicket(Vehicle vehicle, ParkingSpot spot) {
        this.vehicle = vehicle;
        this.spot = spot;
        this.entryTime = LocalDateTime.now();
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getSpot() {
        return spot;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }
}

