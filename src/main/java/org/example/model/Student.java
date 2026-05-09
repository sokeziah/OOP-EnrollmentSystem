package org.example.model;
import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private String academicProgram;
    private TuitionFeePayment financialRecord = new TuitionFeePayment();;
    private List<Section> enrolledSections = new ArrayList<>();
    private double tuitionBalance = 0.0;

    public Student(String id, String name, String program) {
        super(id, name);
        this.academicProgram = program;
        this.financialRecord = new TuitionFeePayment();
        this.enrolledSections = new ArrayList<>();
    }

    public void setPersonFullName(String name) {
        super.setPersonFullName(name);
    }

    public void addSection(Section section) {
        this.enrolledSections.add(section);
    }

    public String getAcademicProgram() {
        return academicProgram;
    }

    public void setAcademicProgram(String p) {
        this.academicProgram = p;
    }

    public TuitionFeePayment getFinancialRecord() {
        return financialRecord;
    }

    public List<Section> getEnrolledSections() {
        return enrolledSections;
    }

    @Override
    public void displayProfile() {
    }
}