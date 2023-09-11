package org.example;

import java.io.*;
import java.util.*;

public class HW10_3 {
    private static final String ABSOLUTE_PATH = "C:\\Users\\Admin\\IdeaProjects\\HW10\\src\\main\\resources\\HW10_3\\words.txt";

    public static void main(String[] args) {

        // Створення і запис файлу
        File file = new File(ABSOLUTE_PATH);
        ifFileExist(file);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))){
            bufferedWriter.write("the day is sunny the the\n" +
                    "the sunny is is");
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
        // Читання файлу
        String allLine = "";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            String line = bufferedReader.readLine();
            allLine = line;
            while (line != null){
                line = bufferedReader.readLine();
                if(line != null){
                    allLine += " " + line;
                    System.out.println(allLine);
                }
            }
        }catch (IOException e){
            System.err.println(e.getMessage());
        }

        //Створення ХешМапи для розрахунку кількості входження кожного слова в рядок
        String[] words = allLine.split(" ");
        HashMap<String, Integer> wordCountTable = new HashMap<>();

        for (String uniqueWord : words) {
            if (wordCountTable.containsKey(uniqueWord)) {
                wordCountTable.replace(uniqueWord, wordCountTable.get(uniqueWord),
                        wordCountTable.get(uniqueWord) + 1);
            } else {
                wordCountTable.put(uniqueWord, 1);
            }
        }
        Set<Map.Entry<String, Integer>> entries = wordCountTable.entrySet();
        for (Map.Entry<String, Integer> entry: entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
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
