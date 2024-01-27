package ru.job4j.io.searchkriteria;

import java.io.*;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class SearchMain {
    private static ArgsName validatedParameters(String[] args) {
        ArgsName name = ArgsName.of(args);
        for (Map.Entry<String, String> keyNameHelp : Map.of("d", "directory to start searching in",
                "o", "file for recording the result").entrySet()) {
            if (!name.keyExists(keyNameHelp.getKey())) {
                throw new IllegalArgumentException(
                        String.format("Key '%s' ('%s') is missing", keyNameHelp.getKey(), keyNameHelp.getValue()));
            }
        }
        if (name.keyExists("n")) {
            if (!name.keyExists("t")) {
                throw new IllegalArgumentException("Key 't' ('search type') is missing "
                        + "while the key 'n' ('file name to search') is specified");
            } else {
                List<String> values = Arrays.asList("mask", "name", "regex");
                if (!values.contains(name.get("t"))) {
                    StringJoiner joiner = new StringJoiner(", ", "'", "'");
                    values.forEach(joiner::add);
                    throw new IllegalArgumentException(String.format("Value of key 't' ('search type') = '%s' "
                            + "is incorrect - it must be one of: '%s'", name.get("t"), joiner));
                }
            }
        }
        File dir = Path.of(name.get("d")).toFile();
        if (!dir.isDirectory()) {
            throw new IllegalArgumentException(String.format("Value of key 'd' ('directory to start searching in') = "
                    + "'%s' is incorrect - it`s not directory", name.get("d")));
        }
        if (!dir.exists()) {
            throw new IllegalArgumentException(String.format("Value of key 'd' ('directory to start searching in') = "
                    + "'%s' is incorrect - directory not exists", name.get("d")));
        }
        return name;
    }

    private static List<Path> search(String directory, String name, String type) {
        Predicate<Path> condition;
        if (name != null) {
            condition = switch (type) {
                case "mask" -> path -> Pattern.compile(
                        name.replace(".", "\\.")
                                .replace("*", ".*")
                                .replace("?", "."))
                        .matcher(path.toFile().getName()).matches();
                case "regex" -> path -> Pattern.compile(name).matcher(path.toFile().getName()).matches();
                default -> path -> path.toFile().getName().equals(name);
            };
        } else {
            condition = path -> true;
        }

        List<Path> result = null;
        try {
            result = Search.search(Path.of(directory), condition);
        } catch (IOException e) {
            System.out.println("Error during searching:");
            e.printStackTrace();
        }

        return result;
    }

    private static void write(String fileName, List<Path> paths) {
        if (paths != null) {
            try (PrintWriter writer = new PrintWriter(new BufferedOutputStream(new FileOutputStream(fileName)))) {
                paths.forEach(writer::println);
            } catch (IOException e) {
                System.out.println("Error during saving to file:");
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        ArgsName parameters = validatedParameters(args);

        List<Path> paths = search(parameters.get("d"),
                parameters.keyExists("n") ? parameters.get("n") : null,
                parameters.keyExists("t") ? parameters.get("t") : null);

        write(parameters.get("o"), paths);
    }
}
