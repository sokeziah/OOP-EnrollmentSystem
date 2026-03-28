package org.example.service;

import org.example.model.Student;

public interface StudentReg {
    void saveStudent(Student student);
    void displayALlStudent();
    void updateStudent(Student student);
    void removeStudent(Student student);
    String findStudentById(Student student);

}
