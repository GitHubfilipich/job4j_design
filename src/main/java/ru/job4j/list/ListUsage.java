package ru.job4j.list;

import java.util.*;

public class ListUsage {
    public static void main(String[] args) {
        List<String> rsl = new ArrayList<>();
        rsl.add("one");
        rsl.add("two");
        rsl.add("three");
        rsl.add(1, "four");

        List<String> list = new ArrayList<>();
        list.add("four");
        list.add("five");

        rsl.addAll(3, list);
        for (String s : rsl) {
            System.out.println("Текущий элемент: " + s);
        }

        rsl = List.of("one", "two", "three");
        for (String s : rsl) {
            System.out.println("Текущий элемент2: " + s);
        }

        for (int i = 0; i < rsl.size(); i++) {
            System.out.println("Текущий элемент3: " + rsl.get(i));
        }

        Iterator<String> iterator = rsl.iterator();
        while (iterator.hasNext()) {
            System.out.println("Текущий элемент4: " + iterator.next());
        }

        ListIterator<String> listIterator = rsl.listIterator();
        while (listIterator.hasNext()) {
            System.out.println("Текущий элемент5: " + listIterator.next());
        }

        ListIterator<String> listIterator2 = rsl.listIterator(2);
        while (listIterator2.hasNext()) {
            System.out.println("Текущий элемент6: " + listIterator2.next());
        }

        rsl = new ArrayList<>();
        rsl.add("one");
        rsl.add("two");
        rsl.add("three");
        rsl.set(1, "two and second");
        for (String s : rsl) {
            System.out.println("Текущий элемент7: " + s);
        }

        rsl.replaceAll(String::toUpperCase);

        for (String s : rsl) {
            System.out.println("Текущий элемент8: " + s);
        }

        rsl.remove(1);

        for (String s : rsl) {
            System.out.println("Текущий элемент9: " + s);
        }

        rsl.remove("THREE");

        for (String s : rsl) {
            System.out.println("Текущий элемент10: " + s);
        }

        rsl = new ArrayList<>();
        rsl.add("one");
        rsl.add("two");
        rsl.add("three");

        list = new ArrayList<>();
        list.add("one");
        list.add("three");

        rsl.removeAll(list);

        for (String s : rsl) {
            System.out.println("Текущий элемент11: " + s);
        }

        rsl = new ArrayList<>();
        rsl.add("one");
        rsl.add("two");
        rsl.add("three");

        list = new ArrayList<>();
        list.add("one");
        list.add("three");

        rsl.retainAll(list);

        for (String s : rsl) {
            System.out.println("Текущий элемент12: " + s);
        }

        rsl = new ArrayList<>();
        rsl.add("one");
        rsl.add("two");
        rsl.add("three");

        rsl.removeIf(s -> s.length() <= 3);

        for (String s : rsl) {
            System.out.println("Текущий элемент13: " + s);
        }

        rsl = new ArrayList<>();
        rsl.add("one");
        rsl.add("two");
        rsl.add("three");

        boolean b = rsl.contains("two");

        System.out.println("Список содержит элемент: " + b);

        int i = rsl.indexOf("two");

        System.out.println("Индекс элемента в списке: " + i);

        rsl.add("one");

        i = rsl.lastIndexOf("one");

        System.out.println("Индекс элемента в списке2: " + i);

        List<Integer> rslI = List.of(1, 2, 3);
        int size = rslI.size();
        System.out.println("Размер списка равен: " + size);

        var listI = rslI.subList(1, 2);
        for (var s : listI) {
            System.out.println("Текущий элемент14: " + s);
        }

        listI = Arrays.asList(1, 2, 3);

        listI.sort(Comparator.reverseOrder());

        for (var s : listI) {
            System.out.println("Текущий элемент15: " + s);
        }
    }
}