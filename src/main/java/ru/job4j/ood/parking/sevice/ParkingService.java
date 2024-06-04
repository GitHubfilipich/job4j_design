package ru.job4j.ood.parking.sevice;

import ru.job4j.ood.parking.model.Auto;
import ru.job4j.ood.parking.model.ParkingSpace;

import java.util.List;

public interface ParkingService {
    List<ParkingSpace> parkAuto(Auto auto);
    Auto getAuto(Auto auto, List<ParkingSpace> parkingSpaces);
}