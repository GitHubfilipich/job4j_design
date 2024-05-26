package ru.job4j.ood.srp.report;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.function.Predicate;

public class JsonReportEngine extends ReportEngine {
    private final Gson gson;

    public JsonReportEngine(Store store, DateTimeParser<Calendar> dateTimeParser) {
        super(store, dateTimeParser);
        TypeAdapter<GregorianCalendar> typeAdapter = new TypeAdapter<>() {
            @Override
            public void write(JsonWriter out, GregorianCalendar value) throws IOException {
                out.value(String.format("%1$td:%1$tm:%1$tY %1$tR", value));
            }

            @Override
            public GregorianCalendar read(JsonReader in) throws IOException {
                return null;
            }
        };
        this.gson = new GsonBuilder().registerTypeAdapter(GregorianCalendar.class, typeAdapter)
                .setPrettyPrinting().create();
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        return gson.toJson(store.findBy(filter));
    }
}
