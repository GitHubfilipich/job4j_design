package ru.job4j.ood.parking.sevice;

import ru.job4j.ood.parking.model.Auto;
import ru.job4j.ood.parking.model.Parking;
import ru.job4j.ood.parking.model.ParkingSpace;

import java.util.*;

public class StandardParkingService implements ParkingService {
    private final Parking parking;
    private final Map<ParkingSpace, Auto> parkingSpacesOccupation = new HashMap<>();

    public StandardParkingService(Parking parking) {
        this.parking = parking;
    }

    @Override
    public List<ParkingSpace> parkAuto(Auto auto) {
        List<ParkingSpace> parkingSpaces = findParkingSpaces(auto);
        if (!parkingSpaces.isEmpty()) {
            if (parking.parkAuto(auto, parkingSpaces)) {
                parkingSpaces.forEach(parkingSpace -> parkingSpacesOccupation.put(parkingSpace, auto));
            } else {
                System.out.println("Can`t park auto in the parking");
                parkingSpaces.clear();
            }
        } else {
            System.out.println("No vacant spaces");
        }
        return parkingSpaces;
    }

    private List<ParkingSpace> findParkingSpaces(Auto auto) {
        List<ParkingSpace> parkingSpacesForAuto = new ArrayList<>();
        Map<ParkingSpace, List<ParkingSpace>> parkingSpacesInfo = parking.getParkingSpacesInfo();
        List<ParkingSpace> parkingSpaces = new ArrayList<>(parkingSpacesInfo.keySet().stream().toList());
        parkingSpaces.sort(Comparator.comparingInt(ParkingSpace::getNumber));
        for (ParkingSpace parkingSpace : parkingSpaces) {
            if (parkingSpacesOccupation.get(parkingSpace) == null
                    && parkingSpace.getSize() == auto.getSize()) {
                parkingSpacesForAuto.add(parkingSpace);
                break;
            }
        }
        if (parkingSpacesForAuto.isEmpty() && auto.getSize() > 1) {
            for (ParkingSpace parkingSpace : parkingSpaces) {
                if (parkingSpacesOccupation.get(parkingSpace) == null
                        && parkingSpace.getSize() == 1
                        && (parkingSpacesForAuto.isEmpty()
                        || parkingSpacesInfo.get(
                                parkingSpacesForAuto.get(
                                        parkingSpacesForAuto.size() - 1))
                        .contains(parkingSpace))) {
                    parkingSpacesForAuto.add(parkingSpace);
                    if (parkingSpacesForAuto.size() == auto.getSize()) {
                        break;
                    }
                } else {
                    parkingSpacesForAuto.clear();
                }
            }
        }
        return parkingSpacesForAuto;
    }

    @Override
    public Auto getAuto(Auto auto, List<ParkingSpace> parkingSpaces) {
        if (!checkDataForGetAuto(auto, parkingSpaces)) {
            return null;
        }
        Auto returnedAuto = parking.getAuto(auto, parkingSpaces);
        if (returnedAuto == auto) {
            parkingSpaces.forEach(parkingSpacesOccupation::remove);
        } else {
            System.out.println("Can`t get auto from the parking");
            returnedAuto = null;
        }
        return returnedAuto;
    }

    private boolean checkDataForGetAuto(Auto auto, List<ParkingSpace> parkingSpaces) {
        for (ParkingSpace parkingSpace : parkingSpaces) {
            if (parkingSpacesOccupation.get(parkingSpace) != auto) {
                System.out.println("Incorrect parking space information");
                return false;
            }
        }
        return true;
    }
}
