package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Manager extends Employee {

    private static final double DEFAULT_DAILY_WAGE = 200;
    private static final double BONUS_PER_STAFF = 100;
    private final List<Staff> managedStaffs;

    public Manager(String id, String fullName, String phoneNumber, double workingDays) {
        super(id, fullName, phoneNumber, workingDays, Manager.DEFAULT_DAILY_WAGE);
        this.managedStaffs = new ArrayList<>();
    }

    @Override
    public void showExtraInfo() {
        super.showInfo();
        System.out.printf("|%-12s|\n", getManagedStaffCount());
    }

    @Override
    public String getRoleName() {
        return "MANAGER";
    }

    @Override
    public double calculateMonthlySalary() {
        return dailyWage * workingDays + Manager.BONUS_PER_STAFF * managedStaffs.size();
    }

    /**
     * Assigns a staff member to this manager, moving them off any previous manager first.
     *
     * @param staff The staff member to assign.
     */
    public void addStaff(Staff staff) {
        if (staff == null || managedStaffs.contains(staff)) {
            return;
        }

        Manager managerCurrent = staff.getManager();

        if (managerCurrent != null && managerCurrent != this) {
            managerCurrent.removeStaff(staff);
        }

        managedStaffs.add(staff);
        staff.setManager(this);
    }

    /**
     * Assigns multiple staff members to this manager.
     *
     * @param staffList The list of staff members to assign. If null or empty, no action is taken.
     */
    public void addStaff(Staff... staffList) {
        if (staffList == null) {
            return;
        }

        for (Staff staff : staffList) {
            addStaff(staff);
        }
    }

    /**
     * Removes a staff member from this manager.
     *
     * @param staff The staff member to remove.
     */
    public void removeStaff(Staff staff) {
        if (managedStaffs.remove(staff)) {
            staff.setManager(null);
        }
    }

    /**
     * Removes all staff members currently managed by this manager.
     */
    public void clearManagedStaff() {
        for (Staff staff : new ArrayList<>(managedStaffs)) {
            removeStaff(staff);
        }
    }

    /**
     * Get the number of staff members managed by this manager.
     *
     * @return The number of staff members managed by this manager.
     */
    public int getManagedStaffCount() {
        return managedStaffs.size();
    }

    /**
     * Read-only view of the managed staff.
     */
    public List<Staff> getManagedStaff() {
        return Collections.unmodifiableList(managedStaffs);
    }
}
