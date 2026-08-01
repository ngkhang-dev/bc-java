package question05;

public class HairDryer extends ElectronicDevices {
    private int maxTemperature;

    public HairDryer() {
    }

    public HairDryer(String brand, String name, int power, int maxTemperature) {
        super(brand, name, power);
        this.maxTemperature = maxTemperature;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.printf("|%-15s|%-4s|%-18s|%-18d|\n", getType(), "----", "----", maxTemperature);
    }

    @Override
    public String getType() {
        return "Làm đẹp";
    }

    public void getMode() {
        System.out.println("The hair dryer is in manual mode");
    }

    public int getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(int maxTemperature) {
        this.maxTemperature = maxTemperature;
    }
}
