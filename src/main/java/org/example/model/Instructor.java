package org.example.model;

public class Instructor extends Student {
    private String instructorID;
    private String instructorName;
    private String Courses;

    public Instructor(String instructorID, String instructorName, String Courses){
        this.instructorID = instructorID;
        this.instructorName = instructorName;
        this.Courses = Courses;

    }
    public String getInstructorID(){
        return instructorID;

    }
    public void setInstructorID(String instructorID) {
        this.instructorID = instructorID;

    }
    public String getInstructorName(){
        return instructorName;

    }
    public void setInstructorName(String instructorName){
        this.instructorName = instructorName;

    }
    public String getCourses(){
        return Courses;

    }
    public void setCourses(String Courses){
        this.Courses = Courses;

    }
}
