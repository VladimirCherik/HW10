package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HW10_2 {
    private static final String ABSOLUTE_PATH = "C:\\Users\\Admin\\IdeaProjects\\HW10\\src\\main\\resources\\HW10_2\\firstFile.txt";
    private static final String ABSOLUTE_PATH_TO_GSON = "C:\\Users\\Admin\\IdeaProjects\\HW10\\src\\main\\resources\\HW10_2\\user.json";

    public static void main(String[] args) {
        File file = new File(ABSOLUTE_PATH);
        ifFileExist(file);

        //Створити файл з умовою завдання
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file,false))){
            bufferedWriter.write("name age\n");
            bufferedWriter.write("alice 21\n");
            bufferedWriter.write("ryan 30\n");
            bufferedWriter.write("max 30\n");
            bufferedWriter.write("andy 30\n");
        }catch (IOException e){
            System.err.println(e.getMessage());
        }

        // Читати інфу з файлу і створити gson
        List arrayList = new ArrayList();
        List listObject = new LinkedList();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            String line = bufferedReader.readLine();
            while (line != null){
                arrayList.add(line);
                line = bufferedReader.readLine();
            }
            for (int i = 1; i < arrayList.size(); i++){
                String[] nameAndAge = arrayList.get(i).toString().split(" ");
                String json = new Gson().toJson(new Person(nameAndAge[0], Integer.parseInt(nameAndAge[1])));
                listObject.add(json);

            }
        }catch (IOException e){
            System.err.print(e.getMessage());
        }

        //Записати в новий файл масив gson-ів
        File fileToWrite = new File(ABSOLUTE_PATH_TO_GSON);
        ifFileExist(file);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileToWrite))){
            bufferedWriter.write(listObject.toString());
        }catch (IOException e){
            System.err.print(e.getMessage());
        }
        // зчитування і вивід у консоль
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileToWrite))){
            String s = bufferedReader.readLine();
            System.out.println(s);
        }catch (IOException e){
            System.err.print(e.getMessage());
        }
    }
    static void ifFileExist(File file){
        if(!file.exists()){
            file.getParentFile().mkdirs();
            try {
                file.createNewFile();
            }catch (IOException e){
                System.err.println(e.getMessage());
            }
        }
    }
}
