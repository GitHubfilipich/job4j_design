package ru.job4j.ood.ocp;

import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.report.HrsReport;
import ru.job4j.ood.srp.store.MemoryStore;

/* Нарушения принципов OCP */
/*  1: использование реализации при создании объекта внутри метода */
/*  2: использование реализации вместо абстракции в параметре метода */
/*  3: использование реализации вместо абстракции в возвращаемом значении метода */
public class ClassA {
    public HrsReport getReport(MemoryStore store) {
        HrsReport report = new HrsReport(store, new ReportDateTimeParser());
        return report;
    }
}
