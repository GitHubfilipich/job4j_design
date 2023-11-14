package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {

    private final String path;
    private final Map<String, String> values = new HashMap<>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader in = new BufferedReader(new FileReader(path))) {
            in.lines().forEach(s -> {
                if (s != null && !s.startsWith("#") && !s.isEmpty()) {
                    if (s.startsWith("=")) {
                        throw new IllegalArgumentException();
                    }
                    String[] subStrings = s.split("=", 2);
                    if (subStrings.length == 2 && !subStrings[0].isBlank() && !subStrings[1].isBlank()) {
                        values.put(subStrings[0], subStrings[1]);
                    } else {
                        throw new IllegalArgumentException();
                    }

                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Config("data/app.properties"));
    }

}
