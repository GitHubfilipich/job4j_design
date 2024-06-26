package ru.job4j.ood.dip.violation;

import java.util.ArrayList;

/* Нарушение DIP - использование реализации (ArrayList) вместо абстракции (List) в типе поля */
public class FieldViolationExample {

    public ArrayList<String> strings;
}
