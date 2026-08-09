package manager;

import model.*;
import ui.Notification;
import util.InputHelper;
import util.Role;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeManager {

    private Company company;
    private final List<Employee> employees;

    public EmployeeManager() {
        this.employees = new ArrayList<>(initialData());
    }

    /**
     * Initial data
     */
    private List<Employee> initialData() {
        Director director1 = new Director("DIRECTOR-001", "Director 1", "0987654321", 20, 10);
        Director director2 = new Director("DIRECTOR-002", "Director 2", "0987603321", 19, 12);

        Manager manager1 = new Manager("MANAGER-001", "Manager 1", "0987654321", 20);
        Staff staff1 = new Staff("STAFF-001", "Staff 1", "0977654321", 21, manager1);
        Staff staff2 = new Staff("STAFF-002", "Staff 2", "0978585466", 21, manager1);
        manager1.setManagedStaff(staff1, staff2);

        Manager manager2 = new Manager("MANAGER-002", "Manager 2", "0988654921", 18);
        Staff staff3 = new Staff("STAFF-003", "Staff 3", "0908754021", 20, manager2);
        manager2.addStaff(staff3);

        Staff staff4 = new Staff("STAFF-004", "Staff 4", "0907444021", 0, null);

        return Arrays.asList(director1, director2, manager1, manager2, staff1, staff2, staff3, staff4);
    }

    /**
     * Add a new company
     */
    public void enterInfoCompany() {
        if (company != null) {
            System.out.println("Company information already exists.");
            return;
        }

        String companyName = InputHelper.readLine("Enter company name", "Name");
        String taxCode = InputHelper.readLine("Enter company tax code", "\\d{10,13}",
                "Tax Code must be 10 to 13 digits");
        double monthlyRevenue = InputHelper.readDouble("Enter monthly revenue", "Monthly Revenue");

        company = Company.createInstance(companyName, monthlyRevenue, taxCode);
        company.showInfo();
    }

    /**
     * Assign a staff to a manager
     */
    public void assignEmployeeToDeptManager() {
        Manager manager = null;
        Staff staff = null;

        String managerId = InputHelper.readLine("Enter manager ID", "ID");

        for (Employee employee : employees) {
            if (employee instanceof Manager && employee.getId().equals(managerId)) {
                manager = (Manager) employee;
                break;
            }
        }

        if (manager == null) {
            System.out.println("Invalid manager ID. Return to main menu.");
            return;
        }

        String staffId = InputHelper.readLine("Enter staff ID", "ID");

        for (Employee employee : employees) {
            if (employee instanceof Staff && employee.getId().equals(staffId)) {
                staff = (Staff) employee;
                break;
            }
        }

        if (staff == null) {
            System.out.println("Invalid staff ID. Return to main menu.");
            return;
        }

        manager.setManagedStaff(staff);
        staff.setManager(manager);
    }

    /**
     * Entry point for the "Add/Delete an employee" menu option
     */
    public void manageEmployeeRecord() {
        System.out.println("""
                1. Add employee
                2. Delete employee
                """);
        int choice = InputHelper.readInt("Enter your choice [1-2]", 1, 2, "Your choice");

        if (choice == 1) {
            addEmployee();
        } else {
            deleteEmployee();
        }
    }

    /**
     * Add a new employee to the company
     */
    public void addEmployee() {
        int role = InputHelper.readInt("Enter role: Staff-1, Manager-2, Director-3", 1, 3, "Role");

        String fullName = InputHelper.readLine("Enter full name", ".{3,}", "Full name must be at least 3 characters");
        String phoneNumber = InputHelper.readLine("Enter phone number", "\\d{10,11}",
                "Phone number must be 10 to 11 digits");
        double workingDays = InputHelper.readDouble("Enter working days", 0, 31, "Working Days");

        String id = generateId(role);
        Employee newEmployee;

        if (Role.STAFF.getValue() == role) {
            Manager manager = null;
            String managerId = InputHelper.readLine("Enter manager ID (leave blank if none)");

            if (!managerId.isEmpty()) {
                manager = findManagerById(managerId);
                if (manager == null) {
                    System.out.printf("""
                            - No manager found with ID %s.
                            - Staff will be added without a manager.
                            """, managerId);
                }
            }

            Staff staff = new Staff(id, fullName, phoneNumber, workingDays, manager);
            if (manager != null) {
                manager.addStaff(staff);
            }

            newEmployee = staff;

        } else if (Role.MANAGER.getValue() == role) {
            newEmployee = new Manager(id, fullName, phoneNumber, workingDays);
        } else {
            double sharePercent = InputHelper.readDouble("Enter share percent (0-100)", 0, 100, "Share Percent");
            newEmployee = new Director(id, fullName, phoneNumber, workingDays, sharePercent);
        }

        employees.add(newEmployee);
        System.out.println("Added successfully. New employee ID: " + id);
    }

    /**
     * Delete an employee from the company
     */
    public void deleteEmployee() {
        String id = InputHelper.readLine("Enter employee ID to delete", "ID");

        Employee target = findEmployeeById(id);
        if (target == null) {
            System.out.println("No employee found with ID " + id + ".");
            return;
        }

        Notification.printTitle();
        target.showInfo();
        System.out.println("|");

        String confirm = InputHelper.readLine("Are you sure you want to delete this employee? (y/n)");
        if (!confirm.equalsIgnoreCase("y")) {
            System.out.println("Deletion cancelled.");
            return;
        }

        if (target instanceof Manager) {
            Manager manager = (Manager) target;
            for (Staff staff : manager.getManagedStaff()) {
                staff.removeManager();
            }
            manager.getManagedStaff().clear();
        } else if (target instanceof Staff) {
            Staff staff = (Staff) target;
            if (staff.getManager() != null) {
                staff.getManager().removeStaff(staff);
            }
        }

        employees.remove(target);
        System.out.println("Deleted employee " + target.getFullName() + " (" + target.getId() + ") successfully.");
    }

    /**
     * Print information of all employees
     */
    public void getInfoOfAllEmployees() {
        Notification.printTitle();

        for (Employee employee : employees) {
            employee.showInfo();
            System.out.println("|");
        }
        System.out.println();
    }

    /**
     * Get the total salary of all employees in the company
     */
    public double getAllSalaryOfCompany() {
        double totalSalary = 0;

        for (Employee employee : employees) {
            totalSalary += employee.calculateMonthlySalary();
        }

        return totalSalary;
    }

    /**
     * Find the staffs with the highest salary
     */
    public void findTopSalaryStaff() {
        ArrayList<Staff> topSalaryStaffs = new ArrayList<>();
        double maxSalary = 0;

        for (Employee employee : employees) {
            if (employee instanceof Staff) {
                Staff staff = (Staff) employee;
                double monthlySalary = staff.calculateMonthlySalary();

                if (monthlySalary == maxSalary) {
                    topSalaryStaffs.add(staff);
                    continue;
                }

                if (monthlySalary > maxSalary) {
                    maxSalary = monthlySalary;
                    topSalaryStaffs.clear();
                    topSalaryStaffs.add(staff);
                }
            }
        }

        if (topSalaryStaffs.size() != 0) {
            System.out.println("The staffs with the highest salary are:");
            Notification.printTitle(Role.STAFF);
            for (Staff staff : topSalaryStaffs) {
                staff.showExtraInfo();
            }

        } else {
            System.out.println("No staff has the highest salary.");
        }
    }

    /**
     * Find the managers with the most staff members managed
     */
    public void findManagerWithMostStaff() {
        ArrayList<Manager> managerWithMostStaffs = new ArrayList<>();
        int maxStaffCount = 0;

        for (Employee employee : employees) {
            if (employee instanceof Manager) {
                Manager manager = (Manager) employee;
                int staffCount = manager.getManagedStaffCount();

                if (staffCount > maxStaffCount) {
                    maxStaffCount = staffCount;
                    managerWithMostStaffs.clear();
                    managerWithMostStaffs.add(manager);
                    continue;
                }

                if (staffCount == maxStaffCount) {
                    managerWithMostStaffs.add(manager);
                }
            }
        }

        if (managerWithMostStaffs.size() != 0) {
            System.out.println("The managers with the most staff are: ");
            Notification.printTitle(Role.MANAGER);
            for (Manager manager : managerWithMostStaffs) {
                manager.showExtraInfo();
            }
        } else {
            System.out.println("No manager has the most staff.");
        }
    }

    /**
     * Sort employees
     */
    public void sortEmployees(Comparator<Employee> comparator) {
        ArrayList<Employee> sortedList = new ArrayList<>(employees);

        sortedList.stream().sorted(comparator).forEach(employee -> {
            employee.showInfo();
            System.out.println("|");
        });
    }

    /**
     * Find the directors with the most share percent (%)
     */
    public void findDirectorWithMostSharePercent() {
        ArrayList<Director> directorWithMostSharePercents = new ArrayList<>();
        double maxSharePercent = 0;

        for (Employee employee : employees) {
            if (employee instanceof Director) {
                Director director = (Director) employee;
                double sharePercent = director.getSharePercent();

                if (sharePercent > maxSharePercent) {
                    maxSharePercent = sharePercent;
                    directorWithMostSharePercents.clear();
                    directorWithMostSharePercents.add(director);
                    continue;
                }

                if (sharePercent == maxSharePercent) {
                    directorWithMostSharePercents.add(director);
                }
            }
        }

        if (directorWithMostSharePercents.size() != 0) {
            System.out.println("The directors with the most share percent are: ");
            Notification.printTitle(Role.DIRECTOR);
            for (Director director : directorWithMostSharePercents) {
                director.showExtraInfo();
            }
        } else {
            System.out.println("No director has the most share percent.");
        }
    }

    /**
     * Print the income of all directors
     */
    public void printIncomeOfDeptDirector() {
        if (company == null) {
            System.out.println("No company information available. Please enter company information first.");
            return;
        }

        double companyProfit = company.calculateCompanyProfit(getAllSalaryOfCompany());

        System.out.printf("|%-14s|%-25s|%-14s|%-13s|%-13s|%-12s|%-12s|\n",
                "ID", "Full Name", "Phone Number", "Working Days", "Daily Wage", "Share Percent (%)", "Income");
        for (Employee employee : employees) {
            if (employee instanceof Director) {
                Director director = (Director) employee;
                System.out.printf("|%-14s|%-25s|%-14s|%-13.1f|%-13.2f|%-17.2f|%-12.2f|\n",
                        director.getId(), director.getFullName(), director.getPhoneNumber(),
                        director.getWorkingDays(), director.getDailyWage(), director.getSharePercent(),
                        director.calculateIncome(companyProfit));
            }
        }
    }

    /**
     * Print extra information of employees of a certain role
     */
    public void printExtraInformationOfEmployees() {
        int role = InputHelper.readInt("Enter role: Staff-1, Manager-2, Director-3", 1, 3, "Role");

        if (Role.STAFF.getValue() == role) {
            Notification.printTitle(Role.STAFF);
            _getEmployeesByType(Staff.class).forEach(Employee::showExtraInfo);
            return;
        }

        if (Role.MANAGER.getValue() == role) {
            Notification.printTitle(Role.MANAGER);
            _getEmployeesByType(Manager.class).forEach(Employee::showExtraInfo);
            return;
        }

        Notification.printTitle(Role.DIRECTOR);
        _getEmployeesByType(Director.class).forEach(Employee::showExtraInfo);

    }

    /**
     * Print information of the company
     */
    public void printInfoCompany() {
        if (company == null) {
            System.out.println("No company information available. Please enter company information first.");
            return;
        }

        company.showInfo();
    }

    private <T extends Employee> List<T> _getEmployeesByType(Class<T> type) {
        return employees.parallelStream()
                .filter(type::isInstance)
                .map(type::cast)
                .collect(Collectors.toList());
    }

    private String generateId(int role) {
        String rolePrefix = Role.values()[role].name();

        long maxIndex = employees.stream()
                .map(employee -> employee.getId())
                .filter(exitingId -> exitingId.startsWith(rolePrefix + "-"))
                .map(existingId -> existingId.substring(rolePrefix.length() + 1))
                .mapToLong(Long::parseLong)
                .max()
                .orElse(0L);

        return String.format("%s-%03d", rolePrefix, maxIndex + 1);
    }

    private Manager findManagerById(String managerId) {
        Employee employee = findEmployeeById(managerId);

        return (employee instanceof Manager) ? (Manager) employee : null;
    }

    private Employee findEmployeeById(String id) {
        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                return employee;
            }
        }

        return null;
    }
}
