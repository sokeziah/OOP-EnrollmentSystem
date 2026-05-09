package org.example.service.impl;

import org.example.model.Student;
import org.example.model.Section;
import org.example.model.Course;
import org.example.model.TuitionFeePayment;
import org.example.service.ITuitionService;

public class TuitionServiceImpl implements ITuitionService {
    private static final double RATE_PER_UNIT = 1500.0;

    @Override
    public void calculateFee(Student student, int units) {
        double fee = units * RATE_PER_UNIT;
        TuitionFeePayment record = student.getFinancialRecord();
        record.setTotalAssessedFee(record.getTotalAssessedFee() + fee);
    }

    @Override
    public void applyScholarship(Student student, double percentage) {
        double currentTotal = student.getFinancialRecord().getTotalAssessedFee();
        double discount = currentTotal * (percentage / 100);
        student.getFinancialRecord().setDiscountAmount(discount);
    }

    @Override
    public void displayBillingStatement(Student student) {
        TuitionFeePayment record = student.getFinancialRecord();
        System.out.println("\n====================================");
        System.out.println("       OFFICIAL BILLING STATEMENT    ");
        System.out.println("====================================");
        System.out.println("Student: " + student.getPersonFullName());

        System.out.println("\nENROLLED COURSES:");
        for (Section sec : student.getEnrolledSections()) {
            for (Course c : sec.getCourseList()) {
                System.out.println("- " + c.getCourseTitle() + " (" + c.getCreditUnits() + " units)");
            }
        }


        System.out.println("\nFINANCIAL SUMMARY:");
        System.out.println("Total Assessed:  ₱" + record.getTotalAssessedFee());
        System.out.println("Scholarship:    -₱" + record.getDiscountAmount());
        System.out.println("Total Paid:      ₱" + record.getTotalPaidAmount());
        System.out.println("------------------------------------");
        System.out.println("REMAINING BAL:   ₱" + record.getRemainingBalance());
        System.out.println("====================================\n");
    }

    @Override
    public void payTuition(Student student, double amount) {
        double currentPaid = student.getFinancialRecord().getTotalPaidAmount();
        student.getFinancialRecord().setTotalPaidAmount(currentPaid + amount);
        System.out.println("Payment of ₱" + amount + " received.");
    }

    @Override
    public void makePayment(Student student, double amount) {
        double currentPaid = student.getFinancialRecord().getTotalPaidAmount();
        student.getFinancialRecord().setTotalPaidAmount(currentPaid + amount);
        System.out.println("Payment of ₱" + amount + " received.");
    }

    @Override
    public void processPayment(Student s, double amount) {
        this.makePayment(s, amount);
    }

    @Override
    public double getRemainingBalance(Student student) {
        return student.getFinancialRecord().getRemainingBalance();
    }
}