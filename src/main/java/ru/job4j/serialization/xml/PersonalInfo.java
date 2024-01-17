package ru.job4j.serialization.xml;

import java.util.Arrays;

public class PersonalInfo {
    private final int id;
    private final Person person;
    private final boolean actual;
    private final String comment;
    private final String[] tags;

    public PersonalInfo(int id, Person person, boolean actual, String comment, String[] tags) {
        this.id = id;
        this.person = person;
        this.actual = actual;
        this.comment = comment;
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "PersonalInfo{"
                + "id=" + id
                + ", person=" + person
                + ", actual=" + actual
                + ", comment='" + comment + '\''
                + ", tags=" + Arrays.toString(tags)
                + '}';
    }
}
