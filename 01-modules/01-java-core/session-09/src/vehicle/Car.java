package vehicle;

import java.util.Scanner;

public class Car extends Vehicle implements Runnable {
    private final Scanner sc = new Scanner(System.in);

    protected int seat;
    protected String engine;

    public Car(String id, String name, double price, int seat, String engine) {
        super(id, name, price);
        this.seat = seat;
        this.engine = engine;
    }

    @Override
    public void enterInfo() {
        super.enterInfo();

        System.out.print("Enter seat: ");
        seat = Integer.parseInt(sc.nextLine());
        System.out.print("Enter engine: ");
        engine = sc.nextLine();
    }

    @Override
    public void showInfo() {
        System.out.printf("|%-10s|%-20s|%.2f|%2d|-20s|\n", id, name, price, seat, engine);
    }

    @Override
    public double calculatePrice() {
        return price * 1.2;
    }

    @Override
    public void run() {
        System.out.println("Car is driving...");
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }
}
