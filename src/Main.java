package model;

import service.implementation.StudentServiceImpl;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please select user type:");
        System.out.println("1 - Student");
        System.out.println("2 - Teacher");

        int type = scanner.nextInt();

        if (type == 1) {
            // ====== Choose Stage ======
            System.out.println("Select your stage:");
            System.out.println("1 - Primary");
            System.out.println("2 - Preparatory");
            System.out.println("3 - Secondary");

            Stage stage = null;
            AcademicYear academicYear = null;

            int stageChoice = scanner.nextInt();
            switch (stageChoice) {
                case 1 -> stage = Stage.PRIMARY;
                case 2 -> stage = Stage.PREPARATORY;
                case 3 -> stage = Stage.SECONDARY;
                default -> {
                    System.out.println("Invalid stage");
                    return;
                }
            }

            // ====== Choose Academic Year in selected stage ======
            AcademicYear[] years = AcademicYear.values();
            System.out.println("Choose your academic year:");
            for (int i = 0; i < years.length; i++) {
                if (years[i].getStage() == stage) {
                    System.out.println((i + 1) + " - " + years[i].getDisplayName());
                }
            }

            int yearIndex = scanner.nextInt() - 1;
            if (yearIndex < 0 || yearIndex >= years.length || years[yearIndex].getStage() != stage) {
                System.out.println("Invalid academic year selection.");
                return;
            }
            academicYear = years[yearIndex];

            // ====== Collect Student Info ======
            System.out.print("First Name: ");
            String firstName = scanner.next();

            System.out.print("Last Name: ");
            String lastName = scanner.next();

            System.out.print("Username: ");
            String userName = scanner.next();

            System.out.print("Email: ");
            String email = scanner.next();

            System.out.print("Password: ");
            String password = scanner.next();

            System.out.print("Gender: ");
            String gender = scanner.next();

            // ====== Create Student ======
            Student.StudentBuilder studentBuilder = new Student.StudentBuilder(
                    firstName, lastName, userName, password, email, gender
            );

            Student student = (Student) UserEntityFactory.createUser(
                    studentBuilder, Role.STUDENT, academicYear
            );

            System.out.println("\n✅ Student created successfully!");
            System.out.println("Full Name: " + student.getFullName());
            System.out.println("Academic Year: " + academicYear.getDisplayName());

            // ====== Show available subjects ======
            StudentServiceImpl studentService = new StudentServiceImpl(student);
            List<Subject> availableSubjects = studentService.getAvailableSubjectsToEnroll();

            if (availableSubjects.isEmpty()) {
                System.out.println("❗ No available subjects to enroll in.");
            } else {
                System.out.println("\nAvailable subjects to enroll:");
                for (int i = 0; i < availableSubjects.size(); i++) {
                    System.out.println((i + 1) + " - " + availableSubjects.get(i).getArabicName());
                }

                // ====== Optional: Ask user to enroll in a subject ======
                System.out.print("\nEnter subject number to enroll (or 0 to skip): ");
                int subjectChoice = scanner.nextInt();
                if (subjectChoice > 0 && subjectChoice <= availableSubjects.size()) {
                    Subject selectedSubject = availableSubjects.get(subjectChoice - 1);
                    studentService.enrollInSubject(selectedSubject);
                } else {
                    System.out.println("No enrollment performed.");
                }
            }

        } else if (type == 2) {
            System.out.println("🔧 Teacher creation not implemented yet.");
        } else {
            System.out.println("❌ Invalid selection.");
        }
    }
}
