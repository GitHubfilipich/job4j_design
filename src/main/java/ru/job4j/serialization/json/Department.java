package ru.job4j.serialization.json;

import java.util.Arrays;

public class Department {
    private final boolean actual;
    private final int level;
    private final String name;
    private final Person supervisor;

    private final Contact[] contacts;

    public Department(boolean actual, int level, String name, Person supervisor, Contact[] contacts) {
        this.actual = actual;
        this.level = level;
        this.name = name;
        this.supervisor = supervisor;
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "Department{"
                + "actual=" + actual
                + ", level=" + level
                + ", name='" + name + '\''
                + ", supervisor=" + supervisor
                + ", contacts=" + Arrays.toString(contacts)
                + '}';
    }

    public boolean getActual() {
        return actual;
    }

    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public Person getSupervisor() {
        return supervisor;
    }

    public Contact[] getContacts() {
        return contacts;
    }
}
