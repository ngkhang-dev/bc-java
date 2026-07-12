import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLyXe {
    private List<ChuyenXe> dsChuyenXe = new ArrayList<ChuyenXe>();

    public QuanLyXe() {
        dsChuyenXe.add(new ChuyenXeNgoaiThanh(1, "Tai xe 01", 1_900_000, "12A1234", "Nha Trang", 300));
        dsChuyenXe.add(new ChuyenXeNgoaiThanh(2, "Tai xe 02", 1_900_000, "12A1234", "Nha Trang", 300));
        dsChuyenXe.add(new ChuyenXeNgoaiThanh(3, "Tai xe 03", 1_900_000, "12A1234", "Nha Trang", 300));
    }

    public void themChuyenXe(Scanner sc, int loaiXe) {
        ChuyenXe xe = loaiXe == 1 ? new ChuyenXeNoiThanh() : new ChuyenXeNgoaiThanh();

        xe.nhap();

        dsChuyenXe.add(xe);
    }

    public void xuatDanhSachChuyenXe() {
        if (dsChuyenXe.isEmpty()) {
            System.out.println("Danh sách xe trống");
            return;
        }

        dsChuyenXe.forEach(xe -> xe.xuat());
    }

    public void tongDoanhThu() {
        double tongDoanhThu = 0;

        for (ChuyenXe xe : dsChuyenXe) {
            tongDoanhThu += xe.getDoanhThu();
        }

        System.out.println("Tổng doanh thu: " + tongDoanhThu);
    }

    public void doanhThuTheoLoaiXe(int loaiXe) {
        double doanhThu = 0;

        for (ChuyenXe xe : dsChuyenXe) {

            if (loaiXe == 1) {
                if (xe instanceof ChuyenXeNoiThanh) {
                    doanhThu += xe.getDoanhThu();
                }
            } else {
                if (xe instanceof ChuyenXeNgoaiThanh) {
                    doanhThu += xe.getDoanhThu();
                }
            }
        }

        System.out.println("Tổng doanh thu của " + (loaiXe == 1 ? "nội thành" : "ngoại thành") + " là " + doanhThu);
    }
}
