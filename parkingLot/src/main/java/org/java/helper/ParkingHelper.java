package org.java.helper;

import org.java.data.Parking;
import org.java.data.Ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParkingHelper {

    public static void updateParkingInfoForAllocation(Parking parking, Map<Integer, Ticket> slotToTicketMap){
        parking.setEmptySlots(parking.getEmptySlots()-1);
        parking.setNextNearestSlot(getNextNearestSlot(parking, slotToTicketMap));
    }

    public static void updateParkingInfoForDeallocation(Parking parking, Map<Integer, Ticket> slotToTicketMap,
                                                        Integer slotNo){
        parking.setEmptySlots(parking.getEmptySlots()+1);
        Integer nextNearestSlot = getNextNearestSlot(parking, slotToTicketMap);
        if(slotNo < nextNearestSlot){
            parking.setNextNearestSlot(slotNo);
        } else {
            parking.setNextNearestSlot(nextNearestSlot);
        }
    }

    public static Integer getNextNearestSlot(Parking parking, Map<Integer, Ticket> slotToTicketMap){
        List<Integer> slots = new ArrayList<>(slotToTicketMap.keySet());
        Integer slotIdentifier = parking.getNextNearestSlot();
        while(slots.contains(slotIdentifier)){
            slotIdentifier++;
        }
        return slotIdentifier;
    }
}
