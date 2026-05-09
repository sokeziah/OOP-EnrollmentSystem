package org.example.service;

import org.example.model.Course;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CourseRegistrationTest {

    @Test
    void shouldStoreCourseDataCorrectly() {
        Course course = new Course("IT101", "Java Programming", 3);
        assertEquals("IT101", course.getCourseCode());
        assertEquals(3, course.getCreditUnits());
    }

    @Test
    void shouldUpdateCourseTitle() {
        Course course = new Course("IT101", "Old Title", 3);
        course.setCourseTitle("New Java Title");
        assertEquals("New Java Title", course.getCourseTitle());
    }

    @Test
    void shouldUpdateCreditUnits() {
        Course course = new Course("IT101", "Java", 3);
        course.setCreditUnits(4);
        assertEquals(4, course.getCreditUnits());
    }
}