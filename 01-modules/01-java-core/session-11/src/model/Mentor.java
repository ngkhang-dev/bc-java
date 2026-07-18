package model;

public class Mentor extends Person {
    private double salary;

    public Mentor() {
    }

    public Mentor(String id, String name, int age, String gender, double salary) {
        super(id, name, age, gender);
        this.salary = salary;
    }

    @Override
    public void display() {
        super.display();
        System.out.printf("|%-15s|\n", String.format("%.0f VNĐ", salary));
    }

    public void report() {
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Lương phải lớn hơn 0");
        }

        this.salary = salary;
    }
}
