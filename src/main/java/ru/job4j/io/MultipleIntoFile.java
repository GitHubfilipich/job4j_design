package ru.job4j.io;

import java.io.FileOutputStream;
import java.io.IOException;

public class MultipleIntoFile {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("data/fileofmultiple.txt")) {
            for (int i = 1; i <= 9; i++) {
                try {
                    out.write(String.format("1 * %1$s = %1$s", i).getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    out.write(System.lineSeparator().getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
