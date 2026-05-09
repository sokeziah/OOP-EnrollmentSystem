package org.example.service;
import org.example.model.TuitionFeePayment;
import java.util.List;

public interface TuitionReg {
    void saveTuition(String studentID, TuitionFeePayment tuition);
    List<TuitionFeePayment> displayAllTuitions();
    void updateTuitionBalance(String studentID, double paymentAmount);
    void removeTuition(String studentID);
    TuitionFeePayment findById(String studentID);
}