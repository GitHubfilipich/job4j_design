package ru.job4j.kiss.fool;

import java.util.Scanner;

public class Fool {

    public static void main(String[] args) {
        System.out.println("Игра FizzBuzz.");
        var startAt = 1;
        var input = new Scanner(System.in);
        while (startAt < 100) {
            System.out.println(getCorrectAnswer(startAt));
            startAt++;
            var answer = input.nextLine();
            if (!getCorrectAnswer(startAt).equals(answer)) {
                System.out.println("Ошибка. Начинай снова.");
                startAt = 0;
            }
            startAt++;
        }
    }

    public static String getCorrectAnswer(int startAt) {
        String result = "";
        if (isDivisibleBy(startAt, 3)) {
            result = "Fizz";
        }
        if (isDivisibleBy(startAt, 5)) {
            result += "Buzz";
        }
        if (result.isEmpty()) {
            result = String.valueOf(startAt);
        }
        return result.intern();
    }

    public static boolean isDivisibleBy(int dividend, int divider) {
        return dividend % divider == 0;
    }

}
