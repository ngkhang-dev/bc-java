/*
    Session 08 - OOP (continue)

        1. Access Modifier
            - private: chỉ dùng cho chính class đó
            - public: dùng mọi nơi
            - protected: class hiện tại và các class con kế thừa
            - default: các class cùng chung package

        2. Kế thừa: Class B kế thừa Class A
            - Class A gọi là lớp cơ sở/class cha của class B
            - Class B gọi là lớp dẫn xuất/class con của class A

        3. super()
            - Dùng để gọi/truyền properties cho class cha

        4. @override()
            - Khi cần ghi đè các method của lớp cha

        5. static keyword:
            - Chỉ nên truy cập bằng class name thay vì dùng object vì property và method static là phần chung của class
            - Với method là static, chỉ làm việc với các properties là static
            - static block: chỉ khởi chạy 1 lần duy nhất
*/

import java.util.ArrayList;

public class MainApplication {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Tom", "Blue", true);
        cat1.catchMouse();

        Dog dog = new Dog("Lu", "Black", false);
        dog.showInfo();

        Animal cat2 = new Cat("Sóc", "Organ", false);
        ArrayList<Animal> animals = new ArrayList<>();

        animals.add(cat1);
        animals.add(cat2);
        animals.add(dog);

        System.out.printf("|%-10s|%-10s|%-10s|%-10s|\n", "Name", "Color", "Sex", "Type");
        animals.forEach(animal -> {
            animal.showInfo();
        });

        for (Animal animal : animals) {
            if (animal instanceof Cat) ((Cat) animal).catchMouse();
            else if (animal instanceof Dog) ((Dog) animal).holdHouse();
            else if (animal instanceof Chicken) ((Chicken) animal).digg();
            else System.out.println("Không xác định");
        }

        System.out.println("The number of animals: " + Animal.count);
    }
}
