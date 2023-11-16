package ru.job4j.io;

import java.io.*;

public class Analysis {
    public void unavailable(String source, String target) {
        try (BufferedReader in = new BufferedReader(new FileReader(source));
             BufferedWriter out = new BufferedWriter(new FileWriter(target))) {
            boolean available = true;
            String line;
            while ((line = in.readLine()) != null) {
                String[] subStrings = line.split(" ");
                if (available && ("400".equals(subStrings[0]) || "500".equals(subStrings[0]))) {
                    out.write(subStrings[1]);
                    available = false;
                } else if (!available && !"400".equals(subStrings[0]) && !"500".equals(subStrings[0])) {
                    out.write(";");
                    out.write(subStrings[1]);
                    out.write(System.lineSeparator());
                    available = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("data/server.log", "data/target.csv");
    }
}