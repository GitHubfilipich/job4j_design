package ru.job4j.ood.foodstore.store;

import ru.job4j.ood.foodstore.model.Food;

import java.util.Set;

abstract class AbstractStore implements Store {
    protected final Set<Food> foods;

    protected AbstractStore(Set<Food> foods) {
        this.foods = foods;
    }

    @Override
    public void addFood(Food food) {
        foods.add(food);
    }

    @Override
    public void removeFood(Food food) {
        foods.remove(food);
    }

    @Override
    public Set<Food> getFoods() {
        return Set.copyOf(foods);
    }
}
