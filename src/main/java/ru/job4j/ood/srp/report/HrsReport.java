package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;
import java.util.function.Predicate;

public class HrsReport extends ReportEngine {
    public HrsReport(Store store, DateTimeParser<Calendar> dateTimeParser) {
        super(store, dateTimeParser);
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;")
                .append(System.lineSeparator());
        store.findBy(filter).stream()
                .sorted((employee1, employee2) -> (int) (employee2.getSalary() - employee1.getSalary()))
                .forEach(employee -> text.append(employee.getName()).append(" ")
                        .append(employee.getSalary())
                        .append(System.lineSeparator()));
        return text.toString();
    }
}
