package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class DepartmentUtilization {
    public static void main(String[] args) {
        final Department department = new Department(true, 80, "Developers",
                new Person(false, 30, new Contact("11-111"), new String[]{"Worker", "Married"}),
                new Contact[]{new Contact("22-222"), new Contact("33-333")});

        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(department));

        final String departmentJson =
                "{"
                        + "\"actual\":true,"
                        + "\"level\":90,"
                        + "\"name\":\"Analytics\","
                        + "\"supervisor\":"
                        + "{"
                        + "\"sex\":true,"
                        + "\"age\":32,"
                        + "\"contact\":"
                        + "{"
                        + "\"phone\":\"11-777\""
                        + "},"
                        + "\"statuses\":"
                        + "[\"Reader\",\"Vacant\"]"
                        + "},"
                        + "\"contacts\":"
                        + "["
                        + "{"
                        + "\"phone\":\"25-225\""
                        + "},"
                        + "{"
                        + "\"phone\":\"35-335\""
                        + "}"
                        + "]"
                        + "}";
        final Department departmentMod = gson.fromJson(departmentJson, Department.class);
        System.out.println(departmentMod);
    }
}
