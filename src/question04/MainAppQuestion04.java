package question04;

public class MainAppQuestion04 {
    public static void main(String[] args) {
        Car car1 = new Car("Toyota", "Red", 2010, "V6", 4);
        Car car2 = new Car("BMW", "Black", 2015, "V8", 4);

        Motorbike motorbike1 = new Motorbike("Kawasaki", "Black", 2018, 175);
        Motorbike motorbike2 = new Motorbike("Honda", "Green", 2025, 110);

        System.out.printf("|%-20s|%-10s|%14s|%-14s|%8s|%10s|\n",
                "Hãng sản xuất", "Màu sắc", "Năm sản xuất", "Loại động cơ", "Số ghế", "Dung tích");

        car1.printInfo();
        car2.printInfo();
        motorbike1.printInfo();
        motorbike2.printInfo();

        car1.getSpeed();
        motorbike1.getSpeed();

        car1.getTypeDriveLicence();
        motorbike1.getTypeDriveLicence();

        car1.openTrunk();
        car1.registration();

        motorbike1.getRestriction();
    }
}
