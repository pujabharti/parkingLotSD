import main.java.impl.ParkingLot;
import main.java.impl.factory.ParkingSpotFactory;
import main.java.impl.vehicle.Bike;
import main.java.impl.vehicle.Car;
import main.java.impl.vehicle.Truck;
import main.java.model.ParkingSpot;
import main.java.model.ParkingSpotType;
import main.java.model.ParkingTicket;
import main.java.model.Vehicle;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create a list of parking spots
        List<ParkingSpot> parkingSpots = new ArrayList<>();
        parkingSpots.add(ParkingSpotFactory.createParkingSpot(ParkingSpotType.CAR));
        parkingSpots.add(ParkingSpotFactory.createParkingSpot(ParkingSpotType.BIKE));
        parkingSpots.add(ParkingSpotFactory.createParkingSpot(ParkingSpotType.TRUCK));

        // Initialize the parking lot with the available spots
        ParkingLot parkingLot = new ParkingLot(parkingSpots);

        // Create some vehicles
        Vehicle car = new Car("CAR123");
        Vehicle bike = new Bike("BIKE123");
        Vehicle truck = new Truck("TRUCK123");

        // Park vehicles
        System.out.println("Parking Car...");
        ParkingTicket carTicket = parkingLot.parkVehicle(car);
        System.out.println("Car parked at: " + carTicket.getEntryTime());

        System.out.println("Parking Bike...");
        ParkingTicket bikeTicket = parkingLot.parkVehicle(bike);
        System.out.println("Bike parked at: " + bikeTicket.getEntryTime());

        System.out.println("Parking Truck...");
        ParkingTicket truckTicket = parkingLot.parkVehicle(truck);
        System.out.println("Truck parked at: " + truckTicket.getEntryTime());

        // Unpark vehicles and calculate payment
        try {
            Thread.sleep(2000); // Simulate some time for parking
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Unparking Car...");
        parkingLot.unparkVehicle(car.getLicensePlate());

        System.out.println("Unparking Bike...");
        parkingLot.unparkVehicle(bike.getLicensePlate());

        System.out.println("Unparking Truck...");
        parkingLot.unparkVehicle(truck.getLicensePlate());
    }
}
