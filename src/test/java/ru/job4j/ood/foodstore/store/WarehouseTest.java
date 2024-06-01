package ru.job4j.ood.foodstore.store;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.foodstore.model.Food;
import ru.job4j.ood.foodstore.model.Lollipop;
import ru.job4j.ood.foodstore.model.Meat;
import ru.job4j.ood.foodstore.model.Rice;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class WarehouseTest {

    @Test
    void whenAddFood() {
        Food lollipops = new Lollipop("Lollipops", new GregorianCalendar(2024, Calendar.JANUARY, 1),
                new GregorianCalendar(2034, Calendar.DECEMBER, 31));
        Food rice = new Rice("Rice", new GregorianCalendar(2024, Calendar.JANUARY, 1),
                new GregorianCalendar(2034, Calendar.DECEMBER, 31));
        Food meat = new Meat("Meat", new GregorianCalendar(2024, Calendar.JANUARY, 1),
                new GregorianCalendar(2024, Calendar.DECEMBER, 31));
        Store store = new Warehouse();
        store.addFood(lollipops);
        store.addFood(rice);
        store.addFood(meat);
        assertThat(store.getFoods()).hasSameElementsAs(Set.of(lollipops, rice, meat));
    }

    @Test
    void whenRemoveFood() {
        Food lollipops = new Lollipop("Lollipops", new GregorianCalendar(2024, Calendar.JANUARY, 1),
                new GregorianCalendar(2034, Calendar.DECEMBER, 31));
        Food rice = new Rice("Rice", new GregorianCalendar(2024, Calendar.JANUARY, 1),
                new GregorianCalendar(2034, Calendar.DECEMBER, 31));
        Food meat = new Meat("Meat", new GregorianCalendar(2024, Calendar.JANUARY, 1),
                new GregorianCalendar(2024, Calendar.DECEMBER, 31));
        Store store = new Warehouse();
        store.addFood(lollipops);
        store.addFood(rice);
        store.addFood(meat);
        store.removeFood(rice);
        assertThat(store.getFoods()).hasSameElementsAs(Set.of(lollipops, meat));
    }

    @Test
    void whenGetFoods() {
        Food lollipops = new Lollipop("Lollipops", new GregorianCalendar(2024, Calendar.JANUARY, 1),
                new GregorianCalendar(2034, Calendar.DECEMBER, 31));
        Food rice = new Rice("Rice", new GregorianCalendar(2024, Calendar.JANUARY, 1),
                new GregorianCalendar(2034, Calendar.DECEMBER, 31));
        Food meat = new Meat("Meat", new GregorianCalendar(2024, Calendar.JANUARY, 1),
                new GregorianCalendar(2024, Calendar.DECEMBER, 31));
        Store store = new Warehouse();
        store.addFood(lollipops);
        store.addFood(rice);
        store.addFood(meat);
        store.removeFood(rice);
        store.removeFood(meat);
        assertThat(store.getFoods()).containsExactly(lollipops);
    }
}