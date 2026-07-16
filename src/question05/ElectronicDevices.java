package question05;

public abstract class ElectronicDevices {
    protected String brand;
    protected String name;
    protected int power;

    public ElectronicDevices() {
    }

    public ElectronicDevices(String brand, String name, int power) {
        this.brand = brand;
        this.name = name;
        this.power = power;
    }

    public void printInfo() {
        System.out.printf("|%-20s|%-15s|%9d", brand, name, power);
    }

    public abstract String getType();
}
