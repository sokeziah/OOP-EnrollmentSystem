package org.example.service;

import org.example.model.Instructor;
import org.example.model.Section;
import java.util.List;

public interface IInstructorService {
    void addInstructor(Instructor instructor);
    void updateInstructor(String id, String newName, String newSpec);
    void removeInstructor(String id);
    void getInstructorDetails(Instructor instructor);
    List<Instructor> getAllInstructors();
    Instructor findInstructor(String id);
    void assignInstructorToSection(Instructor instructor, Section section);
}