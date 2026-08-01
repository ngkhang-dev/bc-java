package question05;

import java.util.Arrays;
import java.util.List;

public class MainAppQuestion05 {
    public static void main(String[] args) {
        System.out.printf("|%-20s|%-15s|%9s|%-15s|%-4s|%-18s|%-18s|\n", "Tên hãng", "Tên thiết bị", "Công suất", "Chức năng", "Db", "Diện tích làm mát", "Nhiệt độ tối đa");

        AirConditioner airConditioner1 = new AirConditioner("Panasonic", "Supper Cool V2", 1, 20, 60);
        AirConditioner airConditioner2 = new AirConditioner("Sharp", "SH2026", 2, 30, 75);

        HairDryer hairDryer1 = new HairDryer("Dyson", "Supersonic", 1000, 70);
        HairDryer hairDryer2 = new HairDryer("NoName", "MST2026", 1200, 60);

        List<ElectronicDevices> listDevices = Arrays.asList(airConditioner1, airConditioner2, hairDryer1, hairDryer2);

        for (ElectronicDevices device : listDevices) {
            device.printInfo();
        }

        airConditioner1.getFanSpeed();
        hairDryer1.getMode();
    }
}
