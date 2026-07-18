package model;

public abstract class Person {
    protected String id;
    protected String name;
    protected int age;
    protected String gender;

    public Person() {
    }

    public Person(String id, String name, int age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public void display() {
        System.out.printf("|%-10s|%-15s|%-6d|%-10s", id, name, age, gender);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID không được bỏ trống");
        }

        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.length() < 3) {
            throw new IllegalArgumentException("Tên không được bỏ trống hoặc quá ngắn");
        }

        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 18 || age > 80) {
            throw new IllegalArgumentException("Tuổi không hợp lệ");
        }

        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        gender = gender.trim();

        if (!(gender.equals("Nam") || gender.equals("Nữ") || gender.equals("Khác"))) {
            throw new IllegalArgumentException("Giới tính chỉ được phép là: Nam /Nữ /Khác");
        }

        this.gender = gender;
    }
}
