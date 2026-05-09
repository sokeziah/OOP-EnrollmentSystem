package org.example.service;
import org.example.model.Instructor;
import org.example.service.IInstructorService;
import java.util.ArrayList;
import java.util.List;

public class InstructorServiceImpl implements IInstructorService {
    private List<Instructor> instructors = new ArrayList<>();
    @Override public void addInstructor(Instructor i) { instructors.add(i); }
    @Override public Instructor findInstructor(String id) {
        return instructors.stream().filter(i -> i.getPersonID().equals(id)).findFirst().orElse(null);
    }
    @Override public void updateInstructor(String id, String name) {
        Instructor i = findInstructor(id);
        if (i != null) i.setPersonName(name);
    }
    @Override public void removeInstructor(String id) { instructors.removeIf(i -> i.getPersonID().equals(id)); }
}