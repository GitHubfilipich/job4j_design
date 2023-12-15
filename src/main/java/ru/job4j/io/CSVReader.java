package ru.job4j.io;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class CSVReader {
    public static void handle(ArgsName argsName) throws Exception {
        validateParameters(argsName);
        List<String> lines = getLines(argsName);
        output(argsName, lines);
    }

    private static void validateParameters(ArgsName argsName) {
        argsName.get("path");
        argsName.get("delimiter");
        String out = argsName.get("out");
        if (!("stdout".equals(out) || out.toLowerCase().endsWith(".csv"))) {
            throw new IllegalArgumentException(
                    String.format("This key: 'out' has an invalid value '%s' - %s", out,
                            "it must contain the value 'stdout' or the path to the file where you want to output"));
        }
        String filter = argsName.get("filter");
        Arrays.stream(filter.split(",")).forEach(s -> {
            if ("".equals(s)) {
                throw new IllegalArgumentException(
                        String.format("This key: 'filter' has an invalid value '%s' - %s", filter,
                                "it must contain the column names separated by comma"));
            }
        });
    }

    private static List<String> getLines(ArgsName argsName) throws Exception {
        List<String> rsl = new LinkedList<>();
        try (Scanner scanner = new Scanner(Path.of(argsName.get("path")))) {
            int maxColumnIndex = 0;
            Map<String, Integer> filters = new LinkedHashMap<>();
            Arrays.stream(argsName.get("filter").split(",")).forEach(filter -> filters.put(filter, 0));
            String delimiter = argsName.get("delimiter");
            boolean firstRow = true;
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] columns = line.split(delimiter, -1);
                if (firstRow) {
                    List<String> columnsNames = Arrays.stream(columns).toList();
                    for (Map.Entry<String, Integer> entry : filters.entrySet()) {
                        entry.setValue(columnsNames.indexOf(entry.getKey()));
                    }
                    List<String> notFound = filters.entrySet().stream()
                            .filter(entry -> entry.getValue() == -1)
                            .map(Map.Entry::getKey)
                            .toList();
                    if (notFound.size() > 0) {
                        throw new Exception(
                                String.format("Columns not found in file: '%s'", String.join(", ", notFound)));
                    }
                    maxColumnIndex = filters.values().stream().max(Integer::compareTo).orElse(0);
                    firstRow = false;
                } else {
                    if (columns.length < maxColumnIndex + 1) {
                        throw new Exception(
                                String.format("Row '%s' contains fewer columns than header row", line));
                    }
                }

                rsl.add(filters.values().stream()
                        .map(integer -> columns[integer])
                        .collect(Collectors.joining(delimiter)));

            }
        }
        return rsl;
    }

    private static void output(ArgsName argsName, List<String> lines) {
        String out = argsName.get("out");
        if ("stdout".equals(out)) {
            lines.forEach(System.out::println);
        } else {
            try (PrintWriter writer = new PrintWriter(out)) {
                lines.forEach(writer::println);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ArgsName argsName = ArgsName.of(args);
        try {
            handle(argsName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
