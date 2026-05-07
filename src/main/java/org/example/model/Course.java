package org.example.model;

public class Course extends Person {
    private String courseID;
    private String courseName;
    private String program;
    private int units;

    @Override
    public void mainTask() {
        System.out.println("Course Registered");
    }

    public Course(String courseID, String courseName, String program, int units) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.program = program;
        this.units = units;
    }

    public String getCourseID(){
        return courseID;

    }
    public String getCourseName() {
        return courseName;

    }
    public String getProgram() {
        return program;

    }
    public int getUnits(){
        return units;

    }
    public void setCourseID(String courseID) {
        this.courseID = courseID;

    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;

    }
    public void setProgram(String program){
        this.program = program;

    }
    public void setUnits(int units){
        this.units = units;

    }
    public void display(){
        System.out.println("Course ID: " + " " + getCourseID());
        System.out.println("Course Name: " + " " + getCourseName());
        System.out.println("Program: " + " " + getProgram());
        System.out.println("Program: " + " " + getUnits() + "\n");


    }

    @Override
    public String toString() {
        return "Course{" +
                "courseID='" + courseID + '\'' +
                ", courseName='" + courseName + '\'' +
                ", program='" + program + '\'' +
                ", units='" + units + '\'' +
                '}';

    }
}
