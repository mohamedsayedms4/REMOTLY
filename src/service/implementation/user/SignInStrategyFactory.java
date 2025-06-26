package service.implementation.user;

import model.constant.Role;
import service.userServiceInterfaces.SignInStrategy;

import static model.constant.Role.STUDENT;
import static model.constant.Role.TEACHER;

public class SignInStrategyFactory {
    public static SignInStrategy getSignInStrategy(Role role) {
        return switch (role) {
            case STUDENT -> new StudentSignInStrategy();
            case TEACHER -> new TeacherSignInStrategy();
            default -> throw new IllegalArgumentException("❌ Unsupported role: " + role);
        };
    }
}
