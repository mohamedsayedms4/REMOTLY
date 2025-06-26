package service.implementation.user;

import model.Remotly;
import model.constant.AcademicYear;
import model.constant.Gender;
import model.constant.Role;
import model.user.Student;
import model.user.UserEntityFactory;

public class StudentSignupStrategy extends SignupStrategyImpl{


    private Student lastStudent;


    @Override
    protected void buildAndSave(String firstName, String lastName, String username,
                                String password, String email, Gender gender) {
        System.out.print("Academic Year (e.g., GRADE_1_PREPARATORY): ");
        AcademicYear year = AcademicYear.valueOf(scanner.nextLine().trim().toUpperCase());

        Student student = (Student) UserEntityFactory.createUser(
                new Student.StudentBuilder(firstName, lastName, username, password, email, gender),
                Role.STUDENT,
                year
        );

        Remotly.getInstance().addStudent(student);
        this.lastStudent = student;

        System.out.println("✅ Student registered successfully: " + student.getUserName());
    }

    /**
     * Returns the last student who was registered using this strategy.
     *
     * @return the last registered Student
     */
    public Student getLastRegisteredStudent() {
        return this.lastStudent;
    }
}
