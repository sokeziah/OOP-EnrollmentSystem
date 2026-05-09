package org.example.service;

import org.example.model.Course;
import java.util.List;

public interface ICourseService {
    void addCourse(Course course);
    void updateCourse(String code, String title, int units);
    void removeCourse(String code);
    List<Course> getAllCourses();
    Course findCourse(String code);
}