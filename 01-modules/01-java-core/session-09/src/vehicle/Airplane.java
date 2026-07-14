package vehicle;

import java.util.Scanner;

public class Airplane extends Vehicle implements Runnable, Flyable {
    private final Scanner sc = new Scanner(System.in);

    private double flightHeight;
    private int passenger;

    public Airplane(String id, String name, double price, double heigth, int passenger) {
        super(id, name, price);
        this.flightHeight = heigth;
        this.passenger = passenger;
    }

    @Override
    public void enterInfo() {
        super.enterInfo();

        System.out.print("Enter flight height: ");
        flightHeight = Double.parseDouble(sc.nextLine());
        System.out.print("Enter passenger: ");
        passenger = Integer.parseInt(sc.nextLine());
    }

    @Override
    public void showInfo() {
        System.out.printf("|%-10s|%-20s|%.2f|%3.2f|%-3d|\n", id, name, price, flightHeight, passenger);
    }

    @Override
    public double calculatePrice() {
        return price * 1.1;
    }

    @Override
    public void run() {
        System.out.println("Airplane is flying...");
    }

    @Override
    public void fly() {
        System.out.println("Airplane is flying...");
    }

    public double getHeigth() {
        return flightHeight;
    }

    public void setHeigth(double heigth) {
        this.flightHeight = heigth;
    }

    public int getPassenger() {
        return passenger;
    }

    public void setPassenger(int passenger) {
        this.passenger = passenger;
    }
}
