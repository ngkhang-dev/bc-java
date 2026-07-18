package model;

public class Company {
    private String name;
    private String taxCode;
    private double monthlyRevenue;

    public Company() {
    }

    public Company(String name, String taxCode, double monthlyRevenue) {
        this.name = name;
        this.taxCode = taxCode;
        this.monthlyRevenue = monthlyRevenue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên công ty không bỏ trống");
        }

        this.name = name;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        if (taxCode == null || taxCode.trim().isEmpty()) {
            throw new IllegalArgumentException("Mã số thuế không bỏ trống");
        }

        if (!taxCode.matches("\\d{10,13}")) {
            throw new IllegalArgumentException("Mã số thuế không hợp lệ");
        }
        this.taxCode = taxCode;
    }

    public double getMonthlyRevenue() {
        return monthlyRevenue;
    }

    public void setMonthlyRevenue(double monthlyRevenue) {
        this.monthlyRevenue = monthlyRevenue;
    }
}
