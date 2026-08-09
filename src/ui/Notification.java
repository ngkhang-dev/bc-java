package ui;

import util.Role;

public class Notification {

    /**
     * Print the title of the table
     */
    public static void printTitle() {
        System.out.printf("|%-14s|%-25s|%-12s|%-14s|%-13s|%-13s|\n",
                "ID", "Full Name", "Department", "Phone Number", "Working Days", "Daily Wage");
    }

    /**
     * Print the title of the table based on the role of the employee
     * @param role The role of the employee
     */
    public static void printTitle(Role role) {
        System.out.printf("|%-14s|%-25s|%-12s|%-14s|%-13s|%-13s",
                "ID", "Full Name", "Department", "Phone Number", "Working Days", "Daily Wage");

        switch (role) {
            case BASE:
                break;
            case STAFF:
                System.out.printf("|%-25s|\n", "Manager");
                break;
            case MANAGER:
                System.out.printf("|%-12s|\n", "No. of Staff");
                break;
            case DIRECTOR:
                System.out.printf("|%-12s|\n", "Share Percent (%)");
                break;
        }
    }
}
