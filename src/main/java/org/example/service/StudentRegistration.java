package org.example.service;

import org.example.model.Student;
import java.util.ArrayList;

public class StudentRegistration implements StudentReg{
    private ArrayList<Student> studentLists = new ArrayList<>();

    @Override
    public void saveStudent(Student student) {
        studentLists.add(student);

    }

    @Override
    public void displayALlStudent() {
        if(studentLists.isEmpty()){
            System.out.println("No student registered.");
            return;
        }
        for (Student s : studentLists){
            s.display();
        }
    }

    @Override
    public void updateStudent(Student student){
        for(int i = 0; i < studentLists.size(); i++){
            if (studentLists.get(i).getPersonID().equals(student.getPersonID())) {
                studentLists.set(i, student); // [cite: 296]
                break;
            }
        }
    }

    @Override
    public void removeStudent(Student student){
        for(int i = 0; i < studentLists.size(); i++){
            if (studentLists.get(i).getPersonName().equals(student.getPersonName())){
                studentLists.remove(i);
                break;
            }
        }
    }

    @Override
    public Student findStudentById(String studentID) {
        for (Student s : studentLists) {
            if (s.getPersonID().equals(studentID)) {
                return s;
            }
        }
        return null;
    }
}
