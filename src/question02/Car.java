package question02;

public class Car {
    private String brand;
    private String color;
    private int productionYear;

    public Car() {
    }

    public Car(String brand, String color, int productionYear) {
        this.brand = brand;
        this.color = color;
        this.productionYear = productionYear;
    }

    public void inThongTin() {
        System.out.printf("|Hãng: %-15s | Màu sắc: %-10s | Năm sản xuất: %4d|\n", brand, color, productionYear);
    }

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
