package org.example.lld_questions.design_a_parking_lot;


import java.util.*;

// DOMAIN

enum VehicleType {
    BIKE, CAR, VAN, TRUCK, BUS
}

enum ParkingSpotType {
    SMALL, MEDIUM, LARGE
}

class DisplayBoard {
    int floorNumber;
    String status;
}

class ParkingSpot {
    int id;
    int floorNumber;
    ParkingSpotType type;
    boolean isOccupied;
    String vehicleNumber = null;

    boolean supportsVehicle(Vehicle vehicle) {
        if (ParkingSpotType.SMALL.equals(this.type)) {
            return List.of(VehicleType.BIKE).contains(vehicle.type);
        }
        if (ParkingSpotType.MEDIUM.equals(this.type)) {
            return List.of(VehicleType.BIKE, VehicleType.CAR, VehicleType.VAN).contains(vehicle.type);
        }
        if (ParkingSpotType.LARGE.equals(this.type)) {
            return List.of(VehicleType.CAR, VehicleType.VAN, VehicleType.BUS, VehicleType.TRUCK).contains(vehicle.type);
        }
        return false;
    }
}

class Vehicle {
    String vehicleNumber;
    String model;
    String color;
    VehicleType type;
}

class Ticket {
    int id;
    Date entryTime;
    String vehicleNumber;
    int spotId;
    int paymentId;
    Date exitTime;
}

enum PaymentType {
    CARD, CASH, UPI
}

class Payment {
    int id;
    Date paymentTime;
    PaymentType paymentType;
    int ticketId;
}

// Memory

class Memory {

    // In-Memory
    Map<Integer, ParkingSpot> parkingSpots;
    Map<Integer, List<ParkingSpot>> parkingSpotsByFloor;
    Map<Integer, DisplayBoard> displayBoards;
    Map<String, Vehicle> vehicles;

    // Persisting
    Map<Integer, Ticket> ticketRepo;
    Map<Integer, Payment> paymentRepo;

    Memory() {
        this.parkingSpots = new HashMap<>();
        this.displayBoards = new HashMap<>();
        this.vehicles = new HashMap<>();
        this.ticketRepo = new HashMap<>();
        this.paymentRepo = new HashMap<>();
    }
}

// SERVICES

class EntryPointService {

    Memory mem;

    EntryPointService(Memory mem) {
        this.mem = mem;
    }

    public ParkingSpot findSpot(Vehicle vehicle) {
        return null;
    }

    public Ticket createTicket(Vehicle vehicle, int spotId) {
        return null;
    }

    private void occupySpot(Vehicle vehicle, int spotId) {
        ParkingSpot spot = mem.parkingSpots.get(spotId);
        spot.isOccupied = true;
        spot.vehicleNumber = vehicle.vehicleNumber;
        mem.vehicles.put(vehicle.vehicleNumber, vehicle);
    }

    private void updateDisplayBoard(int displayBoardId) {

    }
}


class ExitPointService {

    private PaymentStrategy cashPaymentStrategy;
    private CardPaymentStrategy cardPaymentStrategy;
    private Memory mem;

    ExitPointService() {
        this.cashPaymentStrategy = new CashPaymentStrategy();
        this.cardPaymentStrategy = new CardPaymentStrategy();
    }

    public Payment createPayment(int ticketId, PaymentType paymentType) {
        Payment payment = null;
        if (paymentType.equals(PaymentType.CARD)) payment = cardPaymentStrategy.pay();
        if (paymentType.equals(PaymentType.CASH)) payment = cashPaymentStrategy.pay();
        return payment;
    }

    public void unoccupySpot(int spotId) {
        ParkingSpot spot = mem.parkingSpots.get(spotId);
        if (!spot.isOccupied) {
            throw new RuntimeException("Invalid Spot. Already Empty.");
        }
        spot.isOccupied = false;
        mem.vehicles.remove(spot.vehicleNumber);
        spot.vehicleNumber = null;
    }

    private interface PaymentStrategy {
        Payment pay();
    }

    private class CashPaymentStrategy implements PaymentStrategy {
        @Override
        public Payment pay() {
            return null;
        }
    }

    private class CardPaymentStrategy implements PaymentStrategy {
        @Override
        public Payment pay() {
            return null;
        }
    }
}


public class ParkingLotSystem {
    private static Memory mem;

    private static EntryPointService entryPointService;

    public static void main(String[] args) {
        Memory mem = new Memory();
    }

    private void enterVehicle() {
        Vehicle vehicle = new Vehicle();
        vehicle.vehicleNumber = "XYZDIUODS";
        vehicle.color = "blue";
        vehicle.type = VehicleType.CAR;
        vehicle.model = "Mercedes Benz";

        ParkingSpot spot = entryPointService.findSpot(vehicle);
        Ticket ticket = entryPointService.createTicket(vehicle, spot.id);

        System.out.println(ticket);
    }

    private void exitVehicle() {

    }

}
