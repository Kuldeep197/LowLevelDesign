package org.java;

import org.java.data.Car;
import org.java.data.Parking;
import org.java.data.Ticket;
import org.java.service.IParkingService;
import org.java.service.ParkingServiceImpl;

public class Main {
    public static void main(String[] args) {
        IParkingService parkingService = new ParkingServiceImpl();
        Parking parking = parkingService.getParking(10);
        Car car1 = new Car("UP16", "Red");
        Car car2 = new Car("UP17", "Blue");
        Car car3 = new Car("UP18", "Green");
        Car car4 = new Car("UP19", "Red");
        Car car5 = new Car("UP20", "Black");
        Car car6 = new Car("UP21", "Red");

        Ticket ticket1 = parkingService.allocateParkingSlot(car1, parking);
        Ticket ticket2 = parkingService.allocateParkingSlot(car2, parking);
        Ticket ticket3 = parkingService.allocateParkingSlot(car3, parking);
        Ticket ticket4 = parkingService.allocateParkingSlot(car4, parking);
        Ticket ticket5 = parkingService.allocateParkingSlot(car5, parking);
        Ticket ticket6 = parkingService.allocateParkingSlot(car6, parking);
        System.out.println(parking);
        System.out.println(parkingService.getSlotsFromColor("Red"));
        System.out.println(parkingService.getSlotsFromColor("Blue"));
        System.out.println(parkingService.getSlotsFromColor("Green"));
        System.out.println(parkingService.getSlotsFromColor("Black"));
        System.out.println(parkingService.getTicketBySlot(2));
        parkingService.deallocateTicket(parking, 2);
        System.out.println(parking);
        System.out.println(parkingService.getTicketBySlot(2));
        System.out.println(parkingService.getRegForColor("Red"));
        System.out.println(parkingService.getRegForColor("Blue"));
        System.out.println(parkingService.getRegForColor("Green"));
        System.out.println(parkingService.getRegForColor("Black"));
        Ticket ticket7 = parkingService.allocateParkingSlot(car1, parking);
        System.out.println(ticket7);
        System.out.println(parking);
        Ticket ticket8 = parkingService.allocateParkingSlot(car3, parking);
        Ticket ticket9 = parkingService.allocateParkingSlot(car4, parking);
        Ticket ticket10 = parkingService.allocateParkingSlot(car5, parking);
        Ticket ticket11 = parkingService.allocateParkingSlot(car6, parking);
        Ticket ticket12 = parkingService.allocateParkingSlot(car6, parking); // It will throw Parking is full exception
        System.out.println(parking);
    }



}