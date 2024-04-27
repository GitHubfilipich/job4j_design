package ru.job4j.cache.menu;

import ru.job4j.cache.AbstractCache;
import ru.job4j.cache.DirFileCache;

import java.util.Scanner;

public class Emulator {
    public static final String MENU_FILE_NAME = "Введите имя файла (пустая строка для выхода)";
    public static final String MENU_FILE_CONTENT = "Содержимое файла:";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Укажите кэшируемую директорию (пустая строка для выхода):");
        String cachingDir = scanner.nextLine();
        if (cachingDir.isBlank()) {
            return;
        }
        AbstractCache<String, String> cache = new DirFileCache(cachingDir);
        while (true) {
            System.out.println(MENU_FILE_NAME);
            String fileName = scanner.nextLine();
            if (fileName.isBlank()) {
                return;
            }
            String content = cache.get(fileName);
            if (content != null) {
                System.out.println(MENU_FILE_CONTENT);
                System.out.println(content);
            }
        }
    }
}
