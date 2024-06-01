package ru.job4j.ood.foodstore.model;

import java.util.Calendar;

public class Meat extends Food {
    public Meat(String name, Calendar createDate, Calendar expiryDate) {
        super(name, createDate, expiryDate);
    }
}
