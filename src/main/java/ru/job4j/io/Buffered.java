package ru.job4j.io;

import java.io.*;

public class Buffered {
    public static void main(String[] args) {
//        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream("data/newData.txt"));
        try (BufferedReader in = new BufferedReader(new FileReader("data/newData.txt"));
             BufferedWriter out = new BufferedWriter(new FileWriter("data/output.txt", true))) {
            StringBuilder stringBuilder = new StringBuilder();
            int i;
            while ((i = in.read()) != -1) {
                stringBuilder.append((char) i);
            }
            out.write(stringBuilder.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
