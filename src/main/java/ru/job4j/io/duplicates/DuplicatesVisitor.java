package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {

    private final Map<FileProperty, List<Path>> files = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty fileProperty = new FileProperty(
                Files.readAttributes(file, BasicFileAttributes.class).size(), file.getFileName().toString());
        files.computeIfAbsent(fileProperty, f -> new LinkedList<>()).add(file);

        return super.visitFile(file, attrs);
    }

    public void printDuplicates() {
        files.forEach((file, paths) -> {
            if (paths.size() > 1) {
                System.out.printf("%s - %d%n", file.getName(), file.getSize());
                paths.forEach(path -> System.out.printf(" %s%n", path.toAbsolutePath()));
            }
        }
        );
    }
}
