/*
    Session 07 - Practice OOP
 */

import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StudentManager studentManager = new StudentManager();

        while (true) {
            System.out.println("""
                    =============================
                    | Student Management System |
                    |   1. Add Student          |
                    |   2. Get All Student      |
                    |   3. Search Student       |
                    |   4. Delete Student       |
                    |   5. Update Student       |
                    |   6. Exit                 |
                    =============================""");
            System.out.print("Enter your choice [1-6]: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    studentManager.addStudent();
                    break;
                case 2:
                    studentManager.getAllStudent();
                    break;
                case 3:
                    studentManager.searchStudent();
                    break;
                case 4:
                    studentManager.deleteStudent();
                    break;
                case 5:
                    studentManager.udpateStudent();
                    break;
                case 6:
                    System.out.println("Exit");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
