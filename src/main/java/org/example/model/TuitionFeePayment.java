package org.example.model;

public class TuitionFeePayment {
    private double totalAssessedFee = 0.0;
    private double totalPaidAmount = 0.0;
    private double discountAmount = 0.0; // Added for scholarships

    public double getTotalAssessedFee() { return totalAssessedFee; }
    public void setTotalAssessedFee(double fee) { this.totalAssessedFee = fee; }

    public double getTotalPaidAmount() { return totalPaidAmount; }
    public void setTotalPaidAmount(double paid) { this.totalPaidAmount = paid; }

    public double getDiscountAmount() { return discountAmount; }
    public void setDiscountAmount(double discount) { this.discountAmount = discount; }

    public double getRemainingBalance() {
        // Formula: Total - Discount - What has already been paid
        return totalAssessedFee - discountAmount - totalPaidAmount;
    }
}