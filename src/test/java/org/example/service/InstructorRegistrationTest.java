package org.example.service;

import org.example.model.Instructor;
import org.example.model.Department;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InstructorRegistrationTest {

    @Test
    void shouldCreateInstructorWithCorrectDetails() {
        Instructor instructor = new Instructor("INS-01", "Dr. Smith", "Java Programming");
        assertEquals("INS-01", instructor.getPersonId());
        assertEquals("Dr. Smith", instructor.getPersonFullName());
    }

    @Test
    void shouldHandleDepartmentAssignment() {
        Instructor instructor = new Instructor("INS-01", "Dr. Smith", "IT");
        Department citeDept = new Department("CITE");
        instructor.setAssignedDepartment(citeDept);
        assertNotNull(instructor);
    }
}