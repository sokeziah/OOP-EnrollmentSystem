package org.example.service;
import org.example.model.Course;
import org.example.service.ICourseService;
import java.util.ArrayList;
import java.util.List;

public class CourseServiceImpl implements ICourseService {
    private List<Course> courses = new ArrayList<>();
    @Override public void addCourse(Course c) { courses.add(c); }
    @Override public Course findCourse(String id) {
        return courses.stream().filter(c -> c.getCourseID().equals(id)).findFirst().orElse(null);
    }
    @Override public void updateCourse(String id, String name, int units) {
        Course c = findCourse(id);
        if (c != null) { c.setCourseName(name); /* units logic */ }
    }
    @Override public void removeCourse(String id) { courses.removeIf(c -> c.getCourseID().equals(id)); }
    @Override public List<Course> getAll() { return courses; }
}