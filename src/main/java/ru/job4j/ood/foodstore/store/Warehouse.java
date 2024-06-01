package ru.job4j.ood.foodstore.store;

import java.util.HashSet;

public class Warehouse extends AbstractStore {
    public Warehouse() {
        super(new HashSet<>());
    }
}
