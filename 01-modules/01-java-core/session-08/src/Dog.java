public class Dog extends Animal{
    public Dog() {
    }

    public Dog(String name, String color, boolean sex) {
        super(name, color, sex);
    }

    public void holdHouse (){
        System.out.println(name + " holding a house");
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.printf("%-10s|\n", "Dog");
    }
}
