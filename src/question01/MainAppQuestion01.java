package question01;

public class MainAppQuestion01 {
    public static void main(String[] args) {
        Student student1 = new Student("Nguyen Khang", 2000, 5.0, 5.5, 6);
        Student student2 = new Student("Nguyen Van A", 2001, 8.0, 7.4, 8.6);

        student1.printInfo();
        student2.printInfo();
    }
}
