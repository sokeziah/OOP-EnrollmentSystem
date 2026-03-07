package org.example;

import org.example.model.Course;
import org.example.model.Student;
import org.example.service.StudentRegistration;
import org.example.service.CourseRegistration;

import java.util.Scanner;

public class Main {

    private static final StudentRegistration studentService = new StudentRegistration();
    private static final CourseRegistration courseService = new CourseRegistration();
    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        int choice;
        do {
            displayMainMenu();
            choice = getUserChoice();

            switch (choice) {
                case 1:
                    studentMenu();
                    break;
                case 2:
                    courseMenu();
                    break;
                case 0:
                    System.out.println("Exiting application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 0);

        scanner.close();
    }

    private static void displayMainMenu() {
        System.out.println("===== MAIN MENU =====");
        System.out.println("[1] Student Management");
        System.out.println("[2] Course Management");
        System.out.println("[0] Exit");
        System.out.println("=====================");
    }

    private static int getUserChoice() {
        System.out.print("Enter your choice: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
        }
        int choice = scanner.nextInt();
        scanner.nextLine();

        return choice;
        }

    private static void studentMenu() {

        int choice;

        do {

            System.out.println("\n===== STUDENT MENU =====");
            System.out.println("[1] Register Student");
            System.out.println("[2] View All Students");
            System.out.println("[3] Find Student by ID");
            System.out.println("[4] Delete Student");
            System.out.println("[0] Back");
            System.out.println("========================");

            choice = getUserChoice();

            switch (choice) {

                case 1:
                    registerStudent();
                    break;

                case 2:
                    studentService.displayAllStudent();
                    break;

                case 3:
                    findStudent();
                    break;

                case 4:
                    deleteStudent();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }

    private static void registerStudent() {

        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Program: ");
        String program = scanner.nextLine();

        Student student = new Student();
        student.setPersonID(id);
        student.setPersonName(name);
        student.setProgram(program);

        studentService.saveStudent(student);

        System.out.println("Student registered successfully.");
    }

    private static void findStudent() {

        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();

        Student s = studentService.findStudentById(id);

        if (s != null) {
            s.display();
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void deleteStudent() {

        System.out.print("Enter Student ID to delete: ");
        String id = scanner.nextLine();

        Student s = studentService.findStudentById(id);

        if (s != null) {
            studentService.removeStudent(s);
            System.out.println("Student removed.");
        } else {
            System.out.println("Student not found.");
        }
    }

    // ================= COURSE MENU =================

    private static void courseMenu() {

        int choice;

        do {

            System.out.println("\n===== COURSE MENU =====");
            System.out.println("[1] Add Course");
            System.out.println("[2] View All Courses");
            System.out.println("[3] Find Course by ID");
            System.out.println("[4] Delete Course");
            System.out.println("[0] Back");
            System.out.println("=======================");

            choice = getUserChoice();

            switch (choice) {

                case 1:
                    addCourse();
                    break;

                case 2:
                    courseService.displayAllCourse();
                    break;

                case 3:
                    findCourse();
                    break;

                case 4:
                    deleteCourse();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }

    private static void addCourse() {

        System.out.print("Enter Course ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter Course Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Program: ");
        String program = scanner.nextLine();

        Course course = new Course(id, name, program);

        courseService.saveCourse(course);

        System.out.println("Course added successfully.");
    }

    private static void findCourse() {

        System.out.print("Enter Course ID: ");
        String id = scanner.nextLine();

        Course c = courseService.findCourseByID(id);

        if (c != null) {
            c.display();
        } else {
            System.out.println("Course not found.");
        }
    }

    private static void deleteCourse() {

        System.out.print("Enter Course ID to delete: ");
        String id = scanner.nextLine();

        Course c = courseService.findCourseByID(id);

        if (c != null) {
            courseService.removeCourse(c);
            System.out.println("Course removed.");
        } else {
            System.out.println("Course not found.");
        }
    }
}