package geometry;

import java.util.Scanner;

public class Square extends Rectangle {
    private final Scanner sc = new Scanner(System.in);
    private double side;

    public Square(String color, String name, double height, double weight, double side) {
        super(color, name, height, weight);
        this.side = side;
    }

    @Override
    public void enterInfo() {
        super.enterInfo();
        System.out.print("Enter side: ");
        side = Double.parseDouble(sc.nextLine());
    }

    @Override
    public void display() {
        super.display();
        System.out.printf("Side: %.2f, Perimeter: %.2f, Area: %.2f", side, perimeter(), area());
    }

    @Override
    protected double area() {
        return super.area();
    }

    @Override
    protected double perimeter() {
        return super.perimeter();
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }
}
