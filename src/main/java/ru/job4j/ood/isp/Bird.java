package ru.job4j.ood.isp;

/* Нарушение принципа ISP: не все птицы могут летать (например, страус) */
public interface Bird {
    void voice();
    void fly();
}
