package org.java.service;

import org.java.ParkingLotException.ParkingLotException;
import org.java.data.Car;
import org.java.data.Parking;
import org.java.data.Ticket;

import java.util.*;

import static org.java.helper.ParkingHelper.updateParkingInfoForAllocation;
import static org.java.helper.ParkingHelper.updateParkingInfoForDeallocation;

public class ParkingServiceImpl implements IParkingService{

    Map<String, List<String>> carColorToRegNoMap = new HashMap<>();
    Map<Integer, String> slotToRegNoMap = new HashMap<>();
    Map<String, List<Integer>> colorToSlotsMap = new HashMap<>();
    Map<Integer, Ticket> slotToTicketMap = new TreeMap<>();

    public Parking getParking(int n){
        return new Parking(n,n,1);
    }

    public Ticket allocateParkingSlot(Car car, Parking parking) {
        if(parking.getEmptySlots() != 0 ) {
            List<String> regList = carColorToRegNoMap.getOrDefault(car.getColor(), new ArrayList<>());
            List<Integer> slots = colorToSlotsMap.getOrDefault(car.getColor(), new ArrayList<>());
            regList.add(car.getRegNo());
            slots.add(parking.getNextNearestSlot());
            carColorToRegNoMap.put(car.getColor(), regList);
            slotToRegNoMap.put(parking.getNextNearestSlot(), car.getRegNo());
            colorToSlotsMap.put(car.getColor(), slots);
            Ticket ticket = new Ticket(parking.getNextNearestSlot(), car);
            slotToTicketMap.put(parking.getNextNearestSlot(), ticket);
            updateParkingInfoForAllocation(parking, slotToTicketMap);
            return ticket;
        }
        throw new ParkingLotException("Parking is full");
    }

    public void deallocateTicket(Parking parking, Integer slot){
        updateParkingInfoForDeallocation(parking, slotToTicketMap, slot);
        Ticket ticket = slotToTicketMap.get(slot);
        List<Integer> slots = colorToSlotsMap.get(ticket.getCar().getColor());
        slots.remove(slot);
        colorToSlotsMap.put(ticket.getCar().getColor(), slots);
        slotToRegNoMap.remove(slot);
        slotToTicketMap.remove(slot);
    }

    public List<String> getRegForColor(String color) {
        return carColorToRegNoMap.get(color);
    }

    public List<Integer> getSlotsFromColor(String color) {
        return colorToSlotsMap.get(color);
    }

    public Ticket getTicketBySlot(Integer slot) {
        return slotToTicketMap.get(slot);
    }
}
