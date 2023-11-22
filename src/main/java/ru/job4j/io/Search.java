package ru.job4j.io;

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
        search(start, p -> p.toFile().getName().endsWith(String.format(".%s", args[1]))).forEach(System.out::println);
    }

    private static void validateParameters(String[] args) {
        if (args.length < 2 || args[0] == null || args[1] == null) {
            throw new IllegalArgumentException("Incorrect parameters");
        }
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }
}
