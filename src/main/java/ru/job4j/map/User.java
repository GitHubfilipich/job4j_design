package ru.job4j.map;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        Map<User, Object> map = new HashMap<>();
        Calendar calendar = Calendar.getInstance();
        User user1 = new User("User", 1, calendar);
        int hashCode1 = user1.hashCode();
        int hash1 = hashCode1 ^ (hashCode1 >>> 16);
        int buket1 = hash1 & 15;
        User user2 = new User("User", 1, calendar);
        int hashCode2 = user2.hashCode();
        int hash2 = hashCode2 ^ (hashCode2 >>> 16);
        int buket2 = hash2 & 15;
        map.put(user1, new Object());
        map.put(user2, new Object());
        map.forEach((user, o) -> System.out.printf("User = %s, Object = %s\n", user, o));
        System.out.printf("User1: hashCode %S, hash %s, bucket %s\n", hashCode1, hash1, buket1);
        System.out.printf("User2: hashCode %S, hash %s, bucket %s\n", hashCode2, hash2, buket2);
        System.out.printf("user2.equals(user1) = %s", user2.equals(user1));
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return children == user.children && Objects.equals(name, user.name) && Objects.equals(birthday, user.birthday);
    }
}
