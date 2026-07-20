package question02;

public class MainAppQuestion02 {
    public static void main(String[] args) {
        Car car1 = new Car("Mini Cooper", "Red", 2010);
        Car car2 = new Car("Toyota", "Black", 2015);
        Car car3 = new Car("Honda", "White", 2020);

        car1.printInfo();
        car2.printInfo();
        car3.printInfo();
    }
}
