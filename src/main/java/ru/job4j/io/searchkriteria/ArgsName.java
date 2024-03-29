package ru.job4j.io.searchkriteria;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    public Boolean keyExists(String key) {
        return values.containsKey(key);
    }

    public String get(String key) {
        if (!keyExists(key)) {
            throw new IllegalArgumentException(
                    String.format("This key: '%s' is missing", key));
        }
        return values.get(key);
    }

    private void parse(String[] args) {
        for (String s : args) {
            validateParameter(s);
            String[] keyAndValue = s.split("=", 2);
            values.put(keyAndValue[0].substring(1), keyAndValue[1]);
        }
    }

    private void validateParameter(String s) {
        if (!s.contains("=")) {
            throw new IllegalArgumentException(
                    String.format("Error: This argument '%s' does not contain an equal sign", s));
        }
        if (!s.startsWith("-")) {
            throw new IllegalArgumentException(
                    String.format("Error: This argument '%s' does not start with a '-' character", s));
        }
        String[] keyAndValue = s.split("=", 2);
        if (keyAndValue[0].length() == 1) {
            throw new IllegalArgumentException(
                    String.format("Error: This argument '%s' does not contain a key", s));
        }
        if (keyAndValue.length < 2 || keyAndValue[1].isEmpty()) {
            throw new IllegalArgumentException(
                    String.format("Error: This argument '%s' does not contain a value", s));
        }
    }

    public static ArgsName of(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Arguments not passed to program");
        }
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }
}
