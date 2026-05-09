package org.example.service;
import org.example.model.Department;
import java.util.List;

public interface DepartmentReg {
    void saveDepartment(Department department);
    List<Department> displayAllDepartments();
    // Since department name is the ID, updating it is usually complex. We leave this empty or throw unsupported.
    void updateDepartment(String name);
    void removeDepartment(String name);
    Department findById(String name); // Uses name as the ID
}