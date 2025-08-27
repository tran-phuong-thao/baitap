package docfile;

import java.io.*;

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

                        File rootFolder = new File("D:\\taofile\\" + tentep);

                        if (!rootFolder.exists()) {
                            boolean created = rootFolder.mkdirs(); 
                            if (created) {
                                 rootFolder.getAbsolutePath();
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
