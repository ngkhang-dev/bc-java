package geometry;

import java.util.Scanner;

public class Rectangle extends Shape {
    private final Scanner sc = new Scanner(System.in);

    protected double height;
    protected double weight;

    public Rectangle(String color, String name, double height, double weight) {
        super(color, name);
        this.height = height;
        this.weight = weight;
    }

    @Override
    public void enterInfo() {
        super.enterInfo();

        System.out.println("Enter height: ");
        height = Double.parseDouble(sc.nextLine());
        System.out.println("Enter weight: ");
        weight = Double.parseDouble(sc.nextLine());
    }

    @Override
    public void display() {
        super.display();
        System.out.printf("Height: %.2f, Weight: %.2f, Perimeter: %.2f, Area: %.2f", height, weight, perimeter(), area());
    }

    @Override
    protected double area() {
        return height * weight;
    }

    @Override
    protected double perimeter() {
        return (height + weight) * 2;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
