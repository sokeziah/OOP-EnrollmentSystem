package org.example.service;
import org.example.model.*;
import org.example.service.ITuitionService;

public class TuitionServiceImpl implements ITuitionService {
    @Override public void calculateTuition(Student s, Course c) {
        s.getTuitionDetails().addCharge(c.getUnits() * 1000.0);
    }
    @Override public void recordPayment(Student s, double amt) {
        s.getTuitionDetails().processPayment(amt);
    }
    @Override public double getBalance(Student s) {
        return s.getTuitionDetails().getBalance();
    }
}