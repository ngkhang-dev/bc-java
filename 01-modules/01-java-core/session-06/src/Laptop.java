public class Laptop {
    public String name;
    public String brand;
    public int ram;
    public String cpu;
    public double price;

    public Laptop() {
    }

    public Laptop(String _name, String _brand, int _ram, String _cpu, double _price) {
        name = _name;
        brand = _brand;
        ram = _ram;
        cpu = _cpu;
        price = _price;
    }

    public void greetingOpening() {
        System.out.printf("Laptop %d is opening\n", name);
    }

    public void greetingClosing() {
        System.out.printf("Laptop %d is closing\n", name);
    }

    public void printInfo() {
        System.out.printf("""
                Name: %s
                Brand: %s
                RAM: %d
                CPU: %s
                Price: %.2f
                """, name, brand, ram, cpu, price);
    }
}
