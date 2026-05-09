package org.example.service;
import org.example.model.Student;
import java.util.List;

public interface StudentReg {
    void saveStudent(Student student);
    List<Student> displayAllStudents();
    void updateStudentName(String studentID, String newName);
    void removeStudent(String studentID);
    Student findById(String studentID);
}