public class Chicken extends Animal {
    public Chicken() {
    }

    public Chicken(String name, String color, boolean sex) {
        super(name, color, sex);
    }

    public void digg() {
        System.out.println(name + " digging");
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.printf("%-10s|\n", "Chicken");
    }
}
