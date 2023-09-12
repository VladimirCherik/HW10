package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {

        Person person = new Person("Vovan", 23);
        Gson gson = new Gson();
        String json = gson.toJson(person);

        System.out.println(json);

        System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(person));




        String s = "the day is sunny 22 the the\n" +
                "the sunny is 98 is";
        Pattern pt = Pattern.compile("\\d\\d");
        Matcher mt = pt.matcher(s);
        String group = "";
        while (mt.find()){
            group += mt.group() + " ";
        }
        System.out.println(group);
    }
}
