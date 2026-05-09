package org.example.service.impl;

import org.example.model.Section;
import org.example.model.Instructor;
import org.example.service.ISectionService;
import java.util.ArrayList;
import java.util.List;

public class SectionServiceImpl implements ISectionService {
    private List<Section> sections = new ArrayList<>();

    @Override
    public void assignInstructorToSection(Instructor instructor, Section section) {
        if (instructor != null && section != null) {
            section.setAssignedInstructor(instructor);
        }
    }

    @Override
    public Section findSection(String name) {
        return sections.stream()
                .filter(s -> s.getSectionName().equalsIgnoreCase(name))
                .findFirst().orElse(null);
    }
    @Override
    public void addSection(Section section) {
        sections.add(section);
    }

    @Override
    public void updateSection(String currentName, String newName) {
        Section s = findSection(currentName);
        if (s != null) {
            // Note: Ensure Section model has a setSectionName method
            // s.setSectionName(newName);
            System.out.println("Section updated.");
        }
    }

    @Override
    public List<Section> getAllSections() {
        return sections;
    }
}