package ru.job4j.ood.parking.model;

public class TruckParkingSpace implements ParkingSpace {
    private final int size;

    public TruckParkingSpace(int size) {
        this.size = size;
    }

    @Override
    public int getSize() {
        return 0;
    }
}
