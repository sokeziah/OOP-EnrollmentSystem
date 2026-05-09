package org.example.service.impl;

import org.example.model.Department;
import org.example.model.Section;
import org.example.model.Instructor;
import org.example.service.IDepartmentService;
import java.util.ArrayList;
import java.util.List;

public class DepartmentServiceImpl implements IDepartmentService {
    private List<Department> departments = new ArrayList<>();

    @Override
    public List<Department> getAllDepartments() {
        return this.departments;
    }

    @Override
    public void addDepartment(Department department) {
        if (department != null) {
            this.departments.add(department);
        }
    }

    @Override
    public Department findDepartment(String name) {
        return departments.stream()
                .filter(d -> d.getDepartmentName().equalsIgnoreCase(name))
                .findFirst().orElse(null);
    }

    @Override
    public void linkSectionToDept(Section section, Department department) {
        department.addSection(section);
        System.out.println("Section " + section.getSectionName() + " linked to " + department.getDepartmentName());
    }

    @Override
    public void assignInstructorToDept(Instructor instructor, Department department) {
        department.addInstructor(instructor);
        System.out.println("Instructor " + instructor.getPersonFullName() + " added to " + department.getDepartmentName() + " faculty.");
    }

}