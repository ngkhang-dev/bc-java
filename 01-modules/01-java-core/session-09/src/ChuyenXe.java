import java.util.Scanner;

public class ChuyenXe {
    private Scanner sc = new Scanner(System.in);

    protected int maXe;
    protected String tenTaiXe;
    protected double doanhThu;
    protected String soXe;

    public ChuyenXe() {
    }

    public ChuyenXe(int maXe, String tenTaiXe, double doanhThu, String soXe) {
        this.maXe = maXe;
        this.tenTaiXe = tenTaiXe;
        this.doanhThu = doanhThu;
        this.soXe = soXe;
    }

    public void nhap() {
        System.out.print("Nhập mã xe: ");
        maXe = Integer.parseInt(sc.nextLine());

        System.out.print("Nhập tên tài xế: ");
        tenTaiXe = sc.nextLine();

        System.out.print("Nhập doanh thu: ");
        doanhThu = Double.parseDouble(sc.nextLine());

        System.out.print("Nhập mã xe: ");
        soXe = sc.nextLine();
    }

    public void xuat() {
        System.out.printf("|%-10s|%-20s|%-10.2f|%-15s|", maXe, tenTaiXe, doanhThu, soXe);
    }

    @Override
    public String toString() {
        return "ChuyenXe{" + "maXe=" + maXe + ", tenTaiXe='" + tenTaiXe + '\'' + ", doanhThu='" + doanhThu + '\'' + ", soXe='" + soXe + '\'' + '}';
    }

    public int getMaXe() {
        return maXe;
    }

    public void setMaXe(int maXe) {
        this.maXe = maXe;
    }

    public String getTenTaiXe() {
        return tenTaiXe;
    }

    public void setTenTaiXe(String tenTaiXe) {
        this.tenTaiXe = tenTaiXe;
    }

    public double getDoanhThu() {
        return doanhThu;
    }

    public void setDoanhThu(double doanhThu) {
        this.doanhThu = doanhThu;
    }

    public String getSoXe() {
        return soXe;
    }

    public void setSoXe(String soXe) {
        this.soXe = soXe;
    }
}
