package org.java.data;

public class Car {

    private String regNo;
    private String color;

    @Override
    public String toString() {
        return "Car{" +
                "regNo='" + regNo + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Car(String regNo, String color){
        this.regNo  = regNo;
        this.color = color;
    }
}
