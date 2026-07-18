/*
    Session 11 - Practice OOP

        - Practice OOP with the management system with students, mentors, and lecturers
        - Handle input with utilities
 */

import manager.PersonManager;
import util.InputHelper;

public class MainApplication {
    public static void main(String[] args) {
        System.out.printf("|%-10s|%-15s|%-6s|%-10s|%-10s|%-15s|", "ID", "Họ tên", "Tuổi", "Giới tính", "Điểm TB",
                "Xếp loại");

        PersonManager manager = new PersonManager();

        int choice = 0;

        do {
            displayMenu();
            choice = InputHelper.inputInt("Chọn chức năng: ", 1, 10);
            switch (choice) {
                case 1:
                    manager.addStudent();
                    break;
                case 2:
                    manager.addLecturer();
                    break;
                case 3:
                    manager.addMentor();
                    break;
                case 4:
                    manager.assignStudentToLecture();
                    break;
                case 5:
                    manager.displayStudent();
                    break;
                case 6:
                    manager.displayLecturer();
                    break;
                case 7:
                    manager.displayMentor();
                    break;
                case 8:
                    manager.findPerson();
                    break;
                case 0:
                    System.out.println("Thoát chương trình");
                    break;
                default: {
                    throw new IllegalArgumentException("Unexpect value: " + choice);
                }
            }
        } while (choice != 0);
    }

    private static void displayMenu() {
        System.out.println("\n================================================");
        System.out.println("  QUẢN LÝ PERSON - DÙNG CHUNG MỘT DANH SÁCH");
        System.out.println("================================================");
        System.out.println("1.  Thêm sinh viên");
        System.out.println("2.  Thêm giảng viên");
        System.out.println("3.  Thêm trợ giảng");
        System.out.println("4.  Phân công sinh viên cho giảng viên");
        System.out.println("5.  Hiển thị danh sách sinh viên");
        System.out.println("6.  Hiển thị danh sách giảng viên");
        System.out.println("7.  Hiển thị danh sách trợ giảng");
        System.out.println("8.  Tìm thành viên theo ID");
        System.out.println("0.  Thoát");
        System.out.println("================================================");
    }
}
