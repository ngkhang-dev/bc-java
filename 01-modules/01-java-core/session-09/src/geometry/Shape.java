package geometry;

import java.util.Scanner;

// Abstract class
public abstract class Shape {
    private final Scanner sc = new Scanner(System.in);

    protected String color;
    protected String name;

    public Shape(String color, String name) {
        this.color = color;
        this.name = name;
    }

    public void enterInfo() {
        System.out.println("Enter color: ");
        color = sc.nextLine();
        System.out.println("Enter name: ");
        name = sc.nextLine();
    }

    public void display() {
        System.out.println("Shape: .... - Color: ....");
    }

    // Abstract methods
    protected abstract double area();

    protected abstract double perimeter();

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
