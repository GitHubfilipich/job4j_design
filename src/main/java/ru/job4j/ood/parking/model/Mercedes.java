package ru.job4j.ood.parking.model;

public class Mercedes implements Auto {
    private final int size;

    public Mercedes(int size) {
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }
}
