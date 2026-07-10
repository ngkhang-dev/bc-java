public class Animal {
    protected String name;
    protected String color;
    protected boolean sex;

    static int count;

    // Static block: chỉ chạy 1 lần duy nhất
    static {
        count = 0;
    }

    public Animal() {
    }

    public Animal(String name, String color, boolean sex) {
        this.name = name;
        this.color = color;
        this.sex = sex;
        this.count++;
    }

    // Phương thức static là phương thức thuộc class, gọi bởi Class name mà không cần tạo object
    public static void showCount() {
        System.out.println("Total animals: " + count);
    }

    public void eat() {
        System.out.println(name + " eating");
    }

    public void showInfo() {
        System.out.printf("|%-10s|%-10s|%-10s|", name, color, sex ? "Boy" : "Girl");
    }

    @Override
    public String toString() {
        return "Animal{ " + "name='" + name + '\'' + ", color='" + color + '\'' + ", sex=" + sex + '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }
}
