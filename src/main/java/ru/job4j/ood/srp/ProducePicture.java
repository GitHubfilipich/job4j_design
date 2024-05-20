package ru.job4j.ood.srp;

/* нарушение принципа SRP: выполняет три задачи - формирование, проверку и вывод */
public class ProducePicture {
    public void produce(String type) {
        String picture = generate(type);
        test(picture);
        System.out.println(picture);
    }

    private void test(String picture) {
    }

    private String generate(String type) {
        return null;
    }
}
