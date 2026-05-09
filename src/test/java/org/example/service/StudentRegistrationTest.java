package org.example.service;

import org.example.model.Student;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentRegistrationTest {

    @Test
    void shouldCorrectlyStoreStudentDetails() {
        Student student = new Student("2024-0001", "Keziah So", "BSIT");
        String id = student.getPersonId();
        String name = student.getPersonFullName();
        String program = student.getAcademicProgram();

        assertEquals("2024-0001", id);
        assertEquals("Keziah So", name);
        assertEquals("BSIT", program);
    }

    @Test
    void shouldUpdateStudentProgram() {
        Student student = new Student("2024-0001", "Keziah So", "BSIT");
        student.setAcademicProgram("BSCS");
        assertEquals("BSCS", student.getAcademicProgram());
    }
}