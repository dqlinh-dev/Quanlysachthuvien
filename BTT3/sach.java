import java.util.Scanner;

public class sach {
    private String masach, tensach, tacgia;
    private int nxb, slg;
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
        sc.close();
    }

    public void Xuat() {
        System.out.println("Ma sach: " + masach);
        System.out.println("Ten sach: " + tensach);
        System.out.println("Tac gia: " + tacgia);
        System.out.println("Nam xuat ban: " + nxb);
        System.out.println("So luong: " + slg);
        System.out.println("Gia: " + gia);

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

    public static void main(String[] args) {
        sach s = new sach();
        s.Nhap();
        s.Xuat();
        System.out.println("Thanh tien: " + s.Thanhtien());
        System.out.println("Phi van chuyen: " + s.Phivanchuyen());
        System.out.println("Tong tien: " + s.Tgtien());

    }

}
