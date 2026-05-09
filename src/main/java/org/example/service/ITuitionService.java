package org.example.service;

import org.example.model.Student;

public interface ITuitionService {
    // Calculates base fee: units * rate
    void calculateFee(Student student, int units);
    // The Action for the Scholarship logic you requested
    void applyScholarship(Student student, double percentage);
    // Processes a basic payment
    void makePayment(Student student, double amount);
    // Displays the final balance
    double getRemainingBalance(Student student);
    // Displays the full statement to the console
    void displayBillingStatement(Student student);
    void payTuition(Student student, double amount);
    void processPayment(Student s, double amount);
}