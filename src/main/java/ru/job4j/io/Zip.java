package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            sources.forEach(path -> {
                try {
                    zip.putNextEntry(new ZipEntry(path.toAbsolutePath().toString()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(target))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void validateParameters(ArgsName argsNames) {
        String directory = argsNames.get("d");
        File directoryFile = new File(directory);
        if (!directoryFile.isDirectory()) {
            throw new IllegalArgumentException(
                    String.format("Error: parameter 'd' = '%s' is not directory", directory));
        }
        if (!directoryFile.exists()) {
            throw new IllegalArgumentException(
                    String.format("Error: parameter 'd' = '%s' not exists", directory));
        }

        String exclude = argsNames.get("e");
        if (!exclude.startsWith(".")) {
            throw new IllegalArgumentException(
                    String.format("Error: parameter 'e' = '%s' not starts with dot mark", exclude));
        }
        if (exclude.length() == 1) {
            throw new IllegalArgumentException(
                    String.format("Error: parameter 'e' = '%s' not contains any symbols other than a dot", exclude));
        }

        String output = argsNames.get("o");
        if (!output.endsWith(".zip")) {
            throw new IllegalArgumentException(
                    String.format("Error: parameter 'o' = '%s' has extension other than '.zip'", exclude));
        }
    }

    public static void main(String[] args) throws IOException {
        ArgsName argsNames = ArgsName.of(args);
        validateParameters(argsNames);
        List<Path> pathList = Search.search(Path.of(argsNames.get("d")), path -> !path.toString().endsWith(argsNames.get("e")));
        new Zip().packFiles(pathList, new File(argsNames.get("o")));
    }
}