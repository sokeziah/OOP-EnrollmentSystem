package org.example.service;
import org.example.model.Student;
import org.example.service.IStudentService;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements IStudentService {
    private List<Student> students = new ArrayList<>();
    @Override public void addStudent(Student s) { students.add(s); }
    @Override public Student findStudent(String id) {
        return students.stream().filter(s -> s.getPersonID().equals(id)).findFirst().orElse(null);
    }
    @Override public void updateStudent(String id, String name, String program) {
        Student s = findStudent(id);
        if (s != null) { s.setPersonName(name); s.setAcademicProgram(program); }
    }
    @Override public void removeStudent(String id) { students.removeIf(s -> s.getPersonID().equals(id)); }
    @Override public List<Student> getAll() { return students; }
}