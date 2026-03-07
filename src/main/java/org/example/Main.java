package org.example;

import org.example.model.Course;
import org.example.model.Student;
import org.example.service.CourseRegistration;
import org.example.service.StudentRegistration;

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
                    break;
            }
            System.out.println();
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
            System.out.print("Enter your choice: ");
        }
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
        }
    }
}