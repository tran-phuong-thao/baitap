public class nhanvien {
   private String id;
   private String ten;
   private String tuoi;
   private String gioitinh;
   private String maNV;

    public nhanvien (String id, String ten, String tuoi, String gioitinh, String maNV) {
        this.id = id;
        this.ten = ten;
        this.tuoi = tuoi;
        this.gioitinh = gioitinh;
        this.maNV = maNV;
    }

     public String getTenFolder() {
        if (maNV == null || maNV.length() != 8) {
            return null;
        }

        String prefix = maNV.substring(0, 2);
        String digits = maNV.substring(2);

        switch (prefix) {
            case "SN":
                if (digits.matches("\\d{6}")) {
                    return ten.replace(" ", "_") + "_" + digits.substring(0, 3) + "000";
                }
                break;
            case "NS":
                if (digits.matches("\\d{6}")) {
                    return ten.replace(" ", "_") + "_" + digits.substring(3) + "000";
                }
                break;
            default:
                return null;
        }

        return null;
    }

   public String getMaNV(){
    return maNV;
   }
    
}
