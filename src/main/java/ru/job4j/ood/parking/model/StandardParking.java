package ru.job4j.ood.parking.model;

import java.util.List;
import java.util.Map;

public class StandardParking implements Parking {
    private final Map<ParkingSpace, List<ParkingSpace>> parkingSpacesInfo;

    public StandardParking(Map<ParkingSpace, List<ParkingSpace>> parkingSpacesInfo) {
        this.parkingSpacesInfo = parkingSpacesInfo;
    }

    @Override
    public Map<ParkingSpace, List<ParkingSpace>> getParkingSpacesInfo() {
        return Map.of();
    }

    @Override
    public boolean parkAuto(Auto auto, List<ParkingSpace> parkingSpaces) {
        return false;
    }

    @Override
    public Auto getAuto(Auto auto, List<ParkingSpace> parkingSpaces) {
        return null;
    }
}
