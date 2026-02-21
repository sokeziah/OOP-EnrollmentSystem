package org.example.service;

import org.example.model.Student;
import java.util.ArrayList;

public class StudentRegistration {
    private ArrayList<Student> studentLists = new ArrayList<>();

    public void saveStudent(Student student){
        studentLists.add(student);
    }

    public void displayAllStudent() {
        if(studentLists.isEmpty()){
            System.out.println("No student registered.");
            return;

        }
        for (Student s : studentLists){
            System.out.println("Student ID: " + s.getStudentID());
            System.out.println("Student Name: " + s.getStudentName());
            System.out.println("Program: " + s.getProgram());
            System.out.println("-------------------------------------");
        }
    }

    public void updateStudent(Student student){
        for(int i = 0; i < studentLists.size(); i++){
            if(studentLists.get(i).getStudentName().equals(student.getStudentName())){
                studentLists.set(i, student);
                break;
            }
        }
    }

    public void removeStudent(Student student){
        for(int i = 0; i < studentLists.size(); i++){
            if (studentLists.get(i).getStudentName().equals(student.getStudentName())){
                studentLists.remove(i);
                break;
            }
        }
    }

    public Student findStudentById(String studentID) {
        for (Student s : studentLists) {
            if (s.getStudentID().equals(studentID)) {
                return s;
            }
        }
        return null;
    }
}
