package ru.job4j.regex;

import java.util.Arrays;
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

        pattern = Pattern.compile("11");
        text = "111111";
        matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println("Найдено совпадение: " + matcher.group());
        }

        String str = "123+=-456:/789";
        String[] rsl1 = str.split("\\D+");
        System.out.println(Arrays.toString(rsl1));

        pattern = Pattern.compile("\\b\\d{2}\\.\\d{2}\\.\\d{4}\\b");
        text = "24.04.1987 11.11.111111 99.99.99991 99.99.9999 99999999 0000.00.00";
        matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println("Найдено совпадение: " + matcher.group());
        }

        pattern = Pattern.compile("\\S{1,}@\\S{1,}\\.\\S{1,}");
        text = "peter-2022@example.com example65@mail_box.ru 123_45@example-mailbox.com";
        matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println("Найдено совпадение: " + matcher.group());
        }
    }
}
