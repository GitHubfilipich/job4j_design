package ru.job4j.cache;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.StringJoiner;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        String value = null;
        Path path = FileSystems.getDefault().getPath(cachingDir, key);
        StringJoiner stringJoiner = new StringJoiner(System.lineSeparator());
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            reader.lines().forEach(stringJoiner::add);
            value = stringJoiner.toString();
        } catch (IOException e) {
            System.out.printf("Не удалось загрузить файл \"%s\" из директории \"%s\":\n%s\n",
                    key, cachingDir, Arrays.toString(e.getStackTrace()));
        }
        return value;
    }
}