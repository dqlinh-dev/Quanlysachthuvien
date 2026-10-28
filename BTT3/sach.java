import java.util.Scanner;

public class sach {
    private String masach, tensach, tacgia;
    private int nxb, slg, loaiSach, slgconlai;
    private double gia;

    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma sach: ");
        masach = sc.nextLine();
        System.out.print("Nhap ten sach: ");
        tensach = sc.nextLine();
        System.out.print("Nhap ten tac gia: ");
        tacgia = sc.nextLine();
        System.out.print("Nhap nam xuat ban: ");
        nxb = sc.nextInt();
        System.out.print("So luong: ");
        slg = sc.nextInt();
        System.out.print("Gia: ");
        gia = sc.nextDouble();
        System.out.print("So luong con lai: ");
        slgconlai = sc.nextInt();
        System.out
                .println("Loai 1.Sach giao khoa\n Loai 2.Sach tham khao\n Loai 3.Sach chuyen nganh\nLoai 4.Sach khac");
        System.out.print("Loai sach: ");
        loaiSach = sc.nextInt();
        sc.close();
    }

    public double Thanhtien() {
        return gia * slg;
    }

    public double Phivanchuyen() {
        return Thanhtien() * 0.05;
    }

    public double Tgtien() {
        return Thanhtien() + Phivanchuyen();
    }

    public boolean KiemTraHopLe() {
        return (gia > 0) && (slg >= 0) && (nxb > 0 && nxb <= 2026);
    }

    public String PhanLoaiGia() {
        if (gia < 50000) {
            return "Sach gia thap";
        } else if (gia <= 100000) {
            return "Sach gia trung binh";
        } else if (gia <= 200000) {
            return "Sach gia cao";
        } else {
            return "Sach gia dac biet";
        }
    }

    public String PhanLoaiTonKho() {
        if (slgconlai == 0) {
            return "Het sach";
        } else if (slgconlai <= 5) {
            return "Sap het";
        } else if (slgconlai <= 20) {
            return "Con it";
        } else {
            return "Con nhieu";
        }
    }

    public String LayLoaiSach() {
        switch (loaiSach) {
            case 1:
                return "Sach giao khoa";
            case 2:
                return "Sach tham khao";
            case 3:
                return "Sach chuyen nganh";
            case 4:
                return "Sach khac";
            default:
                return "Loai sach khong xac dinh";
        }
    }

    public void Xuat() {
        System.out.println("============================");
        System.out.println("THONG TIN SACH");
        System.out.println("============================");
        System.out.println("Ma sach: " + masach);
        System.out.println("Ten sach: " + tensach);
        System.out.println("Tac gia: " + tacgia);
        System.out.println("Nam xuat ban: " + nxb);
        System.out.println("So luong: " + slg);
        System.out.println("Gia: " + gia);
        System.out.println("So luong con lai: " + slgconlai);
        System.out.println("Thanh tien: " + Thanhtien());
        System.out.println("Phi van chuyen: " + Phivanchuyen());
        System.out.println("Tong tien: " + Tgtien());
        System.out.println("Phan loai gia: " + PhanLoaiGia());
        System.out.println("Ton kho: " + PhanLoaiTonKho());
        System.out.println("Loai sach: " + LayLoaiSach());
    }

    public static void main(String[] args) {
        sach s = new sach();
        s.Nhap();
        if (s.KiemTraHopLe()) {
            s.Xuat();

        } else
            System.out.println("Du lieu khong hop le");

    }
}
