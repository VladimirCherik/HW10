package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Test {
    public static void main(String[] args) {

        Person person = new Person("Vovan", 23);
        Gson gson = new Gson();
        String json = gson.toJson(person);

        System.out.println(json);

        System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(person));
    }
}
