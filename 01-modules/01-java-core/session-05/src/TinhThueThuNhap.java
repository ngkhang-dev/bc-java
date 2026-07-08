/*
    Session 05 - Practice: Dynamic array (List) and Functions
 */

import java.util.Scanner;

public class TinhThueThuNhap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // INPUT
        System.out.print("Nhập họ tên: ");
        String hoTen = sc.nextLine();

        System.out.print("Nhập tổng thu nhập năm (triệu): ");
        double thuNhapNam = Double.parseDouble(sc.nextLine());

        System.out.print("Nhập số người phụ thuộc: ");
        int soNguoiPhuThuoc = Integer.parseInt(sc.nextLine());

        // PROCESS :
        double thuNhapChiuThue = ThuNhapChiuThue(thuNhapNam, soNguoiPhuThuoc);
        int thueSuat = TinhThueSuat(thuNhapChiuThue);
        double thue = thuNhapChiuThue * thueSuat / 100;

        // OUTPUT
        System.out.println("Thu nhập năm : " + thuNhapNam);
        System.out.println("Thu nhập chịu thuế  : " + thuNhapChiuThue);
        System.out.println("Thuế suất  : " + thueSuat);
        System.out.printf("\nSố thuế %s phải đóng là : %.2f", hoTen, thue);
    }

    static double ThuNhapChiuThue(double thuNhap, int soPhuThuoc) {
        return thuNhap - 4000 - soPhuThuoc * 1600;
    }

    static int TinhThueSuat(double thuNhap) {
        if (thuNhap > 0 && thuNhap <= 60000) return 5;
        else if (thuNhap <= 120) return 10;
        else if (thuNhap <= 210) return 15;
        else if (thuNhap <= 384) return 20;
        else if (thuNhap <= 624) return 25;
        else if (thuNhap <= 960) return 30;
        else return 35;
    }
}
