public class Student {
    private String id;
    private String name;
    private int yob;
    private double math;
    private double physics;
    private double chemistry;

    public Student() {
    }

    public Student(String id, String name, int yob, double math, double physics, double chemistry) {
        this.id = id;
        this.name = name;
        this.yob = yob;
        this.math = math;
        this.physics = physics;
        this.chemistry = chemistry;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYob() {
        return yob;
    }

    public void setYob(int yob) {
        this.yob = yob;
    }

    public double getMath() {
        return math;
    }

    public void setMath(double math) {
        this.math = math;
    }

    public double getPhysics() {
        return physics;
    }

    public void setPhysics(double physics) {
        this.physics = physics;
    }

    public double getChemistry() {
        return chemistry;
    }

    public void setChemistry(double chemistry) {
        this.chemistry = chemistry;
    }

    public double getGpa() {
        return (math + chemistry + physics) / 3;
    }

    public String getTypeStudent() {
        double gpa = getGpa();
        if (gpa >= 9) return "Excellent";
        else if (gpa >= 8) return "Very Good";
        else if (gpa >= 6) return "Good";
        else if (gpa >= 5) return "Ordinary";
        else return "Below average";
    }

    public void printStudent() {
        System.out.printf("|%-10s|%-25s|%4d|%-10.2f|%-15s|\n", id, name, yob, getGpa(), getTypeStudent());
    }

    @Override
    public String toString() {
        return "Student{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", yob=" + yob + '}';
    }
}
