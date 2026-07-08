/*
    Session 05 - Dynamic array (List) and Functions

        1. Static và Dynamic arrays
            - Static Array
                - Kích thước cố định

            - Dynamic Array
                - Kích thước có thể thay đổi
                - Interface: List - Implementation: ArrayList, LinkedList, ...etc
                - Phải sử dụng các methods để truy cập/thao tác

            Note:
                - Cả static và dynamic array đểu xảy ra lỗi khi thao tác với index vượt ngoài phạm vi

        2. Hàm (Function)
            - Đóng gói các đoạn code để tái sử dụng
            - Các loại hàm:
                - Dựa vào input: Có tham số và không tham số
                - Dựa vào giá trị trả về: Không có giá trị trả về (void) và có giá trị trả về
            - Nạp chồng hàm (Overloading function):
                - Các hàm có cùng tên nhưng khác nhau về số lượng/loại tham số
                - Không được xem là overloading nếu chỉ khác data type trả về
            - Varargs (variable arguments): cho phép một method chấp nhận 0 hoặc nhiều args thuộc 1 kiểu dữ liệu cụ thể
                - Phải nằm ở vị trí cuối cùng trong param nếu method có nhiều param
                - Mỗi method chỉ có 1 varargs
 */

import java.util.*;

public class MainApplication {
    public static void main(String[] args) {
        playWithDynamicArray();
        playWithFunction();
    }

    public static void playWithDynamicArray() {
//        1. Static array
        int[] numbers = new int[4];

        numbers[0] = 100;
        numbers[1] = 9;
        numbers[2] = -5;
        numbers[3] = 7;
//        numbers[4] = 99; --> Error vì vượt kích thước của mảng

//        2. Dynamic array
        // Khởi tạo mảng: Interface ... Implementation
        List<Integer> numbers2 = new ArrayList<>();

        // Khởi tạo mảng: Implementation ... Implementation
        //  Arrays.asList(1, 2, 3, 4, 5): Khởi tạo với các giá tị ban đầu
        ArrayList<Integer> numbers3 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        numbers2.add(100);  //  Thêm phần tử vào mảng
        numbers2.add(9);
        numbers2.add(-5);
        numbers2.add(7);
        numbers2.add(9);
        numbers2.add(99);

        System.out.println(numbers2.get(2)); // Lấy giá trị

        numbers2.set(2, 789); // Cập nhật giá trị mới
        System.out.println(numbers2.get(2));

        numbers2.remove(4); // Xóa phần tử tại vị trí index
        System.out.println(numbers2.size());

        // Tìm index của value xuất hiện đầu tiên
        System.out.println("Find number 9 at first position: " + numbers2.indexOf(9));

        // Các methods khác: .clear(), .contains(), .lastIndexOf(), ..

        // Duyệt mảng
        System.out.println("Traverse array with for loop:");
        for (int i = 0; i < numbers2.size(); i++) {
            System.out.println(">" + numbers2.get(i) + "<");
        }

        System.out.println("Traverse array with for each loop:");
        for (int number : numbers2) {
            System.out.println(">" + number + "<");
        }
    }

    public static void playWithFunction() {
        // Hàm không có tham số, không giá trị trả về
        greeting();

        // Hàm có tham số, có giá trị trả về
        int result = multiply(99, 10);
        System.out.println("Result: " + result);

        // Hàm có tham số, không giá trị trả về
        sum(2000, 80);

        // Hàm không tham số, có giá trị trả về
        String timeZone = getTimeZone();
        System.out.println("Time zone: " + timeZone);

        // Overloading
        subtract(10, 2);
        subtract(10, 3, 4);

        // Varargs
        sumOfNumbers(1, 2);
        sumOfNumbers(1, 2, 3, 4, 5, 6);

        getAverOfStudent("Khang", 5, 8, 6.2, 4);

        // Recursive function
        printListNumber(4);
    }

    public static void greeting() {
        System.out.println("""
                Welcome to Java Programming Course!
                This is a simple program to introduce you to Java.
                """);
    }

    public static void sum(int a, int b) {
        System.out.println("The sum of " + a + " and " + b + " is: " + (a + b) + "");
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static String getTimeZone() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTimeZone().getDisplayName();
    }

    public static void subtract(int a, int b) {
        System.out.println("The subtract of " + a + " and " + b + " is: " + (a - b) + "");
    }

    public static void subtract(int a, int b, int c) {
        System.out.println("The subtract of " + a + " and " + b + " and " + c + " is: " + (a - b - c) + "");
    }

    public static void sumOfNumbers(int... numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        System.out.println("Sum of " + Arrays.toString(numbers) + " is: " + sum);
    }

    public static void getAverOfStudent(String name, double... scores) {
        double sum = 0;
        for (double score : scores) {
            sum += score;
        }
        System.out.println("Average of " + name + " is: " + (sum / scores.length));
    }

    public static void printListNumber(int n) {
        if (n == 0) {
            System.out.println(0);
            return;
        }

        System.out.println(n);
        printListNumber(n - 1);
    }
}
