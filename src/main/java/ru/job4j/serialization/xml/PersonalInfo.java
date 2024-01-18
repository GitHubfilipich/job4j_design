package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.*;
import java.util.Arrays;

@XmlRootElement(name = "PersonalInfo")
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonalInfo {
    @XmlAttribute
    private int id;
    private Person person;
    @XmlAttribute
    private boolean actual;
    @XmlAttribute
    private String comment;
    @XmlElementWrapper(name = "tags")
    @XmlElement(name = "tag")
    private String[] tags;

    public PersonalInfo() {
    }

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
