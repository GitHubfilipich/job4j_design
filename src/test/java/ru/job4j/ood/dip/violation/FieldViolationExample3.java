package ru.job4j.ood.dip.violation;

import java.util.HashSet;

/* Нарушение DIP - использование реализации (HashSet) вместо абстракции (Set) в типе возвращаемого значения метода */
public class FieldViolationExample3 {

    public HashSet<String> result() {
        return new HashSet<String>();
    }
}
