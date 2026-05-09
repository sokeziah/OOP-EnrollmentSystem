package org.example.service;
import org.example.model.Department;
import org.example.service.IDepartmentService;
import java.util.ArrayList;
import java.util.List;

public class DepartmentServiceImpl implements IDepartmentService {
    private List<Department> departments = new ArrayList<>();
    @Override public void addDepartment(Department d) { departments.add(d); }
    @Override public Department findDepartment(String name) {
        return departments.stream().filter(d -> d.getDepartmentName().equals(name)).findFirst().orElse(null);
    }
    @Override public void removeDepartment(String name) { departments.removeIf(d -> d.getDepartmentName().equals(name)); }
    @Override public List<Department> getAll() { return departments; }
}