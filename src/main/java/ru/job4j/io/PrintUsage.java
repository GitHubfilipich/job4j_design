package ru.job4j.io;

import java.io.*;

public class PrintUsage {
    public static void main(String[] args) {
//        try (PrintStream stream = new PrintStream(new FileOutputStream("data/print.txt"))) {
//        try (PrintStream stream = new PrintStream("data/print.txt")) {
//        File file = new File("data/print.txt");
//        try (PrintStream stream = new PrintStream(file)) {
//            stream.println("Из PrintStream в FileOutputStream3");
//        try (PrintStream stream = new PrintStream(new FileOutputStream("data/print.txt"))) {
////        try (FileOutputStream stream = new FileOutputStream("data/print.txt")) {
//            stream.println("Из PrintStream в FileOutputStream4");
//            stream.write("Новая строка".getBytes());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        try (PrintStream stream = new PrintStream(new FileOutputStream("data/print.txt"));
             PrintWriter writer = new PrintWriter("data/write.txt")) {
            stream.println("Из PrintStream в FileOutputStream 5");
            stream.write("Новая строка".getBytes());
            writer.println("Новое сообщение");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
