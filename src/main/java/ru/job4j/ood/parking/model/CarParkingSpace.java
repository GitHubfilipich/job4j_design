package ru.job4j.ood.parking.model;

public class CarParkingSpace implements ParkingSpace {
    private final int size;
    private final int number;

    public CarParkingSpace(int size, int number) {
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
