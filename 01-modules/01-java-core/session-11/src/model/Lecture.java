package model;

import java.util.ArrayList;
import java.util.List;

public class Lecture extends Person {
    private double salary;
    private List<Student> students;

    public Lecture() {
        this.students = new ArrayList<>();
    }

    public Lecture(String id, String name, int age, String gender, double salary) {
        super(id, name, age, gender);
        this.salary = salary;
        this.students = new ArrayList<>();
    }

    @Override
    public void display() {
        super.display();
        System.out.printf("|%-15s|-15d|\n", String.format("%.0f VNĐ", salary), totalStudent());
    }

    public void addStudent(Student student) {
        if (student == null) return;

        Student studentExisting = findStudentById(student.getId());
        if (studentExisting != null) {
            System.out.println("Sinh viên đã tồn tại");
            return;
        }

        students.add(student);
        System.out.println("Đã thêm sinh viên cho giảng viên");
    }

    public boolean removeStudent(String studentId) {
        Student studentExist = findStudentById(studentId);

        if (studentExist != null) {
            students.remove(studentExist);
            return true;
        }

        return false;
    }

    public Student findStudentById(String studentId) {
        Student student = null;

        for (Student stu : students) {
            if (stu.getId().equalsIgnoreCase(studentId)) {
                student = stu;
                break;
            }
        }

        return student;
    }

    public void displayStudent() {
        if (students.isEmpty()) {
            System.out.println("Chưa cí học viên");
            return;
        }

        System.out.println("Danh sách học viên: ");
        System.out.printf("|%-10s|%-15s|%-6d|%-10s|%-10.2f|%-10.2f|%-10.2f|%-10.2f|%-15s|\n", "ID", "Tên", "Tuổi",
                "Giới tính", "Điểm Java", "Điểm Node", "Điểm Go", "Điểm TB", "Xếp loại");
        for (Student student : students) {
            student.display();
        }
    }

    public int totalStudent() {
        return students.size();
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
