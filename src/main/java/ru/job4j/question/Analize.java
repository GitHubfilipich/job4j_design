package ru.job4j.question;

import java.util.*;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        Info info = new Info(0, 0, 0);
        Map<Integer, String> previousMap = new HashMap<>();
        for (User user : previous) {
            previousMap.put(user.getId(), user.getName());
        }
        Map<Integer, String> currentMap = new HashMap<>();
        for (User user : current) {
            currentMap.put(user.getId(), user.getName());
        }
        for (Map.Entry<Integer, String> entry: currentMap.entrySet()) {
            String name = previousMap.get(entry.getKey());
            if (name == null) {
                info.setAdded(info.getAdded() + 1);
            } else {
                if (!Objects.equals(name, entry.getValue())) {
                    info.setChanged(info.getChanged() + 1);
                }
                previousMap.remove(entry.getKey());
            }
        }
        info.setDeleted(previousMap.size());
        return info;
    }
}
