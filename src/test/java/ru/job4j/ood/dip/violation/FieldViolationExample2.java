package ru.job4j.ood.dip.violation;

import java.util.HashMap;

/* Нарушение DIP - использование реализации (HashMap) вместо абстракции (Map) в типе аргумента метода */
public class FieldViolationExample2 {

    public void print(HashMap<String, String> map) {
        System.out.println("Print");
    }
}
