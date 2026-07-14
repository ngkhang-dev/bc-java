package demoOverloading;

public class MainDemoOverLoading {
    public static void main(String[] args) {
        NguoiDung a = new NguoiDung();
        a.login();

        NguoiQuanTri b = new NguoiQuanTri();
        b.login();

        NguoiDung c = new NguoiQuanTri();
        c.login();
    }
}
