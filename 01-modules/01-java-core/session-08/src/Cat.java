public class Cat extends Animal {
    public Cat() {
    }

    public Cat(String name, String color, boolean sex) {
        super(name, color, sex);
    }

    public void catchMouse(){
        System.out.println(name + " catching mouse");
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.printf("%-10s|\n", "Cat");
    }
}
