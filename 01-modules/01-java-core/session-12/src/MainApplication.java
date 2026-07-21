/*
    Session 12 - Generic Type <T>

        1. Với Generic Type <T>
            - Khi không set type, mặc định là Object type: <Object>

        2. Generic
            - Class: class CLASS_NAME<T>
            - Method: <T> METHOD_NAME(T value)

        3. Ràng buộc T với 1 Class: class CLASS_NAME<T extends ...>

        4. Wildcard: ?
            - Dùng đại diện cho các kiểu dữ liệu chưa biết
            - Có thể kết hợp với extends: <? extends ...>
 */

import model.Box;
import model.Calculator;
import model.OnePiece;
import model.Pair;
import service.Notification;
import service.PaymentService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainApplication {
    public static void main(String[] args) {

        // Không định nghĩa type -> Mặc định sẽ là object, chứa mọi thứ
        // ArrayList<Object> newList = new ArrayList<Object>();
        ArrayList newList = new ArrayList();

        newList.add("Khang");
        newList.add(10);
        newList.add(true);
        newList.add(new Object());

        // Phải ép kiểu khi sử dụng
        String name = (String) newList.get(0);
        int number = (int) newList.get(1);

        // Khi không set type, <T> mặc định là Object
        Box<String> boxString = new Box<String>("Java");
        Box<Integer> boxNumber = new Box<Integer>(2026);
        Box<Character> boxCharacter = new Box<Character>('K');

        Box<OnePiece> boxOnePiece = new Box(new OnePiece("Luffy", 1_200));
        boxOnePiece.display();

        Pair<Integer, String> student = new Pair<>(1, "Khang");
        student.display();
        Pair<String, String> country = new Pair<>("Viet Nam", "Sai Gon");
        country.display();

        showInfo("Khang");
        System.out.println(getValue(2026));

        Calculator<Integer> num1 = new Calculator<Integer>(2026);
        Calculator<Double> num2 = new Calculator<Double>(26.02);
        System.out.println(num1.getDoubleValue());
        System.out.println(num2.getDoubleValue());

        List<String> names = Arrays.asList("Khang", "An");
        List<Double> scores = Arrays.asList(5.0, 6.7);

        showInfoWildcard(names);
        showInfoWildcard(scores);

        // Demo DIP in SOLID
        System.out.println("Demo DIP in SOLID");
        PaymentService payment = new PaymentService();
        Notification notification = new Notification(payment);
        notification.notifyPayment();
    }

    // Generic Method không có giá trị trả về
    public static <T> void showInfo(T value) {
        System.out.println(value.toString());
    }

    // Generic Method có giá trị trả về
    public static <T> T getValue(T value) {
        return value;
    }

    // Wildcard ?
    public static void showInfoWildcard(List<?> list) {
        for (Object item : list) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
