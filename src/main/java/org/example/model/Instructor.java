package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Instructor extends Person {
    private String specialization;
    private Department assignedDepartment;
    private List<Section> assignedSections = new ArrayList<>();


    public Instructor(String id, String name, String specialization) {
        super(id, name);
        this.specialization = specialization;
    }

    public void setSpecialization(String spec) {
        this.specialization = spec;
    }

    public void setAssignedDepartment(Department dept) {
        this.assignedDepartment = dept;
    }

    public void addSection(Section section) {
        this.assignedSections.add(section);
    }

    @Override
    public void displayProfile() {
        System.out.println("\n--- Instructor Profile ---");
        System.out.println("ID: " + getPersonId());
        System.out.println("Name: " + getPersonFullName());
        System.out.println("Specialization: " + specialization);

        String deptName = (assignedDepartment != null) ? assignedDepartment.getDepartmentName() : "N/A";
        System.out.println("Department: " + deptName);

        System.out.print("Sections: ");
        if (assignedSections.isEmpty()) {
            System.out.println("None");
        } else {
            assignedSections.forEach(s -> System.out.print(s.getSectionName() + " "));
            System.out.println();
        }
    }
}