package service;


import model.Remotly;
import model.constant.Subject;
import model.constant.Role;
import model.subject.Course;
import model.user.Student;
import service.implementation.user.SignInStrategyFactory;
import service.implementation.user.SignupStrategyFactory;
import service.implementation.user.StudentServiceImpl;
import service.implementation.user.StudentSignupStrategy;
import service.userServiceInterfaces.SignInStrategy;
import service.userServiceInterfaces.SignupStrategy;
import service.userServiceInterfaces.StudentService;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ApplicationServiceImpl implements ApplicationService {


    Scanner scanner = new Scanner(System.in);

    @Override
    public void startApplication() {

        System.out.println("Welcome to the application");
        System.out.println("please choose one of the following options:");

        int testCases = 3 ;
        while (testCases>0) {
            System.out.println("1- sign up   2- sign in    3- logout");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    signUp();
                    break;
                case 2:
                    signIN();
                    break;
                case 3:
                    System.out.println("logout");
                    return;
                default:
                    System.out.println("Invalid choice");
                    testCases--;
                    break;
            }
        }
        if (testCases ==0) {
            System.out.println("try again in another time");
        }

    }

    private void signIN() {
        System.out.println("Please select your role to sign up:");
        System.out.println("1. Student");
        System.out.println("2. Teacher");
        System.out.print("Choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        Role role = null;
        switch (choice) {
            case 1 -> role = Role.STUDENT;
            case 2 -> role = Role.TEACHER;
            default ->
            {
                System.out.println("Invalid choice");
                return;
            }
        }

        SignInStrategy signInStrategy = SignInStrategyFactory.getSignInStrategy(role);
        signInStrategy.signIn();


    }

    private void signUp() {
        System.out.println("Please select your role to sign up:");
        System.out.println("1. Student");
        System.out.println("2. Teacher");
        System.out.print("Choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        Role role = null;

        switch (choice) {
            case 1 -> role = Role.STUDENT;
            case 2 -> role = Role.TEACHER;
            default -> {
                System.out.println("Invalid choice");
                return;
            }
        }
        SignupStrategy signupStrategy = SignupStrategyFactory.getSignupStrategy(role);

        signupStrategy.signUp();

        // استخدام الطالب لو كان الدور هو Student
        if (signupStrategy instanceof StudentSignupStrategy studentStrategy) {
            Student student = studentStrategy.getLastRegisteredStudent();
            Map<Subject, List<Course>> courseMap = Remotly.getInstance().getSubjectSchoolMap();
            StudentService studentService = new StudentServiceImpl(student, courseMap);

            // يمكن الآن استخدام studentService لتسجيل مواد أو كورسات مثلاً
            System.out.println("✅ Welcome, " + student.getFirstName() + "! Your account is ready.");

            while (true) {
                System.out.println("Choose one of the following options:" +
                        "1- View all subjects " +
                        "2- View account details" +
                        "3- show subscribed courses" +
                        "4- show Available Courses In Subjects" +
                        "3- Log out");
                int choice1 = scanner.nextInt();
                scanner.nextLine();
                switch (choice1) {
                    case 1 -> {showAvailableCoursesInSubjects(studentService, student);
                    }
                    case 2 -> {studentService.showAccountDetails(student);}
                    case 3 ->{studentService.showSubscribedCourses();}



                    case 15 -> {
                        return;
                    }
                    default -> System.out.println("Invalid choice");
                }
            }
        }

    }

//    private void showAvailableCoursesInSubjects(StudentService studentService, Student student ) {
//        studentService.showAvailableSubjects();
//        System.out.println("Enter subject name:");
//        String subjectName = scanner.nextLine().trim().toUpperCase();
//
//        try {
//            Subject subject = Subject.valueOf(subjectName);
//            studentService.showAvailableCoursesInSubjects(student, subject);
//            System.out.println("choose " +
//                    "1- subscribe course" +
//                    "2- return");
//            int choice1 = scanner.nextInt();
//            scanner.nextLine();
//            switch (choice1) {
////                case 1 -> studentService.subscribeToCourse();
//                case 2 -> {
//                    return;
//                }
//                default -> System.out.println("Invalid choice");
//            }
//        } catch (IllegalArgumentException e) {
//            System.out.println("❌ Invalid subject name. Please try again.");
//        }
//    }


private void showAvailableCoursesInSubjects(StudentService studentService, Student student) {
    studentService.showAvailableSubjects();

    System.out.print("Enter subject name: ");
    String subjectName = scanner.nextLine().trim().toUpperCase();

    try {
        Subject subject = Subject.valueOf(subjectName);

        // الحصول على الكورسات المتاحة للمادة
        List<Course> availableCourses = studentService.getAvailableCoursesForSubject(student, subject);

        if (availableCourses == null || availableCourses.isEmpty()) {
            System.out.println("❌ No courses found for this subject.");
            return;
        }

        System.out.println("📚 Available Courses for Subject: " + subject.getArabicName() + " | Student: " + student.getFirstName() + " " + student.getLastName());

        for (int i = 0; i < availableCourses.size(); i++) {
            Course course = availableCourses.get(i);
            System.out.println((i + 1) + "- " + course.getName() + " (by " + course.getTeacherName() + ")");
        }

        System.out.println("""
            Choose:
            1- Subscribe to a course
            2- Return
        """);

        int choice1 = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice1) {
            case 1 -> {
                System.out.print("Enter course number to subscribe: ");
                int courseNumber = scanner.nextInt();
                scanner.nextLine();

                if (courseNumber < 1 || courseNumber > availableCourses.size()) {
                    System.out.println("❌ Invalid course number.");
                    return;
                }

                Course selectedCourse = availableCourses.get(courseNumber - 1);
                int result = studentService.subscribeToCourse(selectedCourse);

                if (result == 1) {
                    System.out.println("✅ Subscribed successfully to: " + selectedCourse.getName());
                } else {
                    System.out.println("❌ Subscription failed (maybe already subscribed?).");
                }
            }
            case 2 -> {
                return;
            }
            default -> System.out.println("❌ Invalid choice.");
        }

    } catch (IllegalArgumentException e) {
        System.out.println("❌ Invalid subject name. Please try again.");
    }
}


}
