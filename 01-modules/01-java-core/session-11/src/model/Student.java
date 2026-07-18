package model;

public class Student extends Person {
    private double javaScore;
    private double nodeScore;
    private double goScore;

    public Student() {
    }

    public Student(String id, String name, int age, String gender, double javaScore, double nodeScore, double goScore) {
        super(id, name, age, gender);
        this.javaScore = javaScore;
        this.nodeScore = nodeScore;
        this.goScore = goScore;
    }

    public double calculateAverage() {
        return (javaScore + nodeScore + goScore) / 3;
    }

    public String getRank() {
        double average = calculateAverage();

        if (average >= 8) {
            return "Giỏi";
        }

        if (average >= 6) {
            return "Khá";
        }

        if (average >= 5) {
            return "Trung Bình";
        }

        return "Yếu";
    }

    @Override
    public void display() {
        super.display();
        System.out.printf("|%-10.2f|%-10.2f|%-10.2f|%-10.2f|%-15s|\n", javaScore, nodeScore, goScore,
                calculateAverage(), getRank());
    }

    public double getJavaScore() {
        return javaScore;
    }

    public void setJavaScore(double javaScore) {
        if (javaScore < 0 || javaScore > 10) {
            throw new IllegalArgumentException("Điểm Java phải từ 0 đến 10");
        }

        this.javaScore = javaScore;
    }

    public double getNodeScore() {
        return nodeScore;
    }

    public void setNodeScore(double nodeScore) {
        if (nodeScore < 0 || nodeScore > 10) {
            throw new IllegalArgumentException("Điểm Java phải từ 0 đến 10");
        }
        this.nodeScore = nodeScore;
    }

    public double getGoScore() {
        return goScore;
    }

    public void setGoScore(double goScore) {
        if (goScore < 0 || goScore > 10) {
            throw new IllegalArgumentException("Điểm Java phải từ 0 đến 10");
        }
        this.goScore = goScore;
    }
}
