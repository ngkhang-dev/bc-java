import manager.EmployeeManager;
import model.Employee;
import ui.Menu;
import ui.Notification;

import java.util.Comparator;

public class MainApplication {

    public static void main(String[] args) {
        Menu menu = getMenu();

        int choice;
        EmployeeManager hrManager = new EmployeeManager();

        menu.printGreeting();

        do {
            menu.printMenu();
            choice = menu.getChoice();

            switch (choice) {
                case 1:
                    System.out.println("\nEnter information of company");
                    hrManager.enterInfoCompany();
                    break;
                case 2:
                    System.out.println("\nAssign staff to a manager");
                    hrManager.assignEmployeeToDeptManager();
                    System.out.println("Assign successfully.");
                    break;
                case 3:
                    System.out.println("\nAdd/or Delete an employee");
                    hrManager.manageEmployeeRecord();
                    break;
                case 4:
                    System.out.println("\nPrint information of employees in the company");
                    hrManager.getInfoOfAllEmployees();
                    break;
                case 5:
                    System.out.println("\nCalculate total salary of all employees: " + hrManager.getAllSalaryOfCompany());
                    System.out.println();
                    break;
                case 6:
                    System.out.println("\nFind the top salary staff in the company");
                    hrManager.findTopSalaryStaff();
                    System.out.println();
                    break;
                case 7:
                    System.out.println("\nFind the manager has the most number of managed staff");
                    hrManager.findManagerWithMostStaff();
                    System.out.println();
                    break;
                case 8:
                    System.out.println("\nSort employees by name with ascending order");
                    Notification.printTitle();
                    hrManager.sortEmployees(Comparator.comparing(Employee::getFullName));
                    System.out.println();
                    break;
                case 9:
                    System.out.println("\nSort employees by salary with descending order");
                    Notification.printTitle();
                    hrManager.sortEmployees(Comparator.comparing(Employee::calculateMonthlySalary).reversed());
                    System.out.println();
                    break;
                case 10:
                    System.out.println("\nFind the director has the most shared percentage");
                    hrManager.findDirectorWithMostSharePercent();
                    System.out.println();
                    break;
                case 11:
                    System.out.println("\nCalculate the income of the director");
                    hrManager.printIncomeOfDeptDirector();
                    System.out.println();
                    break;
                case 12:
                    hrManager.printExtraInformationOfEmployees();
                    System.out.println();
                    break;
                case 13:
                    System.out.println("\nInformation of company");
                    hrManager.printInfoCompany();
                    break;
                case 14:
                    System.out.println("\nBye bye, see you next time!");
                    break;
            }

        } while (choice != menu.getCountOption());
    }

    private static Menu getMenu() {
        Menu menu = new Menu("Employee Management System");

        menu.addOption("Enter information of company");
        menu.addOption("Assign employee to a manager");
        menu.addOption("Add/Delete an employee");
        menu.addOption("Print information of employees in the company");
        menu.addOption("Calculate total salary of all employees");
        menu.addOption("Find the top salary staff in the company");
        menu.addOption("Find the manager has the most number of managed staff");
        menu.addOption("Sort employees by name with ascending order");
        menu.addOption("Sort employees by salary with descending order");
        menu.addOption("Find the director has the most shared percentage");
        menu.addOption("Calculate the income of the director");
        menu.addOption("Print extra information of employees by role");
        menu.addOption("Print information of company");
        menu.addOption("Quit");

        return menu;
    }

}
