package question04;

public abstract class Vehicle {
    protected String brand;
    protected String color;
    protected int productionYear;

    public Vehicle() {
    }

    public Vehicle(String brand, String color, int productionYear) {
        this.brand = brand;
        this.color = color;
        this.productionYear = productionYear;
    }

    public void printInfo() {
        System.out.printf("|%-20s|%-10s|%14s", brand, color, productionYear);
    }

    public abstract void getSpeed();

    public abstract void getTypeDriveLicence();

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }
}
