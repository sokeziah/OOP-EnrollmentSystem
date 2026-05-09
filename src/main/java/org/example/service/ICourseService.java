package org.example.service;
import org.example.model.Course;
import java.util.List;

public interface CourseReg {
    void saveCourse(Course course);
    List<Course> displayAllCourses();
    void updateCourseName(String courseID, String newName);
    void removeCourse(String courseID);
    Course findById(String courseID);
}