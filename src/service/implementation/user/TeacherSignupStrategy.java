package service.implementation.user;

import model.*;
import model.constant.*;
import model.user.*;
import service.implementation.user.SignupStrategyImpl;

public class TeacherSignupStrategy extends SignupStrategyImpl {

    @Override
    protected void buildAndSave(String firstName, String lastName, String username,
                                String password, String email, Gender gender) {
        System.out.print("School ID: ");
        int schoolId = Integer.parseInt(scanner.nextLine());

        System.out.print("Subject Name: ");
        String subjectName = scanner.nextLine();

        Teacher.TeacherBuilder builder = new Teacher.TeacherBuilder(firstName, lastName, username, password, email, gender)
                .setSchool(schoolId)
                .setSubjectName(subjectName);

        Teacher teacher = (Teacher) UserEntityFactory.createUser(builder, Role.TEACHER);

        Remotly.getInstance().addTeacher(teacher);
        System.out.println("✅ Teacher registered successfully: " + teacher.getUserName());
    }
}
