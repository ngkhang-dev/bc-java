package model;

public abstract class Employee {

    private static final String ID_PATTERN = "^[A-Z]+-\\d{3,}$";
    private static final String FULL_NAME_PATTERN = "\\S+(\\s+\\S+)+";
    private static final String PHONE_PATTERN = "\\d{10,11}";

    protected String id;
    protected String fullName;
    protected String phoneNumber;
    protected double workingDays;
    protected double dailyWage;

    public Employee(String id, String fullName, String phoneNumber, double workingDays, double dailyWage) {
        setId(id);
        setFullName(fullName);
        setPhoneNumber(phoneNumber);
        setWorkingDays(workingDays);
        setDailyWage(dailyWage);
    }

    public void showInfo() {
        System.out.printf("|%-14s|%-25s|%-12s|%-14s|%-13.1f|%-13.2f",
                id, fullName, getRoleName(), phoneNumber, workingDays, dailyWage);
    }

    public abstract void showExtraInfo();

    public abstract String getRoleName();

    public abstract double calculateMonthlySalary();

    public String getId() {
        return id;
    }

    /**
     * Sets the employee ID.
     * Expected format: ROLE-INDEX, e.g. "STAFF-001".
     * final: validation must not be bypassable by subclass overrides.
     */
    public final void setId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID is required");
        }

        if (!id.matches(ID_PATTERN)) {
            throw new IllegalArgumentException("ID must follow the format ROLE-INDEX, e.g. STAFF-001");
        }

        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    /**
     * Sets the employee's full name.
     * Must be at least 3 characters and contain at least two words.
     * final: validation must not be bypassable by subclass overrides.
     */
    public final void setFullName(String fullName) {
        if (fullName == null || fullName.trim().length() < 3) {
            throw new IllegalArgumentException("Full name is required and must be at least 3 characters");
        }

        String trimmed = fullName.trim();
        if (!trimmed.matches(FULL_NAME_PATTERN)) {
            throw new IllegalArgumentException("Full name must contain at least two words");
        }

        this.fullName = trimmed;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public final void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Phone number is required");
        }

        if (!phoneNumber.matches(PHONE_PATTERN)) {
            throw new IllegalArgumentException("Phone number must be 10 to 11 digits");
        }

        this.phoneNumber = phoneNumber;
    }

    public double getWorkingDays() {
        return workingDays;
    }

    public final void setWorkingDays(double workingDays) {
        if (workingDays < 0) {
            throw new IllegalArgumentException("Working days cannot be negative");
        }

        this.workingDays = workingDays;
    }

    public double getDailyWage() {
        return dailyWage;
    }

    public final void setDailyWage(double dailyWage) {
        if (dailyWage < 0) {
            throw new IllegalArgumentException("Daily wage cannot be negative");
        }
        this.dailyWage = dailyWage;
    }
}
