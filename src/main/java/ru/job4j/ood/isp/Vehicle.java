package ru.job4j.ood.isp;

/* Нарушение принципа ISP: не все транспортные средства могут запустить двигатель (например, велосипед) */
public interface Vehicle {
    void startEngine();
    void run();
}
