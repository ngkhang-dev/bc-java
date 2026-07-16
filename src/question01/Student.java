package question01;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class Student {
    private String fullName;
    private int yob;
    private List<Double> grades;

    public Student() {
    }

    public Student(String fullName, int yob, double... grades) {
        this.fullName = fullName;
        this.yob = yob;

        this.grades = new ArrayList<>();
        for (double v : grades) {
            this.grades.add(v);
        }
    }

    public void printInfo() {
        System.out.printf("Họ tên: %s - Năm sinh: %d (%d tuổi) - Điểm trung bình: %.2f\n", fullName, yob, getAge(), calculateAverageGrade());
    }

    public double calculateAverageGrade() {
        if (grades.isEmpty()) return 0;

        double tongDiem = 0;
        for (double grade : grades) {
            tongDiem += grade;
        }
        return Math.round((tongDiem / grades.size()) * 100.0) / 100.0;
    }

    public int getAge() {
        return Year.now().getValue() - yob;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getYob() {
        return yob;
    }

    public void setYob(int yob) {
        this.yob = yob;
    }

    public List<Double> getGrades() {
        return grades;
    }

    public void setGrades(List<Double> grades) {
        this.grades = grades;
    }
}
