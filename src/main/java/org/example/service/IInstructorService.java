package org.example.service;
import org.example.model.Instructor;
import java.util.List;

public interface InstructorReg {
    void saveInstructor(Instructor instructor);
    List<Instructor> displayAllInstructors();
    void updateInstructorSpecialization(String instructorID, String newSpec);
    void removeInstructor(String instructorID);
    Instructor findById(String instructorID);
}