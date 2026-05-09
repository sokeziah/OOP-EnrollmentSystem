package org.example.service;
import org.example.model.Section;
import org.example.service.ISectionService;
import java.util.ArrayList;
import java.util.List;

public class SectionServiceImpl implements ISectionService {
    private List<Section> sections = new ArrayList<>();
    @Override public void addSection(Section s) { sections.add(s); }
    @Override public Section findSection(String name) {
        return sections.stream().filter(s -> s.getGroupName().equals(name)).findFirst().orElse(null);
    }
    @Override public void updateSection(String name, int cap) { /* update logic */ }
    @Override public void removeSection(String name) { sections.removeIf(s -> s.getGroupName().equals(name)); }
    @Override public List<Section> getAll() { return sections; }
}