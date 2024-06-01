package ru.job4j.ood.foodstore.control;

import ru.job4j.ood.foodstore.model.Food;

import java.util.function.Consumer;

public class ControlQuality {
    private final Consumer<Food> processingRule;

    public ControlQuality(Consumer<Food> processingRule) {
        this.processingRule = processingRule;
    }

    public void control(Food food) {
        processingRule.accept(food);
    }
}
