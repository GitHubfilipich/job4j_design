package ru.job4j.ood.parking.model;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class UndergroundParkingTest {

    @Test
    void whenGetParkingSpacesInfo() {
        ParkingSpace space1 = new CarParkingSpace(1, 1);
        ParkingSpace space2 = new CarParkingSpace(1, 2);
        TruckParkingSpace space3 = new TruckParkingSpace(2, 3);
        TruckParkingSpace space4 = new TruckParkingSpace(3, 4);
        Map<ParkingSpace, List<ParkingSpace>> spacesInfo = Map.of(space1, List.of(space2),
                space2, List.of(space3), space3, List.of(space4), space4, List.of());
        Parking parking = new UndergroundParking(spacesInfo);
        assertThat(parking.getParkingSpacesInfo()).isEqualTo(spacesInfo);
    }

    @Test
    void whenParkCarAutoThenTrue() {
        ParkingSpace space1 = new CarParkingSpace(1, 1);
        ParkingSpace space2 = new CarParkingSpace(1, 2);
        TruckParkingSpace space3 = new TruckParkingSpace(2, 3);
        TruckParkingSpace space4 = new TruckParkingSpace(3, 4);
        Map<ParkingSpace, List<ParkingSpace>> spacesInfo = Map.of(space1, List.of(space2),
                space2, List.of(space3), space3, List.of(space4), space4, List.of());
        Parking parking = new UndergroundParking(spacesInfo);
        Auto auto = new Bmw(1);
        assertThat(parking.parkAuto(auto, List.of(space1))).isTrue();
    }

    @Test
    void whenParkCarAutoOnBusySpaceThenFalse() {
        ParkingSpace space1 = new CarParkingSpace(1, 1);
        ParkingSpace space2 = new CarParkingSpace(1, 2);
        TruckParkingSpace space3 = new TruckParkingSpace(2, 3);
        TruckParkingSpace space4 = new TruckParkingSpace(3, 4);
        Map<ParkingSpace, List<ParkingSpace>> spacesInfo = Map.of(space1, List.of(space2),
                space2, List.of(space3), space3, List.of(space4), space4, List.of());
        Parking parking = new UndergroundParking(spacesInfo);
        Auto auto1 = new Bmw(1);
        Auto auto2 = new Bmw(1);
        parking.parkAuto(auto1, List.of(space1));
        assertThat(parking.parkAuto(auto2, List.of(space1))).isFalse();
    }

    @Test
    void whenParkTruckAutoOnTruckSpaceThenTrue() {
        ParkingSpace space1 = new CarParkingSpace(1, 1);
        ParkingSpace space2 = new CarParkingSpace(1, 2);
        TruckParkingSpace space3 = new TruckParkingSpace(2, 3);
        TruckParkingSpace space4 = new TruckParkingSpace(3, 4);
        Map<ParkingSpace, List<ParkingSpace>> spacesInfo = Map.of(space1, List.of(space2),
                space2, List.of(space3), space3, List.of(space4), space4, List.of());
        Parking parking = new UndergroundParking(spacesInfo);
        Auto auto = new Mercedes(2);
        assertThat(parking.parkAuto(auto, List.of(space3))).isTrue();
    }

    @Test
    void whenParkTruckAutoOnNotEnoughCarSpacesThenFalse() {
        ParkingSpace space1 = new CarParkingSpace(1, 1);
        ParkingSpace space2 = new CarParkingSpace(1, 2);
        TruckParkingSpace space3 = new TruckParkingSpace(2, 3);
        TruckParkingSpace space4 = new TruckParkingSpace(3, 4);
        Map<ParkingSpace, List<ParkingSpace>> spacesInfo = Map.of(space1, List.of(space2),
                space2, List.of(space3), space3, List.of(space4), space4, List.of());
        Parking parking = new UndergroundParking(spacesInfo);
        Auto auto = new Mercedes(3);
        assertThat(parking.parkAuto(auto, List.of(space1, space2))).isFalse();
    }

    @Test
    void whenGetAutoThenTrue() {
        ParkingSpace space1 = new CarParkingSpace(1, 1);
        ParkingSpace space2 = new CarParkingSpace(1, 2);
        TruckParkingSpace space3 = new TruckParkingSpace(2, 3);
        TruckParkingSpace space4 = new TruckParkingSpace(3, 4);
        Map<ParkingSpace, List<ParkingSpace>> spacesInfo = Map.of(space1, List.of(space2),
                space2, List.of(space3), space3, List.of(space4), space4, List.of());
        Parking parking = new UndergroundParking(spacesInfo);
        Auto auto = new Bmw(1);
        parking.parkAuto(auto, List.of(space1));
        assertThat(parking.getAuto(auto, List.of(space1))).isEqualTo(auto);
    }

    @Test
    void whenGetAutoFromIncorrectSpacesThenFalse() {
        ParkingSpace space1 = new CarParkingSpace(1, 1);
        ParkingSpace space2 = new CarParkingSpace(1, 2);
        TruckParkingSpace space3 = new TruckParkingSpace(2, 3);
        TruckParkingSpace space4 = new TruckParkingSpace(3, 4);
        Map<ParkingSpace, List<ParkingSpace>> spacesInfo = Map.of(space1, List.of(space2),
                space2, List.of(space3), space3, List.of(space4), space4, List.of());
        Parking parking = new UndergroundParking(spacesInfo);
        Auto auto = new Bmw(1);
        parking.parkAuto(auto, List.of(space1));
        assertThat(parking.getAuto(auto, List.of(space2))).isNull();
    }
}