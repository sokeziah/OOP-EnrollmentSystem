package org.example.service.impl;

import org.example.model.Student;
import org.example.service.IStudentService;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements IStudentService {
    private List<Student> studentRegistry = new ArrayList<>();

    @Override
    public void addStudent(Student student) { studentRegistry.add(student); }

    @Override
    public void removeStudent(String id) {
        boolean removed = studentRegistry.removeIf(s -> s.getPersonId().equals(id));
        if (removed) System.out.println("Student removed successfully.");
    }

    @Override
    public void updateStudent(String id, String newName, String newProgram) {
        Student student = findStudent(id);
        if (student != null) {
            student.setPersonFullName(newName);
            student.setAcademicProgram(newProgram);
            System.out.println("Student record updated in memory.");
        } else {
            System.out.println("Error: Student ID " + id + " not found.");
        }
    }

    @Override
    public List<Student> getAllStudents() { return studentRegistry; }

    @Override
    public Student findStudent(String id) {
        return studentRegistry.stream().filter(s -> s.getPersonId().equals(id)).findFirst().orElse(null);
    }
}