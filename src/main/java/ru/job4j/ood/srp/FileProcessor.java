package ru.job4j.ood.srp;

import java.io.File;

/* нарушение принципа SRP: выполняет три задачи - получение, обработку и сохранение */
public class FileProcessor {
    public void process(String name, String type) {
        File file;
        if ("binary".equals(type)) {
            file = receiveBinaryFile(name);
        } else {
            file = receiveTextFile(name);
        }
        executeFile(file);
        saveFile(file);
    }

    private File receiveBinaryFile(String name) {
        return null;
    }

    private File receiveTextFile(String name) {
        return null;
    }

    private void executeFile(File file) {
    }

    private void saveFile(File file) {
    }
}
