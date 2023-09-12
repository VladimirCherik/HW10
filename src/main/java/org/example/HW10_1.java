package org.example;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HW10_1 {
    private static final String ABSOLUTE_PATH = "C:\\Users\\Admin\\IdeaProjects\\HW10\\src\\main\\resources\\HW10_1\\firstFile.txt";
    private static final String rightTypeNumber = "((\\(\\d{3}\\))\\s|(\\d{3}\\-))(\\d{3}\\-\\d{4})";

    public static void main(String[] args)  {



        File file = new File(ABSOLUTE_PATH);
        ifFileExist(file);

        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))){
            bufferedWriter.write("987-123-4567\n");
            bufferedWriter.write("123 456 7890\n");
            bufferedWriter.write("(123) 456-7890\n");

        }catch (IOException e){
            System.err.println(e.getMessage());
        }

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){

            Pattern pt1 = Pattern.compile(rightTypeNumber);
            String line = bufferedReader.readLine();


            while (line != null){
                Matcher mt = pt1.matcher(line);
                while (mt.find()){
                    System.out.println(line);
                }
                line = bufferedReader.readLine();
            }
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
