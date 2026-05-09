package org.example.service.impl;

import org.example.model.*;
import org.example.service.IEnrollmentService;
import org.example.service.ITuitionService;
import org.example.exception.SectionFullException;

public class EnrollmentServiceImpl implements IEnrollmentService {
    private final ITuitionService tuitionService;

    public EnrollmentServiceImpl(ITuitionService tuitionService) {
        this.tuitionService = tuitionService;
    }

    @Override
    public void enrollStudentInSection(Student student, Section section) throws SectionFullException {

        if (section.getEnrolledStudents().size() >= section.getMaxCapacity()) {
            throw new SectionFullException("Section " + section.getSectionName() + " is already full!");
        }

        section.addStudent(student);
        student.addSection(section);

        for (Course c : section.getCourseList()) {
            tuitionService.calculateFee(student, c.getCreditUnits());
        }
    }
    @Override
    public void viewDepartmentHierarchy(Department dept) {
        System.out.println("\n--- Institutional Hierarchy: " + dept.getDepartmentName() + " ---");

        for (Section section : dept.getOfferedSections()) {
            System.out.println("Section: " + section.getSectionName());

            String teacher = (section.getAssignedInstructor() != null)
                    ? section.getAssignedInstructor().getPersonFullName()
                    : "TBA";
            System.out.println("Instructor: " + teacher);

            System.out.println("Enrolled Students (" + section.getEnrolledStudents().size() + "):");
            for (Student s : section.getEnrolledStudents()) {
                System.out.println("     - " + s.getPersonFullName() + " (" + s.getPersonId() + ")");
            }
        }
    }
}