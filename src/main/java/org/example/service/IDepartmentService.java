package org.example.service;

import org.example.model.Department;
import org.example.model.Section;
import org.example.model.Instructor;
import java.util.List;

public interface IDepartmentService {
    void addDepartment(Department department);
    void linkSectionToDept(Section section, Department department);
    void assignInstructorToDept(Instructor instructor, Department department);
    Department findDepartment(String name);
    List<Department> getAllDepartments();
}