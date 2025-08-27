package docfile;

import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        String filecha = "D:\\taofile\\txt.txt";
        String filecon = "D\\taofile";
        try (FileInputStream file = new FileInputStream(filecha)) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(file))) {
                String line;

                
                line = br.readLine();

                while ((line = br.readLine()) != null) {
                    String[] arr = line.split(",");

                    System.out.println("Số cột: " + arr.length);

                    if (arr.length < 5) {
                        System.out.println("Không đủ thông tin!");
                    } else {
                        String ten = arr[1].trim();
                        String maNV = arr[4].trim();
                        String tentep = ten + "_" + maNV;

                        tentep = tentep.replaceAll("[\\\\/:*?\"<>|]", "");
                        System.out.println(tentep);
                        File rootFolder = new File(filecon + tentep);

                        if (!rootFolder.exists()) {
                            boolean created = rootFolder.mkdirs(); 
                            if (created) {
                                 System.out.println("Tao thanh cong: " +rootFolder.getAbsolutePath());
                            } else {
                                System.out.println("loi ko tao duoc");
                            }
                        } else {
                            System.out.println(" Thư mục đã tồn tại.");
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}