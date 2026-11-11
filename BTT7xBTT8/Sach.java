package BTT7xBTT8;

import java.util.ArrayList;

public class Sach {
    public String maSach;
    public String tieuDe;
    public String tacGia;
    public int namXuatBan;
    public int soLuong;

    public static ArrayList<Sach> danhSachSach = new ArrayList<>();

    public Sach() {
    }

    public Sach(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong) {
        this.maSach = maSach;
        this.tieuDe = tieuDe;
        this.tacGia = tacGia;
        this.namXuatBan = namXuatBan;
        this.soLuong = soLuong;
    }

    public void hienThiThongTin() {
        System.out.println("Ma sach la: " + maSach);
        System.out.println("Ten sach la: " + tieuDe);
        System.out.println("Tac gia: " + tacGia);
        System.out.println("Nam xuat ban: " + namXuatBan);
        System.out.println("So luong: " + soLuong);
    }

    public static void themSach(Sach s) {
        danhSachSach.add(s);
        System.out.println("-> Da them sach: " + s.tieuDe);
    }

    public static void hienThiDanhSach() {
        if (danhSachSach.isEmpty()) {
            System.out.println("Danh sach sach hien dang trong!");
            return;
        }
        System.out.println("\n===== DANH SACH CAC CUON SACH (" + danhSachSach.size() + " cuon) =====");
        for (int i = 0; i < danhSachSach.size(); i++) {
            System.out.println("\n[Cuon thu " + (i + 1) + "]");
            danhSachSach.get(i).hienThiThongTin();
        }
    }

    public static Sach timKiemTheoMa(String maCanTim) {
        for (Sach s : danhSachSach) {
            if (s.maSach.equalsIgnoreCase(maCanTim)) {
                return s;
            }
        }
        return null;
    }

    public static boolean xoaSach(String maCanXoa) {
        Sach s = timKiemTheoMa(maCanXoa);
        if (s != null) {
            danhSachSach.remove(s);
            System.out.println("-> Da xoa sach co ma: " + maCanXoa);
            return true;
        } else {
            System.out.println("-> Khong tim thay ma sach \"" + maCanXoa + "\" de xoa!");
            return false;
        }
    }

    public static boolean xoaSach(Sach s) {
        if (s != null && danhSachSach.remove(s)) {
            System.out.println("-> Da xoa sach: " + s.tieuDe);
            return true;
        } else {
            System.out.println("-> Khong the xoa sach (doi tuong khong hop le hoac khong ton tai)!");
            return false;
        }
    }
}
