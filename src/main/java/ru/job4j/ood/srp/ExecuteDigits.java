package ru.job4j.ood.srp;

/* нарушение принципа SRP: выполняет две задачи - суммирование и печать */
public class ExecuteDigits {
    public int sum(int first, int second) {
        return first + second;
    }

    public void print(int digit) {
        System.out.println(digit);
    }
}
