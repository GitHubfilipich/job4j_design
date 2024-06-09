package ru.job4j.ood.isp;

/* Нарушение принципа ISP: не все детские игрушки могут стрелять (например, кукла) или издавать звук (мяч) */
public interface ChildrenToy {
    void move();
    void voice();
    void fire();
}
