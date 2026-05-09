package org.example.service;

import org.example.model.*;
import org.example.service.impl.*;
import org.example.exception.SectionFullException;


public class CampusRegistrar {
    private IStudentService studentService;
    private IInstructorService instructorService;
    private ICourseService courseService;
    private IDepartmentService departmentService;
    private ITuitionService tuitionService;
    private IEnrollmentService enrollmentService;
    private ISectionService sectionService;

    public CampusRegistrar(IStudentService ss, IInstructorService is, ICourseService cs,
                           IDepartmentService ds, ITuitionService ts, IEnrollmentService es,
                           ISectionService secs) {
        this.studentService = ss;
        this.instructorService = is;
        this.courseService = cs;
        this.departmentService = ds;
        this.tuitionService = ts;
        this.enrollmentService = es;
        this.sectionService = secs;
    }
    public ITuitionService getTuitionService() {
        return tuitionService;
    }



    //  Enrollment with Exception Handling
    public void enrollStudent(String studentId, String sectionName) throws SectionFullException {
        Student student = studentService.findStudent(studentId);
        Section section = sectionService.findSection(sectionName);

        if (student != null && section != null) {
            enrollmentService.enrollStudentInSection(student, section);
            // Automatically calculate initial tuition based on course units
            tuitionService.calculateFee(student, section.getAssociatedCourse().getCreditUnits());
        } else {
            System.out.println("Student or Section not found.");
        }
    }

    //  Hierarchy Viewing
    public void viewDepartmentHierarchy(String deptName) {
        Department dept = departmentService.findDepartment(deptName);
        if (dept != null) {
            System.out.println("\n--- Institutional Hierarchy: " + dept.getDepartmentName() + " ---");

            // This loop handles the "Multiple Sections" requirement
            for (Section section : dept.getSections()) {
                System.out.println("Section: " + section.getSectionName());

                // 1. Show the specific Instructor for THIS section
                String instructorName = (section.getAssignedInstructor() != null)
                        ? section.getAssignedInstructor().getPersonFullName()
                        : "TBA";
                System.out.println("   Instructor: " + instructorName);

                // 2. Show the specific Students for THIS section
                System.out.println("   Enrolled Students (" + section.getEnrolledStudents().size() + "):");
                if (section.getEnrolledStudents().isEmpty()) {
                    System.out.println("     - No students enrolled yet.");
                } else {
                    for (Student s : section.getEnrolledStudents()) {
                        System.out.println("     - " + s.getPersonFullName() + " (" + s.getPersonId() + ")");
                    }
                }
                System.out.println("-----------------------------------");
            }
        } else {
            System.out.println("Department '" + deptName + "' not found.");
        }
    }

    // 3. Tuition Management
    public void processStudentPayment(String studentId, double amount) {
        Student s = studentService.findStudent(studentId);

        if (s == null) {
            System.out.println("Student not found.");
            return;
        }

        if (s.getEnrolledSections().isEmpty()) {
            System.out.println("ACCESS DENIED: Student must enroll in a section first.");
            return;
        }

        if (amount == 0) {
            tuitionService.displayBillingStatement(s);
        } else {
            tuitionService.payTuition(s, amount);
        }
    }

    // 4. Accessors for the Main Menu (CRUD)
    public IStudentService getStudentService() {
        return studentService;
    }

    public ICourseService getCourseService() {
        return courseService;
    }

    public IInstructorService getInstructorService() {
        return instructorService;
    }

    public ISectionService getSectionService() {
        return sectionService;
    }

    public IDepartmentService getDepartmentService() {
        return departmentService;
    }

    public void applyScholarship(String studentId, double percentage) {
        Student s = studentService.findStudent(studentId);
        if (s != null) {
            tuitionService.applyScholarship(s, percentage);
            System.out.println("Scholarship of " + percentage + "% applied to " + s.getPersonFullName());
        }
    }

    public void updateCourseDetails(String code, String title, int units) {
        courseService.updateCourse(code, title, units);
    }

    public void deleteCourse(String code) {
        courseService.removeCourse(code);
    }

    public void showInstructor(String id) {
        Instructor i = instructorService.findInstructor(id);
        if (i != null) {
            instructorService.getInstructorDetails(i);
        } else {
            System.out.println("Instructor not found.");
        }
    }

    public void assignInstructorToSection(String insId, String secName) {
        Instructor i = instructorService.findInstructor(insId);
        Section s = sectionService.findSection(secName);

        if (i == null) {
            System.out.println("Error: Instructor ID '" + insId + "' not found.");
            return;
        }
        if (s == null) {
            System.out.println("Error: Section '" + secName + "' not found in registry.");
            return;
        }

        sectionService.assignInstructorToSection(i, s);
        i.addSection(s);
        System.out.println(" " + i.getPersonFullName() + " linked to Section: " + s.getSectionName());
    }

    public void assignInstructorToDepartment(String insId, String deptName) {
        Instructor i = instructorService.findInstructor(insId);
        Department d = departmentService.findDepartment(deptName);

        if (i != null && d != null) {
            // Only call the service. Let the service handle the success message.
            departmentService.assignInstructorToDept(i, d);
            i.setAssignedDepartment(d);
        } else {
            System.out.println("Assignment failed.");
        }

    }

}