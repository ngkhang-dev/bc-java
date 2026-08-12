package model;

public class Staff extends Employee {

    private static final double DEFAULT_DAILY_WAGE = 100;
    private Manager manager;

    public Staff(String id, String fullName, String phoneNumber, double workingDays, Manager manager) {
        super(id, fullName, phoneNumber, workingDays, Staff.DEFAULT_DAILY_WAGE);
        this.manager = manager;
    }

    public void removeManager() {
        this.manager = null;
    }

    @Override
    public void showExtraInfo() {
        super.showInfo();
        System.out.printf("|%-25s|\n", manager != null ? manager.getFullName() : "null");
    }

    @Override
    public String getRoleName() {
        return "STAFF";
    }

    @Override
    public double calculateMonthlySalary() {
        return dailyWage * workingDays;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
