import java.util.Scanner;

public class ChuyenXeNoiThanh extends ChuyenXe {
    private Scanner sc = new Scanner(System.in);

    private int soTuyen;
    private double soKm;

    public ChuyenXeNoiThanh() {
    }

    public ChuyenXeNoiThanh(int maXe, String tenTaiXe, double doanhThu, String soXe, int soTuyen, double soKm) {
        super(maXe, tenTaiXe, doanhThu, soXe);

        this.soTuyen = soTuyen;
        this.soKm = soKm;
    }

    @Override
    public void nhap() {
        super.nhap();

        System.out.print("Nhập số tuyến: ");
        soTuyen = Integer.parseInt(sc.nextLine());

        System.out.print("Nhập số km: ");
        soKm = Integer.parseInt(sc.nextLine());
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.printf("%-15s|%-10d|\n", soTuyen, soKm);
    }

    @Override
    public String toString() {
        return "ChuyenXeNoiThanh{" +
                "maXe=" + maXe +
                ", tenTaiXe='" + tenTaiXe + '\'' +
                ", doanhThu='" + doanhThu + '\'' +
                ", soXe='" + soXe + '\'' +
                ", soTuyen=" + soTuyen +
                ", soKm=" + soKm +
                '}';
    }

    public int getSoTuyen() {
        return soTuyen;
    }

    public void setSoTuyen(int soTuyen) {
        this.soTuyen = soTuyen;
    }

    public double getSoKm() {
        return soKm;
    }

    public void setSoKm(double soKm) {
        this.soKm = soKm;
    }
}
