package org.example.model;

public class Student extends Person {
    private String program;

    public Student() {

    }
    public Student(String program){
        this.program = program;

    }
    public String getProgram (){
        return program;

    }
    public void setProgram (String program){
        this.program = program;

    }
    public void display(){
        System.out.println("Student ID: " + " " + getPersonID());
        System.out.println("Student Name: " + " " + getPersonName());
        System.out.println("Program: " + " " + getProgram() + "\n");
    }
}
