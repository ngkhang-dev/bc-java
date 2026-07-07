/*
    Session 02 - Conditional statements

        1. Câu điều kiện
            - if, if...else, if...else if...else
            - Toán tử 3 ngôi: <condition> ? <true> : <false>
            - Switch case: switch...case và switch expression

        2. Example and practices
 */

import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        getInvoice();
        getDayName();
        getResultStudent();
        convertUSDToVND();
        convertCelsiusToFahrenheit();
        getAverageOfFiveNumbers();
        getSumOfThreeNumbers();
        getTriangleLength();
    }

    // 8. Nhập vào tên hàng, số lượng, đơn giá. Tính và in ra tiền phải trả theo quy tắc số lượng mua:
    //  - [..., 49]: không giảm
    //  - [50, 100]: giảm 8%
    //  - [101,...]: số lượng từ 101 trở đi giảm 12%
    public static void getInvoice() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n8. Get invoice");

        final double DISCOUNT_PERCENTAGE_L1 = 0.08;
        final double DISCOUNT_PERCENTAGE_L2 = 0.12;

        System.out.print("Enter the name of the product: ");
        String name = sc.nextLine();
        System.out.print("Enter the quantity: ");
        int quantity = Integer.parseInt(sc.nextLine());
        System.out.print("Enter the unit price: ");
        double unitPrice = Double.parseDouble(sc.nextLine());

        double totalPrice = 0.0;

        if (quantity <= 49) totalPrice = quantity * unitPrice;
        else if (quantity <= 100) totalPrice = quantity * unitPrice * (1 - DISCOUNT_PERCENTAGE_L1);
        else
            totalPrice = 100 * unitPrice * (1 - DISCOUNT_PERCENTAGE_L1) + (quantity - 100) * unitPrice * (1 - DISCOUNT_PERCENTAGE_L2);

        System.out.printf("The product name '%s', quatility: %d. Total price: %.2f", name, quantity, totalPrice);
    }

    // 7. Nhập vào số nguyên n. In ra tên ngày trong tuần tương ứng với n: 1-Sunday, 2-Monday, ...7-Saturday
    public static void getDayName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n7. Get day name");

        System.out.print("Enter the number of day: ");
        int day = Integer.parseInt(sc.nextLine());

        String nameDay = "";
        switch (day) {
            case 1:
                nameDay = "Sunday";
                break;
            case 2:
                nameDay = "Monday";
                break;
            case 3:
                nameDay = "Tuesday";
                break;
            case 4:
                nameDay = "Wednesday";
                break;
            case 5:
                nameDay = "Thursday";
                break;
            case 6:
                nameDay = "Friday";
                break;
            case 7:
                nameDay = "Saturday";
                break;
            default:
                nameDay = "Unknown day";
        }

        String dayType = switch (day) {
            case 1, 2, 3, 4, 5 -> "Weekday";
            case 6, 7 -> "Weekend";
            default -> {
                System.out.println("Invalid day");
                yield "Unknown day";  // Khi có multi-line block, phải dùng yeild để trả về kết quả
            }
        };

        System.out.println("The name of the day is: " + nameDay);
        System.out.println("The type of the day is: " + dayType);
    }

    // 6. Nhập điểm 3 môn học, tính điểm trung bình và in ra xếp loại ("Giỏi" > 8=; "Khá" >= 6.5; còn lại là "Trung bình")
    public static void getResultStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n6. Get result student");

        double sum = 0;
        int numbersGrade = 0;

        while (numbersGrade < 3) {
            System.out.print("Enter the subject " + (numbersGrade + 1) + ": ");
            sum += Double.parseDouble(sc.nextLine());
            numbersGrade++;
        }

        double average = sum / numbersGrade;
        String type;

        if (average >= 8) type = "Giỏi";
        else if (average >= 6.5) type = "Khá";
        else type = "Trung Bình";

        System.out.println("The average of the subjects is: " + average + " and the type is: " + type);
    }

    // 5. Cho trước tỉ giá VND-USD là : 23.500đ. Viết chương trình nhập vào số USD và tính ra tiền VNĐ
    public static void convertUSDToVND() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n5. Convert USD to VND");
        final double USD_TO_VND = 23_500;

        System.out.print("Enter the amount of USD: ");
        double usd = Double.parseDouble(sc.nextLine());

        System.out.println("Amount of VND: " + (usd * USD_TO_VND));
    }

    // 4. Chuyển đổi độ C (Celsius) sang độ F (Fahrenheit)
    public static void convertCelsiusToFahrenheit() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n4. Convert Celsius to Fahrenheit");

        System.out.print("Enter the temperature in Celsius: ");
        double celsius = Double.parseDouble(sc.nextLine());
        double fahrenheit = (celsius * 1.8) + 32;

        System.out.println("Temperature in Fahrenheit: " + fahrenheit);
    }

    // 3. Tính giá trị trung bình của 5 số nhập từ bàn phím
    public static void getAverageOfFiveNumbers() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n3. Calculate the average of five numbers");

        int count = 0;
        int sum = 0;

        while (count < 5) {
            System.out.print("Enter number " + (count + 1) + ": ");
            sum += Integer.parseInt(sc.nextLine());
            count++;
        }

        System.out.println("The average of the five numbers is: " + (double) sum / 5);
    }

    // 2. Viết chương trình tính nhập vào số nguyên dương n với 3 ký số, tính tổng 3 ký số của n.
    public static void getSumOfThreeNumbers() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n2. Calculate the sum of three numbers");
        System.out.print("Enter number n: ");
        int n = Integer.parseInt(sc.next());

        int sum = 0;

        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }

        System.out.println("The sum of the three numbers is: " + sum);
    }

    // 1. Viết chương trình tính chiều dài cạnh huyền của một tam giác vuông khi biết 2 cạnh góc vuông.
    public static void getTriangleLength() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Calculate the length of a triangle");

        System.out.print("Enter the first of the triangle: ");
        double a = Double.parseDouble(sc.nextLine());
        System.out.print("Enter the second of the triangle: ");
        double b = Double.parseDouble(sc.nextLine());

        double c = Math.sqrt(a * a + b * b);
        System.out.println("The length of the triangle is: " + c);
    }
}
