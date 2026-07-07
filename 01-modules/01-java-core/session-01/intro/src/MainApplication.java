/*
    Session 01 - Introduction

        1. Print
        2. Data types và Variables
            - int, long, short, float, double
            - char, String
            - boolean
        3. Operators
            - Math: +,-,*,/,%
            - Logic: &&, ||,!
            - Comparison: >, <, >=, <=, ==, !=
        4. Prefix and Suffix
            - Prefix: ++<variable>, --<variable>
            - Suffix: <variable>++, <variable>--
        5. Enter input from keyboard: Scanner object
            - Scanner sc = new Scanner() - Dùng đối tượng Scanner với các method: .nextLine(), .nextInt(), ...etc
            - Khi nhập số và chuỗi, phải dùng sc.nextLine() (đọc giá trị như chuỗi) và ép kiểu về dạng số khi cần
        6. 3-layer model: Input --> Process --> Output
        7. Lỗi trong Java:
            - Trong execute (Runtime Error)
            - Trước khi execute
 */

import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
//        1. In ra console log
        System.out.println("Bootcamp Java");

//        2. Biến và data types
        byte smallNumber = 125;
        short mediumNumber = 32000;
        int standardNumber = 2147483647;
        long hugeNumber = 9223372036854775807L;

        double precisePi = 3.141592653589;
        float piEstimate = 3.14159f;

        boolean isActive = true;
        char letter = 'K';
        String firstName = "Khang";
        String lastName = "Nguyen";
        System.out.println(firstName + " " + lastName + " @" + 2026); // Java ép kiểu số thành chuỗi

//        3. Toán tử số học: +,-,*,/,%
        int number1 = 1000;
        int number2 = 3;

        System.out.println("number1 = " + number1 + ", number2 = " + number2);
        System.out.println("number1 + number2 = " + (number1 + number2));
        System.out.println("number1 - number2 = " + (number1 - number2));
        System.out.println("number1 * number2 = " + (number1 * number2));
        System.out.println("number1 / number2 = " + (number1 / number2));
        System.out.println("number1 % number2 = " + (number1 % number2));

//        4. Toán tử so sánh: >, <, >=, <=, ==, !=
        int number3 = 2;
        int number3_2 = 2;
        int number4 = 9;
        int number4_2 = 9;

        System.out.println("number3 = " + number3 + ", number4 = " + number4);
        System.out.println("number3 > number 4? " + (number3 > number4));
        System.out.println("number3 < number 4? " + (number3 < number4));
        System.out.println("number3 = number 4? " + (number3 == number4));
        System.out.println("number3 != number 4? " + (number3 != number4));
        System.out.println("number3 >= number3_2? " + (number3 >= number3_2));
        System.out.println("number4 <= number 4_2? " + (number4 <= number4_2));

//        5. Toán tử logic: &&, ||, !
        int number5 = 8;
        int number6 = 10;
        int number7 = 4;

        System.out.println("number5 = " + number5 + ", number6 = " + number6 + ", number7 = " + number7);
        System.out.println("(number5 < number6 && number5 > number7) ? " + (number5 < number6 && number5 > number7));
        System.out.println("(number5 > number6 || number5 > number7) ? " + (number5 > number6 || number5 > number7));

//        6. Hằng số: final
        final String DB_URL = "http://localhost:8080/";
        final int PORT = 8080;

//        7. Prefix and Suffix
        int baseNumber1 = 26;
        int baseNumber2 = 26;
        int prefixNumber = ++baseNumber1;
        int numberSuffix = baseNumber2++;

        System.out.println("Base number 1: " + baseNumber1 + " and Base number 2: " + baseNumber2);
        System.out.println("[1] - Before: " + baseNumber1 + " - After: " + prefixNumber);
        System.out.println("[2] - Before: " + baseNumber2 + " - After: " + numberSuffix);

//        8. Nhập input từ bàn phím: Scanner object
        Scanner sc = new Scanner(System.in);

        // Khi nhập số và chữ, gây ra lỗi với dòng nhập tiếp theo
        // System.out.println("Enter yob: ");
        // int yob = sc.nextInt();
        // ---> Fix: Sử dụng sc.nextLine() và convert lại số khi cần
        System.out.println("Enter yob: ");
        int yob = Integer.parseInt(sc.nextLine());

        System.out.println("Enter full name: ");
        String fullName = sc.nextLine();

        System.out.println("Full name: " + fullName);
        System.out.println("Yob: " + yob);

//        9. Mô hình 3 khối: Input --> Process --> Output
        // Input
        System.out.println("Calculator a + b");
        System.out.println("Enter a = ");
        int a = Integer.parseInt(sc.nextLine());
        System.out.println("Enter b = ");
        int b = Integer.parseInt(sc.nextLine());

        // Process
        int sum = a + b;

        // Output
        System.out.println("Sum a + b = " + sum);
    }
}
