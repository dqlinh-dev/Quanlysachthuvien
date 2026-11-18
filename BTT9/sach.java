package BTT9;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class sach {
    private String maSach;
    private Date ngNhap;
    private double donGia;
    private int soLuong;
    private String nhaXuatBan;

    public sach() {
    }

    public sach(String maSach, Date ngNhap, double donGia, int soLuong, String nhaXuatBan) {
        setMaSach(maSach);
        setNgNhap(ngNhap);
        setDonGia(donGia);
        setSoLuong(soLuong);
        setNhaXuatBan(nhaXuatBan);
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public Date getNgNhap() {
        return ngNhap;
    }

    public void setNgNhap(Date ngNhap) {
        this.ngNhap = ngNhap;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        if (donGia >= 0) {
            this.donGia = donGia;
        } else {
            System.out.println("Don gia phai lon hon hoac bang 0");
            this.donGia = 0;
        }
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        if (soLuong >= 0) {
            this.soLuong = soLuong;
        } else {
            System.out.println("So luong phai lon hon hoac bang 0");
            this.soLuong = 0;
        }
    }

    public String getNhaXuatBan() {
        return nhaXuatBan;
    }

    public void setNhaXuatBan(String nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }

    public void nhap(Scanner sc) {
        System.out.print("Nhap ma sach: ");
        setMaSach(sc.nextLine());

        System.out.print("Nhap ngay nhap: ");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date d = sdf.parse(sc.nextLine());
            setNgNhap(d);
        } catch (Exception e) {
            System.out.println("Ngay khong hop le");
            setNgNhap(new Date());
        }

        System.out.print("Nhap don gia: ");
        setDonGia(Double.parseDouble(sc.nextLine()));

        System.out.print("Nhap so luong: ");
        setSoLuong(Integer.parseInt(sc.nextLine()));

        System.out.print("Nhap nha xuat ban: ");
        setNhaXuatBan(sc.nextLine());
    }

    public double tinhThanhTien() {
        return soLuong * donGia;
    }

    public void xuat() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String strNgay = (ngNhap != null) ? sdf.format(ngNhap) : "Chua ro";

        System.out.println("Ma sach: " + maSach);
        System.out.println("Ngay nhap: " + strNgay);
        System.out.println("Don gia: " + donGia);
        System.out.println("So luong: " + soLuong);
        System.out.println("Nha xuat ban: " + nhaXuatBan);
    }

}

class SachGiaoKhoa extends sach {
    private String tinhTrang;

    public SachGiaoKhoa() {
        super();
    }

    public SachGiaoKhoa(String maSach, Date ngNhap, double donGia, int soLuong, String nhaXuatBan, String tinhTrang) {
        super(maSach, ngNhap, donGia, soLuong, nhaXuatBan);
        this.tinhTrang = tinhTrang;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    @Override
    public void nhap(Scanner sc) {
        super.nhap(sc);
        System.out.print("Nhap tinh trang: ");
        this.tinhTrang = sc.nextLine();
    }

    @Override
    public double tinhThanhTien() {
        if (tinhTrang != null && tinhTrang.equalsIgnoreCase("moi")) {
            return getSoLuong() * getDonGia();
        } else {
            return getSoLuong() * getDonGia() * 0.5;
        }
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.println("Tinh trang: " + tinhTrang);
        System.out.println("Thanh tien: " + tinhThanhTien());
    }
}

class SachThamKhao extends sach {
    private double thue;

    public SachThamKhao() {
        super();
    }

    public SachThamKhao(String maSach, Date ngNhap, double donGia, int soLuong, String nhaXuatBan, double thue) {
        super(maSach, ngNhap, donGia, soLuong, nhaXuatBan);
        this.thue = thue;
    }

    public double getThue() {
        return thue;
    }

    public void setThue(double thue) {
        this.thue = thue;
    }

    @Override
    public void nhap(Scanner sc) {
        super.nhap(sc);
        System.out.print("Nhap thue: ");
        this.thue = Double.parseDouble(sc.nextLine());
    }

    @Override
    public double tinhThanhTien() {
        return (getSoLuong() * getDonGia()) + thue;
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.println("Thue: " + thue);
        System.out.println("Thanh tien: " + tinhThanhTien());
    }
}

class quanLy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<sach> danhSach = new ArrayList<>();

        System.out.print("Nhap so luong sach: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 1; i <= n; i++) {
            System.out.println("\nNhap cuon sach thu " + i + ":");
            System.out.println("1. Sach giao khoa");
            System.out.println("2. Sach tham khao");
            System.out.print("Chon loai sach: ");
            int chon = Integer.parseInt(sc.nextLine());

            if (chon == 1) {
                SachGiaoKhoa sgk = new SachGiaoKhoa();
                sgk.nhap(sc);
                danhSach.add(sgk);
            } else {
                SachThamKhao stk = new SachThamKhao();
                stk.nhap(sc);
                danhSach.add(stk);
            }
        }

        System.out.println("\nDanh sach cac cuon sach:");
        for (int i = 1; i <= danhSach.size(); i++) {
            System.out.println("\nThong tin sach thu " + i + ":");
            danhSach.get(i - 1).xuat();
        }

        double tongTienSGK = 0;
        double tongTienSTK = 0;

        for (sach s : danhSach) {
            if (s instanceof SachGiaoKhoa) {
                tongTienSGK += s.tinhThanhTien();
            } else if (s instanceof SachThamKhao) {
                tongTienSTK += s.tinhThanhTien();
            }
        }

        System.out.println("\nTong thanh tien sach giao khoa: " + tongTienSGK);
        System.out.println("Tong thanh tien sach tham khao: " + tongTienSTK);

        double tongDonGiaSTK = 0;
        int demSTK = 0;

        for (sach s : danhSach) {
            if (s instanceof SachThamKhao) {
                tongDonGiaSTK += s.getDonGia();
                demSTK++;
            }
        }

        if (demSTK > 0) {
            double tbDonGia = tongDonGiaSTK / demSTK;
            System.out.println("\nTrung binh cong don gia sach tham khao: " + tbDonGia);
        } else {
            System.out.println("\nKhong co sach tham khao trong danh sach");
        }

        System.out.print("\nNhap nha xuat ban can tim: ");
        String nhaXuatBanX = sc.nextLine();

        boolean timThay = false;
        System.out.println("\nKet qua tim kiem sach giao khoa:");
        for (sach s : danhSach) {
            if (s instanceof SachGiaoKhoa && s.getNhaXuatBan().equalsIgnoreCase(nhaXuatBanX)) {
                System.out.println();
                s.xuat();
                timThay = true;
            }
        }

        if (!timThay) {
            System.out.println("Khong tim thay sach giao khoa cua nha xuat ban nay");
        }
    }
}
