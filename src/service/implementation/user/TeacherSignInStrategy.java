package service.implementation.user;

import model.Remotly;
import model.user.Teacher;

public class TeacherSignInStrategy extends AbstractSignInStrategy{
    @Override
    protected Object findUser(String username, String password) {
        for (Teacher teacher : Remotly.getInstance().getTeachers()){
            if (teacher.getUserName().equals(username) && teacher.getPassword().equals(password)){
                return teacher;
            }
        }
        return null;
    }

    @Override
    protected void onSuccess(Object user) {
        Teacher teacher = (Teacher) user;
        System.out.println("✅ Logged in successfully as Teacher: " + teacher.getFullName());
    }
}
