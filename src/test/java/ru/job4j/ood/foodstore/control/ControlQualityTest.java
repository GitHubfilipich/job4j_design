package ru.job4j.ood.foodstore.control;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.foodstore.model.*;
import ru.job4j.ood.foodstore.store.*;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

class ControlQualityTest {

    @Test
    void whenControlInputOfFoods() {
        Food lollipop = new Lollipop("Lollipop", new GregorianCalendar(2024, Calendar.JANUARY, 1),
                new GregorianCalendar(2034, Calendar.DECEMBER, 31));
        Food rice = new Rice("Rice", new GregorianCalendar(2024, Calendar.JANUARY, 1),
                new GregorianCalendar(2034, Calendar.DECEMBER, 31));
        Food meat = new Meat("Meat", new GregorianCalendar(2024, Calendar.JANUARY, 1),
                new GregorianCalendar(2024, Calendar.DECEMBER, 31));
        Food fish = new Fish("Fish", new GregorianCalendar(2024, Calendar.JANUARY, 1),
                new GregorianCalendar(2024, Calendar.JUNE, 30));
        fish.setPrice(10f);
        Food tomato = new Tomato("Tomato", new GregorianCalendar(2024, Calendar.JANUARY, 1),
                new GregorianCalendar(2024, Calendar.JUNE, 30));
        tomato.setPrice(20f);
        Food cheese = new Cheese("Cheese", new GregorianCalendar(2024, Calendar.JANUARY, 1),
                new GregorianCalendar(2024, Calendar.MAY, 31));

        Store warehouse = new Warehouse();
        Store shop = new Shop();
        Store trash = new Trash();

        ControlQuality controlQuality = new ControlQuality(food -> {
            long validityPeriod = food.getExpiryDate().getTimeInMillis()
                    - food.getCreateDate().getTimeInMillis();
            long usedValidityPeriod = new GregorianCalendar(2024, Calendar.JUNE, 1).getTimeInMillis()
                    - food.getCreateDate().getTimeInMillis();
            long consumptionOfValidityPeriod = validityPeriod > 0 && usedValidityPeriod > 0
                    ? usedValidityPeriod * 100 / validityPeriod : 100;
            if (consumptionOfValidityPeriod < 25) {
                warehouse.addFood(food);
            } else if (consumptionOfValidityPeriod <= 75) {
                shop.addFood(food);
            } else if (consumptionOfValidityPeriod < 100) {
                shop.addFood(food);
                food.setPrice(food.getPrice() * 0.8f);
            } else {
                trash.addFood(food);
            }
        });

        List<Food> foods = List.of(lollipop, rice, meat, fish, tomato, cheese);
        foods.forEach(controlQuality::control);

        assertThat(warehouse.getFoods()).hasSameElementsAs(Set.of(lollipop, rice));

        assertThat(shop.getFoods()).hasSameElementsAs(Set.of(meat, fish, tomato));
        assertThat(fish.getPrice()).isCloseTo(8, offset(0.1f));
        assertThat(tomato.getPrice()).isCloseTo(16, offset(0.1f));

        assertThat(trash.getFoods()).hasSameElementsAs(Set.of(cheese));
    }

    @Test
    void whenResortStores() {
        Food lollipop = new Lollipop("Lollipops", new GregorianCalendar(2024, Calendar.JANUARY, 1),
                new GregorianCalendar(2034, Calendar.DECEMBER, 31));
        Food rice = new Rice("Rice", new GregorianCalendar(2024, Calendar.JANUARY, 1),
                new GregorianCalendar(2034, Calendar.DECEMBER, 31));
        Food meat = new Meat("Meat", new GregorianCalendar(2024, Calendar.JANUARY, 1),
                new GregorianCalendar(2024, Calendar.DECEMBER, 31));
        Food fish = new Fish("Fish", new GregorianCalendar(2024, Calendar.JANUARY, 1),
                new GregorianCalendar(2024, Calendar.JUNE, 30));
        fish.setPrice(10f);
        Food tomato = new Tomato("Tomato", new GregorianCalendar(2024, Calendar.JANUARY, 1),
                new GregorianCalendar(2024, Calendar.JUNE, 30));
        tomato.setPrice(20f);
        Food cheese = new Cheese("Cheese", new GregorianCalendar(2024, Calendar.JANUARY, 1),
                new GregorianCalendar(2024, Calendar.MAY, 31));

        Store warehouse = new Warehouse();
        Store shop = new Shop();
        Store trash = new Trash();

        ControlQuality controlQuality = new ControlQuality(food -> {
            long validityPeriod = food.getExpiryDate().getTimeInMillis()
                    - food.getCreateDate().getTimeInMillis();
            long usedValidityPeriod = new GregorianCalendar(2024, Calendar.JUNE, 1).getTimeInMillis()
                    - food.getCreateDate().getTimeInMillis();
            long consumptionOfValidityPeriod = validityPeriod > 0 && usedValidityPeriod > 0
                    ? usedValidityPeriod * 100 / validityPeriod : 100;
            if (consumptionOfValidityPeriod < 25) {
                warehouse.addFood(food);
            } else if (consumptionOfValidityPeriod <= 75) {
                shop.addFood(food);
            } else if (consumptionOfValidityPeriod < 100) {
                shop.addFood(food);
                food.setPrice(food.getPrice() * 0.8f);
            } else {
                trash.addFood(food);
            }
        });

        warehouse.addFood(lollipop);
        warehouse.addFood(rice);
        warehouse.addFood(meat);

        shop.addFood(fish);

        trash.addFood(tomato);
        trash.addFood(cheese);

        controlQuality.resort(List.of(warehouse, shop, trash));

        assertThat(warehouse.getFoods()).hasSameElementsAs(Set.of(lollipop, rice));

        assertThat(shop.getFoods()).hasSameElementsAs(Set.of(meat, fish, tomato));
        assertThat(fish.getPrice()).isCloseTo(8, offset(0.1f));
        assertThat(tomato.getPrice()).isCloseTo(16, offset(0.1f));

        assertThat(trash.getFoods()).hasSameElementsAs(Set.of(cheese));
    }
}