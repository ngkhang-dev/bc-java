package vehicle;

import java.util.Scanner;

public abstract class Vehicle {
    private final Scanner sc = new Scanner(System.in);

    protected String id;
    protected String name;
    protected double price;

    public Vehicle(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public void enterInfo() {
        System.out.print("ID: ");
        id = sc.nextLine();
        System.out.print("Name: ");
        name = sc.nextLine();
        System.out.print("Price: ");
        price = Double.parseDouble(sc.nextLine());
    }

    public void showInfo() {
        System.out.printf("|%-10s|%-20s|%.2f|\n", id, name , price);
    }

    public abstract double calculatePrice();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
