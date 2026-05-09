package org.example.service;

import org.example.model.Section;
import org.example.model.Instructor;
import java.util.List;

public interface ISectionService {
    void addSection(Section section);
    Section findSection(String name);
    void updateSection(String currentName, String newName);
    List<Section> getAllSections();
    void assignInstructorToSection(Instructor instructor, Section section);
}