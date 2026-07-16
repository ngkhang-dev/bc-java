package question04;

public class Car extends Vehicle {
    private String engine;
    private int numSeats;

    public Car() {
    }

    public Car(String brand, String color, int productionYear, String engine, int numSeats) {
        super(brand, color, productionYear);
        this.engine = engine;
        this.numSeats = numSeats;
    }

    public void openTrunk() {
        System.out.println("The trunk is open");
    }

    public void registration() {
        System.out.println("The car is registered licence plate");
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.printf("|%-14s|%8s|%10s|\n", engine, numSeats, "------");
    }

    @Override
    public void getSpeed() {
        System.out.println("The car is running at 100 km/h");
    }

    @Override
    public void getTypeDriveLicence() {
        String typeLicence = numSeats <= 8 ? "B" : "D";

        System.out.println("The car is driving with a " + typeLicence + " car licence");
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public int getNumSeats() {
        return numSeats;
    }

    public void setNumSeats(int numSeats) {
        this.numSeats = numSeats;
    }
}
