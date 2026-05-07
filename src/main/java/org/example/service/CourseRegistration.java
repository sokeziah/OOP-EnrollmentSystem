package org.example.service;

import org.example.model.Course;
import java.util.ArrayList;

public class CourseRegistration implements CourseReg{
    private ArrayList<Course> courseLists = new ArrayList();

    @Override
    public void saveCourse(Course course) {
        courseLists.add(course);

    }

    @Override
    public void displayAllCourse() {
        if (courseLists.isEmpty()) {
            System.out.println("No courses registered");
            return;
        }
        for(Course c : courseLists){
            System.out.println("Course ID: " + c.getCourseID());
            System.out.println("Course Name: " + c.getCourseName());
            System.out.println("Program: " + c.getProgram());
            System.out.println("---------------------------------");

        }
    }

    @Override
    public void updateCourse (Course course){
        for(int i = 0; i < courseLists.size(); i++){
            if(courseLists.get(i).getCourseName().equals(course.getCourseName())){
                courseLists.set(i, course);
                break;
            }
        }
    }

    @Override
    public void removeCourse(Course course){
        for(int i = 0; i < courseLists.size(); i++) {
            if (courseLists.get(i).getCourseName().equals(course.getCourseName())) {
                courseLists.remove(i);
                break;
            }
        }
    }

    @Override
    public Course findCourseByID(String courseID) {
        for (Course c : courseLists) {
            if (c.getCourseID().equals(courseID)){
                return c;
            }
        }
        return null;
    }
}

