package org.example.service.impl;

import org.example.model.Course;
import org.example.service.ICourseService;
import java.util.ArrayList;
import java.util.List;

public class CourseServiceImpl implements ICourseService {
    private final List<Course> catalog = new ArrayList<>();

    @Override
    public void addCourse(Course course) {
        if (course != null) {
            catalog.add(course);
        }
    }

    @Override
    public void updateCourse(String code, String title, int units) {
        Course c = findCourse(code);
        if (c != null) {
            c.setCourseTitle(title);
            c.setCreditUnits(units);
            System.out.println("Course " + code + " updated.");
        }
    }

    @Override
    public void removeCourse(String code) {
        catalog.removeIf(c -> c.getCourseCode().equalsIgnoreCase(code));
        System.out.println("Course " + code + " removed.");
    }

    @Override
    public List<Course> getAllCourses() {
        return new ArrayList<>(catalog);
    }

    @Override
    public Course findCourse(String code) {
        return catalog.stream()
                .filter(c -> c.getCourseCode().equals(code))
                .findFirst()
                .orElse(null);
    }
}