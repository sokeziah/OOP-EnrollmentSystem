package org.example.service.impl;

import org.example.model.Instructor;
import org.example.model.Section;
import org.example.service.IInstructorService;
import java.util.ArrayList;
import java.util.List;

public class InstructorServiceImpl implements IInstructorService {
    private List<Instructor> instructors = new ArrayList<>();

    @Override
    public void addInstructor(Instructor instructor) {
        instructors.add(instructor);
    }

    @Override
    public void updateInstructor(String id, String newName, String newSpec) {
        Instructor ins = findInstructor(id);
        if (ins != null) {
            ins.setPersonFullName(newName);
            ins.setSpecialization(newSpec);
        }
    }

    @Override
    public void assignInstructorToSection(Instructor instructor, Section section) {
        if (instructor != null && section != null) {
            instructor.addSection(section);
            section.setAssignedInstructor(instructor);
        }
    }

    @Override
    public void removeInstructor(String id) {
        instructors.removeIf(ins -> ins.getPersonId().equals(id));
    }

    @Override
    public Instructor findInstructor(String id) {
        return instructors.stream()
                .filter(ins -> ins.getPersonId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Instructor> getAllInstructors() {
        return instructors;
    }

    @Override
    public void getInstructorDetails(Instructor instructor) {
        instructor.displayProfile();
    }
}