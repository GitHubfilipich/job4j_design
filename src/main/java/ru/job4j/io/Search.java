package ru.job4j.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    public static void main(String[] args) throws IOException {
        validateParameters(args);
        Path start = Paths.get(args[0]);
        search(start, p -> p.toFile().getName().endsWith(args[1])).forEach(System.out::println);
    }

    private static void validateParameters(String[] args) {
        if (args.length < 2) {
            throw new IllegalArgumentException("Incorrect parameters - number of parameters less then two");
        }
        File dir = Path.of(args[0]).toFile();
        if (!dir.isDirectory()) {
            throw new IllegalArgumentException("Incorrect first parameter - it`s not directory");
        }
        if (!dir.exists()) {
            throw new IllegalArgumentException("Incorrect first parameter - directory not exists");
        }
        if (!args[1].startsWith(".")) {
            throw new IllegalArgumentException("Incorrect second parameter - not starts with dot mark");
        }
        if (args[1].length() == 1) {
            throw new IllegalArgumentException("Incorrect second parameter - not contain any symbols other than a dot");
        }
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }
}
