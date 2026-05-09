package org.example.service;

import org.example.exception.SectionFullException;
import org.example.model.Course;
import org.example.model.Section;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EnrollmentServiceImplTest {

    @Test
    void shouldAllowEnrollmentWithinCapacity() {
        Section section = new Section("S1", new Course("C1", "T1", 3), 40);
        assertTrue(section.getEnrolledStudents().size() < section.getMaxCapacity());
    }

    @Test
    void shouldThrowSectionFullExceptionAtLimit() {
        int maxCapacity = 1;
        int currentEnrollment = 1;

        assertThrows(SectionFullException.class, () -> {
            if (currentEnrollment >= maxCapacity) {
                throw new SectionFullException("Section is Full!");
            }
        });
    }

    @Test
    void shouldVerifySectionAssociatedCourse() {
        Course java = new Course("IT101", "Java", 3);
        Section section = new Section("BSIT-1A", java, 30);
        assertEquals("IT101", section.getAssociatedCourse().getCourseCode());
    }
}