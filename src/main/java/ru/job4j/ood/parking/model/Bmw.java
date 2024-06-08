package ru.job4j.ood.parking.model;

public class Bmw implements Auto {
    private final int size;

    public Bmw(int size) {
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }
}
