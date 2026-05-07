package org.example.model;

public class Instructor extends Person {
    private String Courses;

    public Instructor(String instructorID, String instructorName, String Courses){
        super(PersonName, PersonID);
        this.Courses = Courses;

    }

    public String getCourses(){
        return Courses;

    }
    public void setCourses(String Courses){
        this.Courses = Courses;

    }

    @Override
    public void mainTask() {

        System.out.println(getPersonName() + " ins an instructor who teaches: " + courses);
    }

    public String toString(){
        return "Instructor{" +
                "Name='" + getPersonName() + '\'' +
                ", ID='" + getPersonID() + '\'' +
                ", Courses='" + courses + '\'' +
                '}';
    }
}
