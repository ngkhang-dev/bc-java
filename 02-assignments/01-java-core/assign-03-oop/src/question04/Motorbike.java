package question04;

public class Motorbike extends Vehicle {
    private int engineCapacity;

    public Motorbike() {
    }

    public Motorbike(String brand, String color, int productionYear, int engineCapacity) {
        super(brand, color, productionYear);
        this.engineCapacity = engineCapacity;
    }

    public void getRestriction() {
        System.out.println("The motorbike is restricted into highways");
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.printf("|%-14s|%8s|%10s|\n", "----", "----", engineCapacity);
    }

    @Override
    public void getSpeed() {
        System.out.println("The motorbike is running at 80 km/h");
    }

    @Override
    public void getTypeDriveLicence() {
        String typeLicence = engineCapacity < 175 ? "A1" : "A2";
        System.out.printf("The motorbike is driving with a %s motorbike licence\n", typeLicence);
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }
}
