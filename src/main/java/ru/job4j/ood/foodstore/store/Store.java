package ru.job4j.ood.foodstore.store;

import ru.job4j.ood.foodstore.model.Food;

import java.util.Set;

public interface Store {
    void addFood(Food food);
    void removeFood(Food food);
    Set<Food> getFoods();
}
