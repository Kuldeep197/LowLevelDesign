package org.java.data;

public class Ticket {

    private Integer slotNo;
    private Car car;

    public Integer getSlotNo() {
        return slotNo;
    }

    public void setSlotNo(Integer slotNo) {
        this.slotNo = slotNo;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "slotNo=" + slotNo +
                ", car=" + car +
                '}';
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Ticket(Integer slotNo, Car car){
        this.slotNo = slotNo;
        this.car = car;
    }
}
