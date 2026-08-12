package model;

public class Director extends Employee {

    private static final double DEFAULT_DAILY_WAGE = 300;
    private double sharePercent;

    public Director(String id, String fullName, String phoneNumber, double workingDays, double sharePercent) {
        super(id, fullName, phoneNumber, workingDays, Director.DEFAULT_DAILY_WAGE);

        setSharePercent(sharePercent);
    }

    public double calculateIncome(double companyProfit) {
        return calculateMonthlySalary() + (sharePercent / 100) * companyProfit;
    }

    @Override
    public void showExtraInfo() {
        super.showInfo();
        System.out.printf("|%-17.2f|\n", getSharePercent());
    }

    @Override
    public String getRoleName() {
        return "DIRECTOR";
    }

    @Override
    public double calculateMonthlySalary() {
        return dailyWage * workingDays;
    }

    public double getSharePercent() {
        return sharePercent;
    }

    public final void setSharePercent(double sharePercent) {
        if (sharePercent < 0 || sharePercent > 100) {
            throw new IllegalArgumentException("Share percent must be between 0 and 100");
        }

        this.sharePercent = sharePercent;
    }
}
