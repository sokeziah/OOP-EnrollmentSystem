package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String departmentName;
    private List<Section> offeredSections = new ArrayList<>();
    private List<Instructor> assignedFaculty = new ArrayList<>();

    public Department(String name) {
        this.departmentName = name;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public List<Section> getSections() {
        return offeredSections;
    }

    public void addSection(Section section) {
        this.offeredSections.add(section);
    }

    public void addInstructor(Instructor instructor) {
        this.assignedFaculty.add(instructor);
    }

    public List<Section> getOfferedSections() {
        return offeredSections;
    }
}