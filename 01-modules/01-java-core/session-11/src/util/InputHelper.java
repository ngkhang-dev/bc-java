package util;

import java.util.Scanner;

public class InputHelper {
    private static final Scanner sc = new Scanner(System.in);

    public static String inputText(String message) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine();

            if (!input.trim().isEmpty()) {
                return input;
            }

            System.out.println("Không được bỏ trống");
        }
    }

    public static int inputInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên");
            }
        }
    }

    public static int inputInt(String message, int min, int max) {
        while (true) {
            int numberValid = inputInt(message);
            if (numberValid >= min && numberValid <= max) {
                return numberValid;
            }

            System.out.printf("Vui lòng nhập số nguyên trong khoảng từ %d đến %d\n", min, max);
        }
    }

    public static double inputDouble(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            }
        }
    }

    public static double inputDouble(String message, double min, double max) {
        while (true) {
            double numberValid = inputDouble(message);
            if (numberValid >= min && numberValid <= max) {
                return numberValid;
            }

            System.out.printf("Vui lòng nhập số trong khoảng từ %.2f đến %.2f\n", min, max);
        }
    }

    public static boolean inputYesOrNo(String message) {
        while (true) {
            System.out.print(message + "(Y/N)");
            String answer = sc.nextLine();

            if (answer.equalsIgnoreCase("Y")) {
                return true;
            }
            if (answer.equalsIgnoreCase("N")) {
                return false;
            }

            System.out.println("Chỉ nhập Y hoặc N");
        }
    }

    public static String inputGender () {
        while (true) {
            System.out.print("Nhập giới tính (Nam/Nữ/Khác): ");
            String gender = sc.nextLine().trim();

            if (gender.equals(("Nam")) || gender.equals("Nữ") || gender.equals("Khác")) {
                return gender;
            }

            System.out.println("Vui lòng chỉ nhập Nam, Nữ hoặc Khác");
        }
    }
}
