package ru.job4j.ood.foodstore.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Food {
    private final String name;
    private final Calendar createDate;
    private final Calendar expiryDate;
    private float price;
    private float discount;

    public Food(String name, Calendar createDate, Calendar expiryDate) {
        this.name = name;
        this.createDate = createDate;
        this.expiryDate = expiryDate;
    }

    public String getName() {
        return name;
    }

    public Calendar getCreateDate() {
        return createDate;
    }

    public Calendar getExpiryDate() {
        return expiryDate;
    }

    public float getPrice() {
        return price;
    }

    public float getDiscount() {
        return discount;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("dd:MM:yyyy");
        return "Food{"
                + "name='" + name + '\''
                + ", createDate=" + format.format(createDate.getTime())
                + ", expiryDate=" + format.format(expiryDate.getTime())
                + ", price=" + price
                + ", discount=" + discount
                + '}';
    }
}
