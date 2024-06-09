package ru.job4j.ood.isp;

public interface Message {
    void send();
    String toAddress();
    String fromAddress();
}
