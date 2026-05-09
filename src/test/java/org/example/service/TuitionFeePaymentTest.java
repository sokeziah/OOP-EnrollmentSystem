package org.example.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TuitionFeePaymentTest {

    @Test
    void testStandardTuitionCalculation() {
        double rate = 500.0;
        int units = 15;
        assertEquals(7500.0, units * rate);
    }

    @Test
    void testZeroUnitTuition() {
        double rate = 500.0;
        int units = 0;
        assertEquals(0.0, units * rate);
    }

    @Test
    void testPaymentDeduction() {
        double balance = 5000.0;
        double payment = 2000.0;
        double remaining = balance - payment;
        assertEquals(3000.0, remaining);
    }
}