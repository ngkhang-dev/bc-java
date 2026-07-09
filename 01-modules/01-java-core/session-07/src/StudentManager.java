import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
    private final Scanner sc = new Scanner(System.in);

    private List<Student> students = new ArrayList<>();

    // Initialize list student
    public StudentManager() {
        students.add(new Student("SW123", "Khang", 2000, 9.0, 8.5, 7.0));
        students.add(new Student("SW124", "Nguyen", 2001, 8.0, 7.5, 6.0));
        students.add(new Student("DB002", "Tran", 2002, 7.0, 6.5, 5.0));
        students.add(new Student("DB003", "Nguyen", 2003, 6.0, 5.5, 4.0));
    }

    // Get list student
    public void getAllStudent() {
        if (students.isEmpty()) {
            System.out.println("The list student is empty");
            return;
        }

        System.out.printf("|%-10s|%-25s|%4s|%-10s|%-15s|\n", "ID", "Name", "Yob", "GPA", "Type");

        for (Student student : students) {
            student.printStudent();
        }
    }

    // Add student
    public void addStudent() {
        System.out.println("Enter student information");
        System.out.print("Enter student ID: ");
        String id = sc.nextLine();

        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter student year of birth: ");
        int yob = Integer.parseInt(sc.nextLine());

        System.out.print("Enter student math score: ");
        double math = Double.parseDouble(sc.nextLine());

        System.out.print("Enter student physics score: ");
        double physics = Double.parseDouble(sc.nextLine());

        System.out.print("Enter student chemistry score: ");
        double chemistry = Double.parseDouble(sc.nextLine());

        Student student = new Student(id, name, yob, math, physics, chemistry);
        students.add(student);
        System.out.println("Add student successfully");
    }

    // Update student
    public void udpateStudent() {
        System.out.println("Update student information");
        System.out.print("Enter student ID to update: ");
        String id = sc.nextLine();

        for (Student student : students) {
            if (student.getId().equalsIgnoreCase(id)) {
                System.out.println("Student Information");
                student.printStudent();

                System.out.print("Enter student name: ");
                student.setName(sc.nextLine());

                System.out.print("Enter student year of birth: ");
                student.setYob(Integer.parseInt(sc.nextLine()));

                System.out.print("Enter student math score: ");
                student.setMath(Double.parseDouble(sc.nextLine()));

                System.out.print("Enter student physics score: ");
                student.setPhysics(Double.parseDouble(sc.nextLine()));

                System.out.print("Enter student chemistry score: ");
                student.setChemistry(Double.parseDouble(sc.nextLine()));

                System.out.println("Update student successfully");
                return;
            }
        }

        System.out.println("Not found student");
    }

    // Delete student
    public void deleteStudent() {
        System.out.println("Delete Student");
        System.out.print("Enter student ID to delete: ");
        String id = sc.nextLine();

        for (Student student : students) {
            if (student.getId().equalsIgnoreCase(id)) {
                students.remove(student);
                System.out.println("Delete student successfully");
                return;
            }
        }

        System.out.println("Not found student");
    }

    // Search student
    public void searchStudent() {
        System.out.println("Search Student");

        if (students.isEmpty()) {
            System.out.println("The list student is empty");
            return;
        }

        System.out.print("Enter student ID to search: ");
        String id = sc.nextLine();
        for (Student student : students) {
            if (student.getId().equalsIgnoreCase(id)) {
                System.out.println("Student Information");
                student.printStudent();
                return;
            }
        }

        System.out.println("Not found student");
    }
}
