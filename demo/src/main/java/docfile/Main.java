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
                    System.out.println("so cot:" + arr.length);
                    if (arr.length<5){
                         System.out.println("ko du thong tin");
                        }
                    else {
                        String ten = arr[1].trim();
                        String mavn = arr[4].trim();
                        System.out.println(ten +" "+ mavn);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}