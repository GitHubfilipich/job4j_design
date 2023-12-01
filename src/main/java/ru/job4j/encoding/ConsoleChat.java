package ru.job4j.encoding;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        String status = ConsoleChat.CONTINUE;

        Scanner scanner = new Scanner(System.in);

        List<String> log = new LinkedList<>();
        List<String> strings = readPhrases();
        Random random = new Random();

        while (!ConsoleChat.OUT.equals(status)) {
            String phrase = scanner.nextLine();
            log.add(String.format("user: %s", phrase));

            if (ConsoleChat.OUT.equalsIgnoreCase(phrase)) {
                status = ConsoleChat.OUT;
            } else if (ConsoleChat.STOP.equalsIgnoreCase(phrase)) {
                status = ConsoleChat.STOP;
            } else if (ConsoleChat.CONTINUE.equalsIgnoreCase(phrase)) {
                status = ConsoleChat.CONTINUE;
            }

            if (ConsoleChat.CONTINUE.equals(status) && !strings.isEmpty()) {
                String answer = strings.get(random.nextInt(strings.size()));
                System.out.println(answer);
                log.add(String.format("bot: %s", answer));
            }
        }
        saveLog(log);
    }

    private List<String> readPhrases() {
        List<String> rsl = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(botAnswers))) {
            br.lines().forEach(rsl::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(path, true))) {
            log.forEach(writer::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("./data/ConsoleChatLog.txt", "./data/ConsoleChatBotAnswers.txt");
        cc.run();
    }
}
