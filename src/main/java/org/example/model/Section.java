package org.example.model;
import java.util.ArrayList;
import java.util.List;

public class Section {
    private String sectionName;
    private Course associatedCourse;
    private Instructor assignedInstructor;
    private int maxCapacity;
    private List<Course> courseList = new ArrayList<>();
    private List<Student> enrolledStudents = new ArrayList<>();

    public Section(String name, Course course, int capacity) {
        this.sectionName = name;
        this.associatedCourse = course;
        this.assignedInstructor = null; // Start as null until assigned
        this.maxCapacity = capacity;
        this.enrolledStudents = new ArrayList<>();
        this.courseList.add(course);
    }

    // Helper method to see how many slots are taken
    public int getCurrentEnrollmentSize() {
        return enrolledStudents.size();
    }

    public void addCourse(Course course) {
        this.courseList.add(course);
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    // Standard Getters
    public String getSectionName() {
        return sectionName;
    }

    public Course getAssociatedCourse() {
        return associatedCourse;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public Instructor getAssignedInstructor() {
        return assignedInstructor;
    }

    public void setAssignedInstructor(Instructor i) {
        this.assignedInstructor = i;
    }

    public void addStudent(Student student) {
        if (!this.enrolledStudents.contains(student)) {
            this.enrolledStudents.add(student); // List size increases here
        }
    }
}