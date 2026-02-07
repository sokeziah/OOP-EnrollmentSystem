package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main(String[] args) {
        Student student1 = new Student();
        Student student2 = new Student();

        student1.setStudentID("000123");
        student1.setStudentName("John Doe");
        student1.setProgram("Information Technology");

        student2.setStudentID("000124");
        student2.setStudentName("Jane Doe");
        student2.setProgram("Information Technology");

        Course course1 = new Course();

        course1.setCourseID("000001");
        course1.setCourseName("Integrative Programming");
        course1.setProgram("Information Technology");

        student1.display();
        student2.display();
        course1.display();

    }
}
