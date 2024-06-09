package ru.job4j.ood.isp;

public class TV implements Device {
    private String command;

    @Override
    public void in(String data) {
        this.command = data;
    }

    @Override
    public void calculate() {
        System.out.println("Execute: " + command);
    }

    @Override
    public void output() {
        System.out.println("Show TV program");
    }
}
