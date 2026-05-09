package org.example.service;

import org.example.model.Student;
import java.util.List;

public interface IStudentService {
    void addStudent(Student student);
    void updateStudent(String id, String name, String program);
    void removeStudent(String id);
    List<Student> getAllStudents();
    Student findStudent(String id);
}