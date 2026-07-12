import java.util.Scanner;

public class ChuyenXeNgoaiThanh extends ChuyenXe {
    private Scanner sc = new Scanner(System.in);

    private String noiDen;
    private int soNgay;

    public ChuyenXeNgoaiThanh() {
    }

    public ChuyenXeNgoaiThanh(int maXe, String tenTaiXe, double doanhThu, String soXe, String noiDen, int soNgay) {
        super(maXe, tenTaiXe, doanhThu, soXe);

        this.noiDen = noiDen;
        this.soNgay = soNgay;
    }

    @Override
    public void nhap() {
        super.nhap();

        System.out.print("Nhập nơi đến: ");
        noiDen = sc.nextLine();

        System.out.print("Nhập số ngày đi: ");
        soNgay = Integer.parseInt(sc.nextLine());
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.printf("|%-15s|%-10d|\n", noiDen, soNgay);
    }

    @Override
    public String toString() {
        return "ChuyenXeNgoaiThanh{" +
                "maXe=" + maXe +
                ", tenTaiXe='" + tenTaiXe + '\'' +
                ", doanhThu='" + doanhThu + '\'' +
                ", soXe='" + soXe + '\'' +
                ", noiDen='" + noiDen + '\'' +
                ", soNgay=" + soNgay +
                '}';
    }

    public String getNoiDen() {
        return noiDen;
    }

    public void setNoiDen(String noiDen) {
        this.noiDen = noiDen;
    }

    public int getSoNgay() {
        return soNgay;
    }

    public void setSoNgay(int soNgay) {
        this.soNgay = soNgay;
    }
}
