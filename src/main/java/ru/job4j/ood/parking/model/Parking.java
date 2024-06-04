package ru.job4j.ood.parking.model;

import java.util.List;
import java.util.Map;

public interface Parking {
    Map<ParkingSpace, List<ParkingSpace>> getParkingSpacesInfo();
    boolean parkAuto(Auto auto, List<ParkingSpace> parkingSpaces);
    Auto getAuto(Auto auto, List<ParkingSpace> parkingSpaces);
}
