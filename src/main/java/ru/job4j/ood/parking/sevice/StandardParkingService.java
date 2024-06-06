package ru.job4j.ood.parking.sevice;

import ru.job4j.ood.parking.model.Auto;
import ru.job4j.ood.parking.model.Parking;
import ru.job4j.ood.parking.model.ParkingSpace;

import java.util.List;

public class StandardParkingService implements ParkingService {
    private final Parking parking;

    public StandardParkingService(Parking parking) {
        this.parking = parking;
    }

    @Override
    public List<ParkingSpace> parkAuto(Auto auto) {
        return List.of();
    }

    @Override
    public Auto getAuto(Auto auto, List<ParkingSpace> parkingSpaces) {
        return null;
    }
}
