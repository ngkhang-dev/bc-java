/*
    Session 03 - Loop

        1. Loops: for, while, do...while
        2. Nested Loops
        3. Keywords: break and continue
 */

import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        printIsoscelesRightTriangle();
        printRectangleStar();
        countNumberDivideOfThree();
        sumEvenNumbers();
        printNumbersEvenDecrease();
        printNumbersDecrease();
        calculatePriceTaxi();
    }

    // 7. In ra hình tam giác vuông cân
    // *
    // **
    // ***
    public static void printIsoscelesRightTriangle() {
        System.out.println("7. Print isosceles right triangle");
        int a = 3;

        for (int i = 0; i < a; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // 6. In ra hình chữ nhật
    // *****
    // *****
    // *****
    public static void printRectangleStar() {
        System.out.println("6. Print rectangle star");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    //    5. Có bao nhiêu số chia hết cho 3 từ 0 -> 1000
    public static void countNumberDivideOfThree() {
        System.out.println("\n5. Count number divide of three from 0 -> 1000: ");
        int count = 0;

        for (int i = 3; i <= 1000; i += 3) {
            count++;
        }

        System.out.println("Number of number divide of three: " + count);
    }

    //    4. Tính tổng các số chẵn từ 1 -> n
    public static void sumEvenNumbers() {
        System.out.println("\n4. Sum even numbers from 1 -> n: ");

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt((sc.nextLine()));

        int sum = 0;

        for (int i = 0; i <= n; i += 2) {
            sum += i;
        }

        System.out.println("Sum: " + sum + "");
    }

    //    3. In ra số chẵn giảm dần từ 20 -> 0
    public static void printNumbersEvenDecrease() {
        System.out.println("\n3. Print numbers even decrease from 20 -> 0");
        for (int i = 20; i >= 2; i -= 2) {
            System.out.println(i);
        }
    }

    //    2. In ra các số giảm dần từ 10 -> 1
    public static void printNumbersDecrease() {
        System.out.println("\n2. Print numbers decrease from 10 -> 0");
        for (int i = 10; i >= 1; i--) {
            System.out.println(i);
        }
    }

    //    1. Tính tiền Grab
    public static void calculatePriceTaxi() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n1.Calculate totalPrice taxi programming");
        System.out.print("Enter the number to choose type Grab [1 - GrabCar, 2 - Grab SUV, 3 - GrabBlack]: ");
        int typeGrab = Integer.parseInt(sc.nextLine());

        String typeGrabName = "";
        switch (typeGrab) {
            case 1:
                typeGrabName = "GrabCar";
                break;
            case 2:
                typeGrabName = "GrabSUV";
                break;
            case 3:
                typeGrabName = "GrabBlack";
                break;
            default:
                System.out.println("Type Grab not found!");
                return;
        }

        System.out.print("Enter the number of distance (km): ");
        double distance = Double.parseDouble(sc.nextLine());

        System.out.print("Enter the wasting time (minutes):   ");
        double time = Double.parseDouble(sc.nextLine());

        double totalPrice = 0.0;

        switch (typeGrab) {
            case 1:
                //
                if (distance <= 1) totalPrice = 8_000;
                else if (distance <= 19) totalPrice = 8_000 + (distance - 1) * 7_500;
                else totalPrice = 8_000 + 18 * 7_500 + (distance - 19) * 7_000;

                if (time > 3) totalPrice += Math.ceil(time / 3) * 2_000;

                break;
            case 2:
                if (distance <= 1) totalPrice = 9_000;
                else if (distance <= 19) totalPrice = 9_000 + (distance - 1) * 8_500;
                else totalPrice = 9_000 + 18 * 8_500 + (distance - 19) * 8_000;

                if (time > 3) totalPrice += Math.ceil(time / 3) * 3_000;

                break;
            case 3:
                if (distance <= 1) totalPrice = 10_000;
                else if (distance <= 19) totalPrice = 10_000 + (distance - 1) * 9_500;
                else totalPrice = 10_000 + 18 * 9_500 + (distance - 19) * 9_000;

                if (time > 3) totalPrice += Math.ceil(time / 3) * 3_500;

                break;
            default:
                System.out.println("Type Grab not found!");
        }

        System.out.println(String.format("Type car: %8s - Distance (km): %.2f - Time (minus): %.2f - Total price: %.2f", typeGrabName, distance, time, totalPrice));
    }
}