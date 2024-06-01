package ru.job4j.ood.foodstore.model;

import java.util.Calendar;

public class Cheese extends Food {
    public Cheese(String name, Calendar createDate, Calendar expiryDate) {
        super(name, createDate, expiryDate);
    }
}
