package ru.job4j.ood.parking.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarParkingSpaceTest {

    @Test
    void whenGetSize() {
        int size = 1;
        ParkingSpace parkingSpace = new CarParkingSpace(size, 1);
        assertThat(parkingSpace.getSize()).isEqualTo(size);
    }
}