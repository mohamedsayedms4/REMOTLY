package service.implementation.user;

import model.Remotly;
import model.user.Student;
import service.userServiceInterfaces.SignInStrategy;

public class StudentSignInStrategy extends AbstractSignInStrategy {

    @Override
    protected Object findUser(String username, String password) {
        for(Student student : Remotly.getInstance().getStudents()) {
            if(student.getUserName().equals(username) && student.getPassword().equals(password)) {
                return student;
            }
        }
        return null;
    }

    @Override
    protected void onSuccess(Object user) {
        Student student = (Student) user;
        System.out.println("✅ Logged in successfully as Student: " + student.getFullName());
    }
}
