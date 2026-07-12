package vehicle;

import java.util.Scanner;

public class Ship extends Vehicle {
    private final Scanner sc = new Scanner(System.in);

    private double weight;
    private int container;

    public Ship(String id, String name, double price, double weight, int container) {
        super(id, name, price);
        this.weight = weight;
        this.container = container;
    }

    @Override
    public void enterInfo() {
        super.enterInfo();

        System.out.println("Enter weight: ");
        weight = Double.parseDouble(sc.nextLine());
        System.out.println("Enter container: ");
        container = Integer.parseInt(sc.nextLine());
    }

    @Override
    public void showInfo() {
        System.out.printf("|%-10s|%-20s|%.2f|%4.2f|%-4d|\n",
                id, name, price, weight, container);
    }

    @Override
    public double calculatePrice() {
        return 0;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getContainer() {
        return container;
    }

    public void setContainer(int container) {
        this.container = container;
    }
}
