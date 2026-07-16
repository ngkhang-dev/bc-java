package question05;

public class AirConditioner extends ElectronicDevices {
    private int noiseLevel;
    private int maxArea;

    public AirConditioner() {
    }

    public AirConditioner(String brand, String name, int power, int noiseLevel, int maxArea) {
        super(brand, name, power);
        this.noiseLevel = noiseLevel;
        this.maxArea = maxArea;
    }

    @Override
    public void printInfo() {
        super.printInfo();

        System.out.printf("|%-15s|%-4d|%-18d|%-18s|\n", getType(), noiseLevel, maxArea, "----");
    }

    @Override
    public String getType() {
        return "Làm mát";
    }

    public void getFanSpeed() {
        System.out.println("The fan speed is 100%");
    }

    public int getNoiseLevel() {
        return noiseLevel;
    }

    public void setNoiseLevel(int noiseLevel) {
        this.noiseLevel = noiseLevel;
    }

    public int getMaxArea() {
        return maxArea;
    }

    public void setMaxArea(int maxArea) {
        this.maxArea = maxArea;
    }
}
