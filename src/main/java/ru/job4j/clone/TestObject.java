package ru.job4j.clone;

public class TestObject implements Cloneable {
    int num;
    InnerObject innerObj;

    @Override
    protected TestObject clone() throws CloneNotSupportedException {
        TestObject testObj = (TestObject) super.clone();
        if (innerObj != null) {
            testObj.innerObj = innerObj.clone();
        }
        return testObj;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        main1();
        System.out.println();
        main2();
        System.out.println();
        main3();
    }

    public static void main1() {
        TestObject testObj1 = new TestObject();
        testObj1.num = 5;
        TestObject testObj2 = testObj1;
        testObj2.num = 10;
        System.out.println(testObj1.num);
        System.out.println(testObj2.num);
    }

    public static void main2() throws CloneNotSupportedException {
        TestObject testObj1 = new TestObject();
        testObj1.num = 5;
        TestObject testObj2 = testObj1.clone();
        testObj2.num = 10;
        System.out.println(testObj1.num);
        System.out.println(testObj2.num);
    }

    public static void main3() throws CloneNotSupportedException {
        TestObject testObj1 = new TestObject();
        testObj1.num = 5;
        InnerObject innerObj = new InnerObject();
        innerObj.num = 15;
        testObj1.innerObj = innerObj;
        TestObject testObj2 = testObj1.clone();
        testObj2.num = 25;
        testObj2.innerObj.num = 35;
        System.out.println("Исходный класс: " + testObj1.num);
        System.out.println("Исходный класс: " + testObj1.innerObj.num);
        System.out.println("Скопированный класс: " + testObj2.num);
        System.out.println("Скопированный класс: " + testObj2.innerObj.num);
    }
}
