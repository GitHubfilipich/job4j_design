package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.currency.Currency;
import ru.job4j.ood.srp.currency.CurrencyConverter;
import ru.job4j.ood.srp.currency.InMemoryCurrencyConverter;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;
import java.util.function.Predicate;

public class AccountingReport extends ReportEngine {
    private final Currency currency;

    public AccountingReport(Store store, DateTimeParser<Calendar> dateTimeParser, Currency currency) {
        super(store, dateTimeParser);
        this.currency = currency;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        CurrencyConverter converter = new InMemoryCurrencyConverter();
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(" ")
                    .append(dateTimeParser.parse(employee.getHired())).append(" ")
                    .append(dateTimeParser.parse(employee.getFired())).append(" ")
                    .append(currency == Currency.RUB
                            ? employee.getSalary() : converter.convert(Currency.RUB, employee.getSalary(), currency))
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
