package ru.job4j.pool;

public class IntPoolExample {

    public static void main(String[] args) {
        main1();
        System.out.println();
        main2();
    }

    public static void main1() {
        Integer pool1 = 127;
        Integer pool2 = 127;
        System.out.println(pool1 == pool2);
        Integer heap1 = -129;
        Integer heap2 = -129;
        System.out.println(heap1 == heap2);
    }

    public static void main2() {
        Integer pool1 = new Integer(127);
        Integer pool2 = new Integer(127);
        System.out.println(pool1 == pool2);
    }
}
