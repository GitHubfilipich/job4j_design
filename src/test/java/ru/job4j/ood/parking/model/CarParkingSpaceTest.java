package ru.job4j.ood.parking.model;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@Disabled("Тесты отключены до момента реализации всех методов")
class CarParkingSpaceTest {

    @Test
    void whenGetSize() {
        int size = 1;
        ParkingSpace parkingSpace = new CarParkingSpace(size);
        assertThat(parkingSpace.getSize()).isEqualTo(size);
    }
}