package ru.job4j.ood.parking.model;

public class CarParkingSpace implements ParkingSpace {
    private final int size;

    public CarParkingSpace(int size) {
        this.size = size;
    }

    @Override
    public int getSize() {
        return 0;
    }
}
