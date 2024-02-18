package org.java.data;

public class Parking {
    @Override
    public String toString() {
        return "Parking{" +
                "totalSlots=" + totalSlots +
                ", emptySlots=" + emptySlots +
                ", nextNearestSlot=" + nextNearestSlot +
                '}';
    }

    private Integer totalSlots;
    private Integer emptySlots;
    private Integer nextNearestSlot;

    public Parking(Integer totalSlots, Integer emptySlots, Integer nextNearestSlot) {
        this.totalSlots = totalSlots;
        this.emptySlots = emptySlots;
        this.nextNearestSlot = nextNearestSlot;
    }

    public Integer getNextNearestSlot(){
        return this.nextNearestSlot;
    }

    public Integer getTotalSlots() {
        return totalSlots;
    }

    public void setTotalSlots(Integer totalSlots) {
        this.totalSlots = totalSlots;
    }

    public Integer getEmptySlots() {
        return emptySlots;
    }

    public void setEmptySlots(Integer emptySlots) {
        this.emptySlots = emptySlots;
    }

    public void setNextNearestSlot(Integer nextNearestSlot) {
        this.nextNearestSlot = nextNearestSlot;
    }
}
