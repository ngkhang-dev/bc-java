package model;

public final class Company {

    private String name;
    private String taxCode;
    private double monthlyRevenue;

    private Company(String name, double monthlyRevenue, String taxCode) {
        setName(name);
        setMonthlyRevenue(monthlyRevenue);
        setTaxCode(taxCode);
    }

    public static Company createInstance(String name, double monthlyRevenue, String taxCode) {
        return new Company(name, monthlyRevenue, taxCode);
    }

    public double calculateCompanyProfit(double totalSalaryOfEmployees) {
        return monthlyRevenue - totalSalaryOfEmployees;
    }

    public void showInfo() {
        System.out.printf("""
                - Company name: %-25s
                - Tax code: %-15s
                - Monthly revenue: %-15.2f\n
                """, name, taxCode, monthlyRevenue);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Company name is required");
        }

        this.name = name;
    }

    public double getMonthlyRevenue() {
        return monthlyRevenue;
    }

    public void setMonthlyRevenue(double monthlyRevenue) {
        if (monthlyRevenue < 0) {
            throw new IllegalArgumentException("Monthly revenue cannot be negative");
        }

        this.monthlyRevenue = monthlyRevenue;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        if (taxCode == null || taxCode.trim().isEmpty()) {
            throw new IllegalArgumentException("Tax code is required");
        }

        if (!taxCode.matches("\\d{10,13}")) {
            throw new IllegalArgumentException("Tax code must be 10 to 13 digits");
        }

        this.taxCode = taxCode;
    }
}
