package ru.job4j.ood.parking.sevice;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.parking.model.*;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

@Disabled("Тесты отключены до момента реализации всех методов")
class StandardParkingServiceTest {

    @Test
    void whenParkAutoThenParkingSpaces() {
        ParkingSpace space1 = new CarParkingSpace(1);
        ParkingSpace space2 = new CarParkingSpace(1);
        TruckParkingSpace space3 = new TruckParkingSpace(2);
        TruckParkingSpace space4 = new TruckParkingSpace(3);
        Map<ParkingSpace, List<ParkingSpace>> spacesInfo = Map.of(space1, List.of(space2),
                space2, List.of(space3), space3, List.of(space4), space4, List.of());
        Parking parking = new StandardParking(spacesInfo);
        ParkingService service = new StandardParkingService(parking);
        Auto auto = new Bmw(1);
        assertThat(service.parkAuto(auto)).hasSameElementsAs(List.of(space1));
    }

    @Test
    void whenParkTruckAutoThenParkingSpaces() {
        ParkingSpace space1 = new CarParkingSpace(1);
        ParkingSpace space2 = new CarParkingSpace(1);
        TruckParkingSpace space3 = new TruckParkingSpace(2);
        TruckParkingSpace space4 = new TruckParkingSpace(3);
        Map<ParkingSpace, List<ParkingSpace>> spacesInfo = Map.of(space1, List.of(space2),
                space2, List.of(space3), space3, List.of(space4), space4, List.of());
        Parking parking = new StandardParking(spacesInfo);
        ParkingService service = new StandardParkingService(parking);
        Auto auto = new Mercedes(2);
        assertThat(service.parkAuto(auto)).hasSameElementsAs(List.of(space3));
    }

    @Test
    void whenParkTruckAutoOnCarSpacesThenParkingSpaces() {
        ParkingSpace space1 = new CarParkingSpace(1);
        ParkingSpace space2 = new CarParkingSpace(1);
        ParkingSpace space3 = new CarParkingSpace(1);
        Map<ParkingSpace, List<ParkingSpace>> spacesInfo = Map.of(space1, List.of(space2),
                space2, List.of(space3), space3, List.of());
        Parking parking = new StandardParking(spacesInfo);
        ParkingService service = new StandardParkingService(parking);
        Auto auto1 = new Bmw(1);
        Auto auto2 = new Mercedes(2);
        service.parkAuto(auto1);
        assertThat(service.parkAuto(auto2)).hasSameElementsAs(List.of(space2, space3));
    }

    @Test
    void whenParkAutoAndHaveNotSpacesThenEmptyParkingSpaces() {
        ParkingSpace space1 = new CarParkingSpace(1);
        ParkingSpace space2 = new CarParkingSpace(1);
        Map<ParkingSpace, List<ParkingSpace>> spacesInfo = Map.of(space1, List.of(space2),
                space2, List.of());
        Parking parking = new StandardParking(spacesInfo);
        ParkingService service = new StandardParkingService(parking);
        Auto auto1 = new Bmw(1);
        Auto auto2 = new Bmw(1);
        Auto auto3 = new Bmw(1);
        service.parkAuto(auto1);
        service.parkAuto(auto2);
        assertThat(service.parkAuto(auto3)).hasSameElementsAs(List.of());
    }

    @Test
    void whenGetAutoThenAuto() {
        ParkingSpace space1 = new CarParkingSpace(1);
        ParkingSpace space2 = new CarParkingSpace(1);
        Map<ParkingSpace, List<ParkingSpace>> spacesInfo = Map.of(space1, List.of(space2),
                space2, List.of());
        Parking parking = new StandardParking(spacesInfo);
        ParkingService service = new StandardParkingService(parking);
        Auto auto1 = new Bmw(1);
        service.parkAuto(auto1);
        assertThat(service.getAuto(auto1, List.of(space1))).isEqualTo(auto1);
    }

    @Test
    void whenGetAutoNotParkedThenNull() {
        ParkingSpace space1 = new CarParkingSpace(1);
        ParkingSpace space2 = new CarParkingSpace(1);
        Map<ParkingSpace, List<ParkingSpace>> spacesInfo = Map.of(space1, List.of(space2),
                space2, List.of());
        Parking parking = new StandardParking(spacesInfo);
        ParkingService service = new StandardParkingService(parking);
        Auto auto1 = new Bmw(1);
        service.parkAuto(auto1);
        assertThat(service.getAuto(auto1, List.of(space2))).isNull();
    }
}