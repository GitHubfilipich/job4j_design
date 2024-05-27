package ru.job4j.ood.lsp;

public class ThirdRule {
    public static void main(String[] args) {
        Subscriber subscriber = new SomeOperatorSubscriber(
                new PhoneNumber(+1, 111, 111_111_111)
        );
        System.out.println(subscriber.phoneNumber);
        subscriber.setPhoneNumber(
                new PhoneNumber(-1, 111, 111_111_111)
        );
        System.out.println(subscriber.phoneNumber);
    }
}
