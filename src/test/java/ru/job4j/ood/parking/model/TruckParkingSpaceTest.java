package ru.job4j.ood.parking.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class TruckParkingSpaceTest {

    @Test
    void whenGetSize() {
        int size = 3;
        ParkingSpace parkingSpace = new TruckParkingSpace(size, 1);
        assertThat(parkingSpace.getSize()).isEqualTo(size);
    }
}