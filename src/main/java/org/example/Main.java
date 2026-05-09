package org.example;

import org.example.model.*;
import org.example.service.*;
import org.example.service.impl.*;
import org.example.exception.SectionFullException;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static CampusRegistrar registrar;

    public static void main(String[] args) {
        // Initialize Services & Registrar
        IStudentService ss = new StudentServiceImpl();
        IInstructorService is = new InstructorServiceImpl();
        ICourseService cs = new CourseServiceImpl();
        IDepartmentService ds = new DepartmentServiceImpl();
        ITuitionService ts = new TuitionServiceImpl();
        IEnrollmentService es = new EnrollmentServiceImpl(ts);
        ISectionService secs = new SectionServiceImpl();
        registrar = new CampusRegistrar(ss, is, cs, ds, ts, es, secs);

        setupSampleData();

        boolean running = true;
        while (running) {
            printMenu();
            String choice = scanner.nextLine();
            try {
                switch (choice) {
                    case "1":
                        manageStudents();
                        break;
                    case "2":
                        manageInstructors();
                        break;
                    case "3":
                        manageCourses();
                        break;
                    case "4":
                        enrollStudent();
                        break;
                    case "5":
                        viewInstitutionalHierarchy();
                        break;
                    case "6":
                        processBilling();
                        break;
                    case "7":
                        System.out.print("Enter Instructor ID: ");
                        String insId = scanner.nextLine();
                        System.out.print("Enter Section Name: ");
                        String secN = scanner.nextLine();

                        Instructor instr = registrar.getInstructorService().findInstructor(insId);
                        Section sect = registrar.getSectionService().findSection(secN);

                        if (instr != null && sect != null) {
                            registrar.getInstructorService().assignInstructorToSection(instr, sect);
                            System.out.println("Instructor assigned to section!");
                        }
                        break;
                    case "0":
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid option!");
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n--- UNIVERSITY MANAGEMENT SYSTEM ---");
        System.out.println("1. Student Management ");
        System.out.println("2. Instructor Management ");
        System.out.println("3. Course Management ");
        System.out.println("4. Enrollment (Capacity Check)");
        System.out.println("5. View Hierarchy (Dept -> Section -> Student)");
        System.out.println("6. Tuition & Billing");
        System.out.println("0. Exit");
        System.out.print("Selection: ");
    }

    private static void enrollStudent() {
        System.out.print("Enter Student ID: ");
        String sid = scanner.nextLine();
        System.out.print("Enter Section Name: ");
        String sname = scanner.nextLine();

        try {
            registrar.enrollStudent(sid, sname);
            System.out.println("Enrollment Successful!");
        } catch (SectionFullException e) {
            System.out.println("REJECTED: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void viewInstitutionalHierarchy() {
        System.out.print("Enter Department Name (e.g., CITE): ");
        String dName = scanner.nextLine();
        registrar.viewDepartmentHierarchy(dName);
    }

    private static void processBilling() {
        System.out.print("Enter Student ID: ");
        String sid = scanner.nextLine();

        System.out.println("1. View Statement | 2. Make Payment | 3. Apply Scholarship");
        String sub = scanner.nextLine();

        Student s = registrar.getStudentService().findStudent(sid);
        if (s == null) {
            System.out.println("Student not found!");
            return;
        }

        if (sub.equals("1")) {
            registrar.processStudentPayment(sid, 0);
        } else if (sub.equals("2")) {
            System.out.print("Amount: ");
            double amt = Double.parseDouble(scanner.nextLine());

            registrar.processStudentPayment(sid, amt);

            System.out.println("\n====================================");
            System.out.println("          PAYMENT RECEIPT           ");
            System.out.println("====================================");
            System.out.println("Date:          May 9, 2026");
            System.out.println("Student:       " + s.getPersonFullName());
            System.out.println("Student ID:    " + s.getPersonId());
            System.out.println("------------------------------------");
            System.out.println("Amount Paid:   ₱" + amt);
            System.out.println("------------------------------------");

            System.out.println("NEW ACCOUNT SUMMARY:");
            registrar.processStudentPayment(sid, 0);

            System.out.println("====================================\n");
        } else if (sub.equals("3")) {
            System.out.print("Enter Scholarship Percentage (e.g., 20 for 20%): ");
            double percent = Double.parseDouble(scanner.nextLine());

            registrar.applyScholarship(sid, percent);
        }
    }

    private static void manageStudents() {
        System.out.println("\n--- STUDENT MANAGEMENT ---");
        System.out.println("1. Add | 2. Update | 3. Delete | 4. View All");
        System.out.print("Selection: ");
        String sub = scanner.nextLine();

        if (sub.equals("1")) { // ADD
            System.out.print("ID: ");
            String id = scanner.nextLine();
            System.out.print("Name: ");
            String n = scanner.nextLine();
            System.out.print("Program: ");
            String p = scanner.nextLine();
            registrar.getStudentService().addStudent(new Student(id, n, p));
            System.out.println("Student added.");

        } else if (sub.equals("2")) {
            System.out.print("Enter Student ID to Update: ");
            String id = scanner.nextLine();

            if (registrar.getStudentService().findStudent(id) != null) {
                System.out.print("New Full Name: ");
                String newName = scanner.nextLine();
                System.out.print("New Program: ");
                String newProg = scanner.nextLine();

                registrar.getStudentService().updateStudent(id, newName, newProg);
                System.out.println("Student updated.");
            } else {
                System.out.println("Student not found!");
            }

        } else if (sub.equals("3")) {
            System.out.print("Enter ID to Delete: ");
            String idToDelete = scanner.nextLine();

            Student found = registrar.getStudentService().findStudent(idToDelete);

            if (found != null) {
                registrar.getStudentService().removeStudent(idToDelete);
                System.out.println("Student " + idToDelete + " removed successfully.");
            } else {
                System.out.println("Error: Student ID '" + idToDelete + "' does not exist.");
            }

        } else if (sub.equals("4")) { // VIEW ALL
            System.out.println("\n--- Student Registry ---");
            registrar.getStudentService().getAllStudents().forEach(s ->
                    System.out.println(s.getPersonId() + ": " + s.getPersonFullName() + " [" + s.getAcademicProgram() + "]"));
        }
    }

    private static void manageInstructors() {
        System.out.println("\n--- INSTRUCTOR MANAGEMENT ---");
        System.out.println("1. Add Instructor");
        System.out.println("2. Update Instructor");
        System.out.println("3. Delete Instructor");
        System.out.println("4. View All");
        System.out.println("5. Assign Dept/Section");
        System.out.println("6. View Details");
        System.out.print("Selection: ");

        String sub = scanner.nextLine();

        if (sub.equals("1")) {
            System.out.print("ID: ");
            String id = scanner.nextLine();
            System.out.print("Name: ");
            String n = scanner.nextLine();
            System.out.print("Specialization: ");
            String spec = scanner.nextLine();
            registrar.getInstructorService().addInstructor(new Instructor(id, n, spec));
            System.out.println("Instructor added.");

        } else if (sub.equals("2")) {
            System.out.print("Enter Instructor ID to Update: ");
            String id = scanner.nextLine();
            if (registrar.getInstructorService().findInstructor(id) != null) {
                System.out.print("New Name: ");
                String name = scanner.nextLine();
                System.out.print("New Specialization: ");
                String spec = scanner.nextLine();
                registrar.getInstructorService().updateInstructor(id, name, spec);
                System.out.println("Record updated.");
            } else {
                System.out.println("Instructor not found.");
            }

        } else if (sub.equals("3")) {
            System.out.print("Enter ID to Delete: ");
            String id = scanner.nextLine();
            if (registrar.getInstructorService().findInstructor(id) != null) {
                registrar.getInstructorService().removeInstructor(id);
                System.out.println("Instructor removed.");
            } else {
                System.out.println("Error: ID does not exist.");
            }

        } else if (sub.equals("4")) {
            System.out.println("\n--- Faculty List ---");
            registrar.getInstructorService().getAllInstructors().forEach(i ->
                    System.out.println(i.getPersonId() + ": " + i.getPersonFullName()));

        } else if (sub.equals("5")) {
            System.out.print("Enter Instructor ID: ");
            String insId = scanner.nextLine();
            Instructor i = registrar.getInstructorService().findInstructor(insId);

            if (i == null) {
                System.out.println("Error: Instructor ID '" + insId + "' not found.");
                return;
            }

            System.out.println("\nAssign to: 1. Department | 2. Section");
            System.out.print("Choice: ");
            String assignType = scanner.nextLine();

            if (assignType.equals("1")) {
                System.out.println("\n--- Available Departments ---");
                registrar.getDepartmentService().getAllDepartments().forEach(d ->
                        System.out.println("- " + d.getDepartmentName()));
                System.out.print("Enter Department Name: ");
                registrar.assignInstructorToDepartment(insId, scanner.nextLine());

            } else if (assignType.equals("2")) {
                System.out.println("\n--- Available Sections ---");
                registrar.getSectionService().getAllSections().forEach(sec ->
                        System.out.println("- " + sec.getSectionName()));
                System.out.print("Enter Section Name: ");
                registrar.assignInstructorToSection(insId, scanner.nextLine());
            }

        } else if (sub.equals("6")) {
            System.out.print("Enter Instructor ID: ");
            registrar.showInstructor(scanner.nextLine());

        } else {
            System.out.println("Invalid selection.");
        }
    }

    private static void manageCourses() {
        System.out.println("\n--- COURSE MANAGEMENT ---");
        System.out.println("1. Add Course");
        System.out.println("2. Update Course");
        System.out.println("3. Delete Course");
        System.out.println("4. View All Courses");
        System.out.print("Selection: ");

        String sub = scanner.nextLine();

        if (sub.equals("1")) {
            System.out.print("Code: ");
            String code = scanner.nextLine();
            System.out.print("Title: ");
            String title = scanner.nextLine();
            System.out.print("Units: ");
            int units = Integer.parseInt(scanner.nextLine());

            Course newCourse = new Course(code, title, units);
            registrar.getCourseService().addCourse(newCourse);

            System.out.print("Assign to which Section? (e.g., BSIT-1A): ");
            String secName = scanner.nextLine();


            Section targetSection = registrar.getSectionService().findSection(secName);

            if (targetSection != null) {
                targetSection.addCourse(newCourse);
                System.out.println("Course added and linked to " + secName + ".");

                for (Student s : targetSection.getEnrolledStudents()) {
                    registrar.getTuitionService().calculateFee(s, units);
                }
            } else {
                System.out.println("Course added, but Section '" + secName + "' was not found.");
            }

        } else if (sub.equals("2")) {
            System.out.print("Enter Course Code to Update: ");
            String code = scanner.nextLine();
            System.out.print("New Title: ");
            String title = scanner.nextLine();
            System.out.print("New Units: ");
            int units = Integer.parseInt(scanner.nextLine());
            registrar.updateCourseDetails(code, title, units);

        } else if (sub.equals("3")) {
            System.out.print("Enter Course Code to Delete: ");
            String code = scanner.nextLine();
            registrar.deleteCourse(code);

        } else if (sub.equals("4")) {
            System.out.println("\n--- Course Catalog ---");
            registrar.getCourseService().getAllCourses().forEach(c ->
                    System.out.println(c.getCourseCode() + ": " + c.getCourseTitle() + " (" + c.getCreditUnits() + " units)"));
        } else {
            System.out.println("Invalid selection.");
        }
    }

    private static void setupSampleData() {
        // 1. Unique Course Codes
        Course it = new Course("IT101", "Programming 1", 3);
        Course psy = new Course("PSY101", "Psychology 1", 3);
        Course acc = new Course("ACC101", "Math 1", 3);

        registrar.getCourseService().addCourse(it);
        registrar.getCourseService().addCourse(psy);
        registrar.getCourseService().addCourse(acc);

        // 2. Departments
        Department ceas = new Department("CEAS");
        Department cite = new Department("CITE");
        Department cbeam = new Department("CBEAM");

        registrar.getDepartmentService().addDepartment(ceas);
        registrar.getDepartmentService().addDepartment(cite);
        registrar.getDepartmentService().addDepartment(cbeam);

        // 3. Unique Sections
        Section sec1 = new Section("BSPSY-1A", psy, 10);
        Section sec2 = new Section("BSIT-1A", it, 1);
        Section sec3 = new Section("BSACC-1A", acc, 10);

        registrar.getSectionService().addSection(sec1);
        registrar.getSectionService().addSection(sec2);
        registrar.getSectionService().addSection(sec3);

        // 4. One-to-One Linking (Single Source of Truth)
        registrar.getDepartmentService().linkSectionToDept(sec1, ceas);
        registrar.getDepartmentService().linkSectionToDept(sec2, cite);
        registrar.getDepartmentService().linkSectionToDept(sec3, cbeam);
    }

}