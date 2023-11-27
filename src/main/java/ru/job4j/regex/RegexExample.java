package ru.job4j.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("Job4j", Pattern.CASE_INSENSITIVE);
        String text = "JoB4j1 и Job4j2 и JOb4j3";
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println("Найдено совпадение: " + matcher.group() + " iStart: " + matcher.start()
                    + " iEnd: " + matcher.end());
        }

        pattern = Pattern.compile("123");
        text = "1231 и 1232 и 1233";
        matcher = pattern.matcher(text);
        String rsl = matcher.replaceAll("Job4j");
        System.out.println(rsl);
    }
}
