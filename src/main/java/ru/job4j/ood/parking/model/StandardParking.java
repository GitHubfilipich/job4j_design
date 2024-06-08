package ru.job4j.ood.parking.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StandardParking implements Parking {
    private final Map<ParkingSpace, List<ParkingSpace>> parkingSpacesInfo;
    private final Map<ParkingSpace, Auto> parkingSpacesOccupation = new HashMap<>();

    public StandardParking(Map<ParkingSpace, List<ParkingSpace>> parkingSpacesInfo) {
        this.parkingSpacesInfo = parkingSpacesInfo;
    }

    @Override
    public Map<ParkingSpace, List<ParkingSpace>> getParkingSpacesInfo() {
        return Map.copyOf(parkingSpacesInfo);
    }

    @Override
    public boolean parkAuto(Auto auto, List<ParkingSpace> parkingSpaces) {
        if (!checkDataForParkAuto(auto, parkingSpaces)) {
            return false;
        }
        parkingSpaces.forEach(parkingSpace -> parkingSpacesOccupation.put(parkingSpace, auto));
        return true;
    }

    private boolean checkDataForParkAuto(Auto auto, List<ParkingSpace> parkingSpaces) {
        int size = 0;
        for (int i = 0; i < parkingSpaces.size(); i++) {
            if (parkingSpacesOccupation.get(parkingSpaces.get(i)) != null) {
                System.out.println("Parking space is occupied");
                return false;
            }
            size += parkingSpaces.get(i).getSize();
            if (i > 0 && !parkingSpacesInfo.get(parkingSpaces.get(i - 1)).contains(parkingSpaces.get(i))) {
                System.out.println("Parking spaces are not nearby");
                return false;
            }
        }
        if (size < auto.getSize()) {
            System.out.println("Total size of parking spaces less than size of auto");
            return false;
        }
        return true;
    }

    @Override
    public Auto getAuto(Auto auto, List<ParkingSpace> parkingSpaces) {
        if (!checkDataForGetAuto(auto, parkingSpaces)) {
            return null;
        }
        parkingSpaces.forEach(parkingSpacesOccupation::remove);
        return auto;
    }

    private boolean checkDataForGetAuto(Auto auto, List<ParkingSpace> parkingSpaces) {
        for (ParkingSpace parkingSpace : parkingSpaces) {
            if (parkingSpacesOccupation.get(parkingSpace) != auto) {
                System.out.println("Parking space is occupied by other auto");
                return false;
            }
        }
        return true;
    }
}
