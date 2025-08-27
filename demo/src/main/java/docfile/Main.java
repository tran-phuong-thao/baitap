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
                line = br.readLine();
                while ((line = br.readLine()) != null){
                    String[] arr = line.split(",");
                    if (arr.length<7){
                         System.out.println("ko du thong tin");
                        }
                    else {
                        String ten = arr[2].trim();
                        String mavn = arr[6].trim();
                        System.out.println(ten + mavn);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}