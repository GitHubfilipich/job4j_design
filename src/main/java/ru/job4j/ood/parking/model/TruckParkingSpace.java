package ru.job4j.ood.parking.model;

public class TruckParkingSpace implements ParkingSpace {
    private final int size;
    private final int number;

    public TruckParkingSpace(int size, int number) {
        this.size = size;
        this.number = number;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int getNumber() {
        return number;
    }
}
