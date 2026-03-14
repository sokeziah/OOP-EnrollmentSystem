package org.example.model;

public class Course extends Person {
    private String courseID;
    private String courseName;
    private String program;

    public Course(){

    }

    @Override
    public void mainTask() {

    }

    public Course(String CourseID, String courseName, String program) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.program = program;

    }
    public String getCourseID(){
        return courseID;

    }
    public void setCourseID(String courseID) {
        this.courseID = courseID;

    }

    public String getCourseName() {
        return courseName;

    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getProgram() {
        return program;

    }

    public void setProgram(String program){
        this.program = program;
    }
    public void display(){
        System.out.println("Course ID: " + " " + getCourseID());
        System.out.println("Course Name: " + " " + getCourseName());
        System.out.println("Program: " + " " + getProgram() + "\n");

    }

    @Override
    public String toString() {
        return "Course{" +
                "courseID='" + courseID + '\'' +
                ", courseName='" + courseName + '\'' +
                ", program='" + program + '\'' +
                '}';

    }
}
