package geometry;

import java.util.Scanner;

public class Circle extends Shape {
    private final Scanner sc = new Scanner(System.in);

    private double radius;

    public Circle(String color, String name, double radius) {
        super(color, name);
        this.radius = radius;
    }

    @Override
    public void enterInfo() {
        super.enterInfo();
        System.out.print("Enter radius: ");
        radius = Double.parseDouble(sc.nextLine());
    }

    @Override
    public void display() {
        super.display();
        System.out.printf("Radius: %.2f, Perimeter: %.2f, Area: %.2f", radius, perimeter(), area());
    }

    @Override
    protected double area() {
        return radius * radius * Math.PI;
    }

    @Override
    protected double perimeter() {
        return 2 * radius * Math.PI;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
