import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static StudentLinkedList studentList = new StudentLinkedList();
        int choice;

        do {
            displayMenu();

            choice = getIntInput("Enter your choice: ");

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    updateStudent();
                    break;

                case 3:
                    deleteStudent();
                    break;

                case 4:
                    studentList.displayAllStudents();
                    break;

                case 5:
                    searchStudent();
                    break;

                case 6:
                    System.out.println("\nExiting Student Record System...");
                    break;

                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }

        } while (choice != 6);

        scanner.close();
    }

    // ==============================
    // DISPLAY MENU
    // ==============================

    public static void displayMenu() {

        System.out.println("\n======================================");
        System.out.println("     UNIVERSITY STUDENT RECORD SYSTEM");
        System.out.println("======================================");
        System.out.println("1. Add Student");
        System.out.println("2. Update Student");
        System.out.println("3. Delete Student");
        System.out.println("4. Display All Students");
        System.out.println("5. Search Student");
        System.out.println("6. Exit");
        System.out.println("======================================");
    }

    // ==============================
    // ADD STUDENT
    // ==============================

    public static void addStudent() {

        System.out.println("\n========== ADD STUDENT ==========");

        int studentId = getIntInput("Enter Student ID: ");

        // Duplicate ID validation
        if (studentList.studentExists(studentId)) {

            System.out.println("Error: Student ID already exists.");

            return;
        }

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        while (name.trim().isEmpty()) {

            System.out.println("Name cannot be empty.");
            System.out.print("Enter Student Name: ");

            name = scanner.nextLine();
        }

        System.out.print("Enter Programme: ");
        String programme = scanner.nextLine();

        while (programme.trim().isEmpty()) {

            System.out.println("Programme cannot be empty.");
            System.out.print("Enter Programme: ");

            programme = scanner.nextLine();
        }

        double marks = getMarksInput();

        Student student = new Student(
                studentId,
                name,
                programme,
                marks
        );

        boolean added = studentList.addStudent(student);

        if (added) {

            System.out.println("\nStudent added successfully!");

        } else {

            System.out.println("\nFailed to add student.");
        }
    }

    // ==============================
    // UPDATE STUDENT
    // ==============================

    public static void updateStudent() {

        System.out.println("\n========== UPDATE STUDENT ==========");

        int studentId = getIntInput("Enter Student ID to update: ");

        Student existingStudent = studentList.searchStudent(studentId);

        if (existingStudent == null) {

            System.out.println("Error: Student not found.");

            return;
        }

        System.out.println("\nCurrent Student Details:");
        System.out.println(existingStudent);

        System.out.print("\nEnter New Name: ");
        String name = scanner.nextLine();

        while (name.trim().isEmpty()) {

            System.out.println("Name cannot be empty.");
            System.out.print("Enter New Name: ");

            name = scanner.nextLine();
        }

        System.out.print("Enter New Programme: ");
        String programme = scanner.nextLine();

        while (programme.trim().isEmpty()) {

            System.out.println("Programme cannot be empty.");
            System.out.print("Enter New Programme: ");

            programme = scanner.nextLine();
        }

        double marks = getMarksInput();

        boolean updated = studentList.updateStudent(
                studentId,
                name,
                programme,
                marks
        );

        if (updated) {

            System.out.println("\nStudent updated successfully!");

        } else {

            System.out.println("\nFailed to update student.");
        }
    }

    // ==============================
    // DELETE STUDENT
    // ==============================

    public static void deleteStudent() {

        System.out.println("\n========== DELETE STUDENT ==========");

        int studentId = getIntInput("Enter Student ID to delete: ");

        Student student = studentList.searchStudent(studentId);

        if (student == null) {

            System.out.println("Error: Student not found.");

            return;
        }

        System.out.println("\nStudent to be deleted:");
        System.out.println(student);

        System.out.print(
                "\nAre you sure you want to delete this student? (Y/N): "
        );

        String confirmation = scanner.nextLine();

        if (confirmation.equalsIgnoreCase("Y")) {

            boolean deleted = studentList.deleteStudent(studentId);

            if (deleted) {

                System.out.println("\nStudent deleted successfully!");

            } else {

                System.out.println("\nFailed to delete student.");
            }

        } else {

            System.out.println("\nDelete operation cancelled.");
        }
    }

    // ==============================
    // SEARCH STUDENT
    // ==============================

    public static void searchStudent() {

        System.out.println("\n========== SEARCH STUDENT ==========");

        int studentId = getIntInput("Enter Student ID: ");

        Student student = studentList.searchStudent(studentId);

        if (student == null) {

            System.out.println("\nStudent not found.");

        } else {

            System.out.println("\nStudent found!");
            System.out.println(student);
        }
    }

    // ==============================
    // INTEGER INPUT VALIDATION
    // ==============================

    public static int getIntInput(String message) {

        while (true) {

            System.out.print(message);

            String input = scanner.nextLine();

            try {

                return Integer.parseInt(input);

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid input. Please enter a valid number."
                );
            }
        }
    }

    // ==============================
    // MARKS INPUT VALIDATION
    // ==============================

    public static double getMarksInput() {

        while (true) {

            System.out.print("Enter Marks (0 - 100): ");

            String input = scanner.nextLine();

            try {

                double marks = Double.parseDouble(input);

                if (marks >= 0 && marks <= 100) {

                    return marks;

                } else {

                    System.out.println(
                            "Invalid marks. Marks must be between 0 and 100."
                    );
                }

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid input. Please enter a valid number."
                );
            }
        }
    }
}