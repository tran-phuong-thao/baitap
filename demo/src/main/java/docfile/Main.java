package docfile;

import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        try (FileInputStream file = new FileInputStream("D:\\taofile\\txt.txt")) {
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

                        System.out.println(tentep);
                        tentep = tentep.replaceAll("[\\\\/:*?\"<>|]", "");
                        File rootFolder = new File("D:\\taofile\\" + tentep);

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