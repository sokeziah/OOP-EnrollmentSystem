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
        this.units = units;

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
        System.out.println("Course ID: " + " " + courseID());
        System.out.println("Course Name: " + " " + courseName());
        System.out.println("Program: " + " " + program());
        System.out.println("Program: " + " " + units() + "\n");


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
