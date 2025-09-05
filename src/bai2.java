import java.io.*;
import java.util.*; 



public class bai2 {
    public static void main(String[] args) throws Exception {
       String filecon = "D\\taofile";
       String docfile = "D:\\taofile\\txt.txt";
       String fileloi = "D:\\taofile\\txt1.txt";
       List<String> dsloi = new ArrayList<>();

       try (FileInputStream file = new FileInputStream(docfile)) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(file))) {
                String line;

                
                line = br.readLine();

                while ((line = br.readLine()) != null) 
                {
                    String[] arr = line.split(",");

                    System.out.println("Số cột: " + arr.length);

                    if (arr.length < 5) {
                        System.out.println("Không đủ thông tin!");
                    } else {
                       nhanvien nv = new nhanvien(arr[0], arr[1].trim(), arr[2], arr[3], arr[4].trim());
                       String tentep = nv.getTenFolder();

    
                    if (tentep!= null){
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
                    }else{
                            dsloi.add(nv.getMaNV());
                        }
                    }

                    if(dsloi!= null)
                    {
                        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileloi))) {
                            for (String ma : dsloi) {
                                 writer.write(ma);
                                 writer.newLine();
                                }
                            System.out.println("Danh sach ko hop le: " + fileloi);
                        }
                    }   
                } 
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}
