/*
    Session 04 - Array

        1. Array cố định kích thước (Static Array)
            - Khai báo mảng
            - Get,set value
            - Duyệt mảng với for, for-each, while
        Note:
            - Khi duyệt mảng, nếu index vượt quá kích thước của mảng -> Lỗi
 */

import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        int[] nums = enterNumbersAndPrint();

        getMaxValue(nums);
        getFirstNegativeNumber(nums);
        getMaxNegativeNumber(nums);
        staticArray();
    }

    public static int[] enterNumbersAndPrint() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number in array");

        int size;

        while (true) {
            System.out.print("Enter size array: ");

            // Kiểm tra dữ liệu tiếp theo có phải là số nguyên hay không
            if (sc.hasNextInt()) {
                size = sc.nextInt();

                if (size > 0) break;

                System.out.println("Size must be greater than 0");
            } else {
                System.out.println("Size must be integer");
                sc.next(); // Reset dữ liệu nhập
            }
        }

        int[] nums = new int[size];

        for (int i = 0; i < size; i++) {
            while (true) {
                System.out.print("Enter number " + (i + 1) + ": ");
                if (sc.hasNextInt()) {
                    nums[i] = sc.nextInt();
                    break;
                }

                System.out.println("Number must be integer");
                sc.next();
            }
        }

        for (int i = 0; i < size; i++) {
            System.out.println("Number " + (i + 1) + ": " + nums[i] + "");
        }

        return nums;
    }

    public static void staticArray() {
        // Khai báo mảng
        // Cách 1: Khai báo mảng rỗng
        String[] staticArray1 = new String[10];
        // Cách 2: Khai báo và gán sẵn giá trị
        String[] staticArray2 = {"a", "b", "c"};
        // Cách 3:
        String[] staticArray3 = new String[]{"JS", "TS", "Python"};

        // Gán giá trị
        staticArray1[0] = "Java";
        staticArray1[1] = "Go";
        staticArray1[2] = "JavaScript";

        // Lấy giá trị
        System.out.println("staticArray1 >" + staticArray1[0] + "<");
        System.out.println("staticArray2 >" + staticArray2[1] + "<");

        // Thay đổi/Cập nhật
        System.out.println("Before: staticArray1 >" + staticArray1[0] + "<");
        staticArray1[0] = "Java and Spring Boot";
        System.out.println("Before: staticArray1 >" + staticArray1[0] + "<");

        // Duyệt mảng
        for (int i = 0; i < staticArray1.length; i++) {
            System.out.println(staticArray1[i]);
        }

        for (String item : staticArray2) {
            System.out.println(item);
        }
    }

    public static void getMaxValue(int[] nums) {
        int size = nums.length;
        int index = 0;
        int maxNumber = nums[0];

        for (int i = 0; i < size; i++) {
            if (maxNumber < nums[i]) {
                maxNumber = nums[i];
                index = i;
            }
        }
        System.out.println("Max number: " + maxNumber + " at index: " + index);
    }

    public static void getFirstNegativeNumber(int[] nums) {
        int index = -1;
        int negativeNumber = 0;

        for (int i = 0; i < nums.length; i++) {
            if (negativeNumber > nums[i]) {
                index = i;
                negativeNumber = nums[i];
                break;
            }
        }
        System.out.println("Negative number: " + negativeNumber + " at index: " + index);
    }

    public static void getMaxNegativeNumber(int[] nums) {
        int index = -1;
        int maxNegativeNumber = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (maxNegativeNumber < nums[i] && nums[i] < 0) {
                maxNegativeNumber = nums[i];
                index = i;
            }
        }

        if (index == -1) System.out.println("No negative number");
        else System.out.println("Max negative number: " + maxNegativeNumber + " at index: " + index);
    }
}
