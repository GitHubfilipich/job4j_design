package ru.job4j.io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class ResultFile {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("data/dataresult.txt")) {
            out.write("Hello, world!".getBytes());
            out.write(System.lineSeparator().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream("data/result.txt")
                ))) {
            out.println("Hello, world!");
            out.printf("%s%n%s", "Hello", "world");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
