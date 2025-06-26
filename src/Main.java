import model.Remotly;
import model.constant.AcademicYear;
import model.constant.Gender;
import model.constant.Role;
import model.constant.Subject;
import model.subject.Course;
import model.user.Student;
import model.user.UserEntityFactory;
import service.ApplicationService;
import service.ApplicationServiceImpl;
import service.userServiceInterfaces.SignInStrategy;
import service.userServiceInterfaces.SignupStrategy;
import service.implementation.user.StudentSignInStrategy;
import service.implementation.user.TeacherSignInStrategy;
import service.implementation.user.StudentSignupStrategy;
import service.implementation.user.TeacherSignupStrategy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // ====== Create Additional Students ======

        Course[] courses = {
                new Course("Math Basics", 101, 8, 100,
                        "Ahmed Adel", AcademicYear.GRADE_1_PREPARATORY, Subject.MATHEMATICS),
                new Course("Introduction to Science", 102, 6, 90,
                        "Dr. Salma Hussein", AcademicYear.GRADE_1_PREPARATORY, Subject.SCIENCE),
                new Course("Arabic Grammar", 103, 7, 110,
                        "Mohamed Gamal", AcademicYear.GRADE_2_PREPARATORY, Subject.ARABIC),
                new Course("English Language Skills", 104, 8, 95,
                        "Mrs. Rana Youssef", AcademicYear.GRADE_3_PREPARATORY, Subject.ENGLISH),
                new Course("Social Studies", 105, 5, 85,
                        "Mr. Kareem ElSayed", AcademicYear.GRADE_2_PREPARATORY, Subject.SOCIAL_STUDIES)
        };

        for (Course course : courses) {
            Remotly.getInstance().getCourses().add(course);
        }



                Student[] students = {
//                (Student) UserEntityFactory.createUser(
//                        new Student.StudentBuilder("Karim", "Yasser",
//                                "Karim.Y", "S111@a", "karim.y@email.com", Gender.MALE),
//                        Role.STUDENT, AcademicYear.GRADE_1_PREPARATORY
//                ),
                (Student) UserEntityFactory.createUser(
                        new Student.StudentBuilder("Aya", "Nabil", "Aya.N", "S222#a", "aya.n@email.com", Gender.FEMALE),
                        Role.STUDENT, AcademicYear.GRADE_1_PREPARATORY
                ),
                (Student) UserEntityFactory.createUser(
                        new Student.StudentBuilder("Mostafa", "Ahmed", "Mostafa.A", "S333@b", "mostafa.a@email.com", Gender.MALE),
                        Role.STUDENT, AcademicYear.GRADE_1_PREPARATORY
                ),
                (Student) UserEntityFactory.createUser(
                        new Student.StudentBuilder("Nour", "Ashraf", "Nour.A", "1", "nour.a@email.com", Gender.FEMALE),
                        Role.STUDENT, AcademicYear.GRADE_1_PREPARATORY
                ),
                (Student) UserEntityFactory.createUser(
                        new Student.StudentBuilder("Hana", "Fathy", "Hana.F", "S555@d", "hana.f@email.com", Gender.FEMALE),
                        Role.STUDENT, AcademicYear.GRADE_1_PREPARATORY
                ),
                (Student) UserEntityFactory.createUser(
                        new Student.StudentBuilder("Adham", "Kamel", "Adham.K", "S666&a", "adham.k@email.com", Gender.MALE),
                        Role.STUDENT, AcademicYear.GRADE_1_PREPARATORY
                )
        };


// Add them to Remotly
        for (Student s : students) {
            Remotly.getInstance().addStudent(s);
        }


















        new ApplicationServiceImpl().startApplication();
    }
}

