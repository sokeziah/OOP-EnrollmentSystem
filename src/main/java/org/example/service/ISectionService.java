package org.example.service;
import org.example.model.Section;
import java.util.List;

public interface SectionReg {
    void saveSection(Section section);
    List<Section> displayAllSections();
    // Update might involve assigning a new instructor, handled in the Controller, but we provide a base update here
    void updateSectionInstructor(String groupName, org.example.model.Instructor instructor);
    void removeSection(String groupName);
    Section findById(String groupName); // Uses groupName as the ID
}