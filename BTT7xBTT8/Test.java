package BTT7xBTT8;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sach s1 = new Sach("S01", "Lap trinh Java can ban", "Nguyen Van A", 2023, 10);
        Sach s2 = new Sach("S02", "Cau truc du lieu & Giai thuat", "Tran Van B", 2022, 5);
        Sach s3 = new Sach("S03", "Co so du lieu", "Le Van C", 2021, 8);
        System.out.println(" 1. THEM SACH VAO DANH SACH ");
        Sach.themSach(s1);
        Sach.themSach(s2);
        Sach.themSach(s3);
        System.out.println("\n 2. HIEN THI TOAN BO DANH SACH ");
        Sach.hienThiDanhSach();
        System.out.println("\n 3. TIM KIEM SACH THEO MA ");
        String maTimKiem = sc.nextLine();
        System.out.println("Dang tim kiem ma sach: " + maTimKiem);
        Sach timThay = Sach.timKiemTheoMa(maTimKiem);
        if (timThay != null) {
            System.out.println("Ket qua tim kiem:");
            timThay.hienThiThongTin();
        } else {
            System.out.println("Khong tim thay sach voi ma: " + maTimKiem);
        }
        System.out.println("Nhap ma can xoa: ");
        String xoaSach = sc.nextLine();
        System.out.println("\n 4. XOA SACH KHOI DANH SACH ");
        Sach.xoaSach(xoaSach);

        System.out.println("\n 5. DANH SACH SAU KHI XOA ");
        Sach.hienThiDanhSach();
    }
}
