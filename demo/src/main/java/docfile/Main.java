package docfile;

import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.File;
import java.io.FilterInputStream;

public class Main {
    public static void main(String[] args) {
        try (FileInputStream file = new FileInputStream("D:\\taofile\\txt.txt")){
            try ( BufferedReader br = new BufferedReader(new InputStreamReader(file)))
            {
                String line;
                while ((line = br.readLine()) != null){
                    
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}