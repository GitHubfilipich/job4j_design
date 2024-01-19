package ru.job4j.serialization.json;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainDepartmentToJSON {

    public static void main(String[] args) {

        JSONObject jsonContact = new JSONObject("{\"phone\":\"11-111\"}");

        List<String> list = new ArrayList<>();
        list.add("Student");
        list.add("Free");
        JSONArray jsonStatuses = new JSONArray(list);

        final Person person = new Person(false, 30, new Contact("11-111"), "Student", "Free");
        JSONObject jsonPerson = new JSONObject();
        jsonPerson.put("sex", person.getSex());
        jsonPerson.put("age", person.getAge());
        jsonPerson.put("contact", jsonContact);
        jsonPerson.put("statuses", jsonStatuses);

        List<JSONObject> listContacts = new ArrayList<>();
        listContacts.add(new JSONObject("{\"phone\":\"22-222\"}"));
        listContacts.add(new JSONObject("{\"phone\":\"33-333\"}"));
        JSONArray jsonContacts = new JSONArray(listContacts);

        final Department department = new Department(true, 100, "Trade", person,
                new Contact[]{new Contact("22-222"), new Contact("33-333")});

        JSONObject jsonDepartment = new JSONObject();
        jsonDepartment.put("actual", department.getActual());
        jsonDepartment.put("level", department.getLevel());
        jsonDepartment.put("name", department.getName());
        jsonDepartment.put("supervisor", jsonPerson);
        jsonDepartment.put("contacts", jsonContacts);

        System.out.println(jsonDepartment.toString());

        System.out.println(new JSONObject(department).toString());
    }
}
