# Interface-Driven Enrollment System
## Inteprog Final Project

---

Author: Keziah Fatima Bianca So

## Project Overview
This is a comprehensive, console-based enrollment system designed with a service-oriented architecture. The system handles complex relationships among departments, courses, sections, instructors, and students while maintaining high data integrity and robust business logic with a clear separation of concerns.

## Key Features
* **Multi-Level Institutional Hierarchy:** Visualizes a real-world academic structure mapping from department to section, instructor, and enrolled students.
* **Dynamic Tuition Management:** Automatically calculates tuition fees based on course units and manages real-time payment processing.
* **Reference-Based Persistence:** Implements object referencing, ensuring that updates to a student record reflect instantly across all enrolled sections.
* **System Validation:**
    * **Capacity Guard:** Prevents enrollment in full sections using custom exception handling (SectionFullException).
    * **Input Protection:** Utilizes exception handling to manage invalid user inputs and prevent system failure.

## Advanced Feature: Scholarship Discount Logic
To enhance the financial module, a scholarship discount system was implemented.
* **Logic:** The system evaluates student profiles and applies a percentage-based discount to the total tuition before final billing.
* **Impact:** This demonstrates advanced business logic by modifying the tuition service interface to handle conditional calculations based on student data rather than a flat rate.

## Quality Assurance (JUnit 5)
The project includes automated unit tests utilizing the Arrange, Act, Assert (AAA) pattern to verify system reliability:
* **Scholarship Logic Test:** Verifies that discounts are applied correctly to the balance.
* **Capacity Rule:** Confirms students are rejected when a section reaches its maximum limit.
* **CRUD Consistency:** Ensures object updates reflect globally across the system.
* **Data Integrity:** Prevents duplicate student IDs to avoid database corruption.
* **Payment Logic:** Validates that balances update correctly and process overpayments accurately.

## Object-Oriented Programming Principles Applied
* **Encapsulation:** Utilizes private fields with controlled access via getter and setter methods.
* **Inheritance:** The Student and Instructor classes extend the Person base class.
* **Abstraction:** Implemented through the Person abstract class and service interfaces.
* **Polymorphism:** The campus registrar interacts with service interfaces, allowing the system to substitute logic implementations without altering the controller.