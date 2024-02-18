package org.java.service;

import org.java.data.Car;
import org.java.data.Parking;
import org.java.data.Ticket;

import java.util.List;

public interface IParkingService {

    Parking getParking(int n);

    Ticket allocateParkingSlot(Car car, Parking parking);

    void deallocateTicket(Parking parking, Integer slot);

    List<String> getRegForColor(String color);

    List<Integer> getSlotsFromColor(String color);

    Ticket getTicketBySlot(Integer slot);

}
