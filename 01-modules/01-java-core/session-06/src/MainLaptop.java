import java.util.ArrayList;
import java.util.List;

public class MainLaptop {
    public static void main(String[] args) {
        System.out.println("The management system of laptop");

        List<Laptop> laptops = new ArrayList<>();

        // Khởi tạo với constructor rỗng
        Laptop laptop1 = new Laptop();
        laptop1.name = "Dev 1";
        laptop1.brand = "Dell";
        laptop1.ram = 32;
        laptop1.cpu = "i5";
        laptop1.price = 40_000_000;

        // Khởi tạo với constructor có tham số
        Laptop laptop2 = new Laptop("HR", "HP", 16, "i5", 25_000_000);

        laptops.add(laptop1);
        laptops.add(laptop2);

        // Thêm trực tiếp object vào danh sách
        laptops.add(new Laptop("Dev 2", "Think pad", 32, "i7", 50_000_000));

        for (Laptop laptop : laptops) {
            laptop.printInfo();
        }
    }
}
