package ru.job4j.ood.foodstore.control;

import ru.job4j.ood.foodstore.model.Food;
import ru.job4j.ood.foodstore.store.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ControlQuality {
    private final Consumer<Food> processingRule;

    public ControlQuality(Consumer<Food> processingRule) {
        this.processingRule = processingRule;
    }

    public void control(Food food) {
        processingRule.accept(food);
    }

    public void resort(List<Store> stores) {
        List<Food> foods = new ArrayList<>();
        stores.forEach(store -> store.getFoods().forEach(food -> {
                            foods.add(food);
                            store.removeFood(food);
                        }
                )
        );
        foods.forEach(this::control);
    }
}
