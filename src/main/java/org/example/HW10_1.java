package org.example;

import java.io.*;

public class HW10_1 {
    private static final String ABSOLUTE_PATH = "C:\\Users\\Admin\\IdeaProjects\\HW10\\src\\main\\resources\\HW10_1\\firstFile.txt";

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
            String line = bufferedReader.readLine();
            while (line != null){
                if(line.contains(")") && line.contains("(") || line.contains("-")){
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
