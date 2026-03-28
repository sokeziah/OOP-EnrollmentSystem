package org.example.service;

import org.example.model.Student;
import org.example.model.Course;

public class CampusRegistrar {
    private StudentReg studentRegistration;
    private CourseReg courseReg;

    public CampusRegistrar(StudentReg studentRegistration, CourseReg courseReg) {
        this.studentRegistration = studentRegistration;
        this.courseReg = courseReg;

    }

    public String saveCourse(Course course){
        courseReg.saveCourse(course);
        return "Success";
    }

    public String saveStudent(Student student){
        studentRegistration.saveStudent(student);
        return "Success";
    }

    public String displayAllStudent(){
        studentRegistration.displayALlStudent();
        return "Success";
    }

    public String displayAllCourse(){
        courseReg.displayAllCourse();
        return "Success";
    }

    public String updateStudent(Student student){
        studentRegistration.updateStudent(student);
        return "Success";
    }

    public String updateCourse(Course course){
        courseReg.updateCourse(course);
        return "Success";
    }

    public String removeStudent(Student student){
        studentRegistration.removeStudent(student);
        return "Success";
    }

    public String removeCourse(Course course){
        courseReg.removeCourse(course);
        return "Success";
    }

    public String findStudentById(Student student){
        studentRegistration.findStudentById(student);
        return "Success";
    }

    public String findCourseByID(Course course){
        courseReg.findCourseByID(course);
        return "Success";
    }
}
