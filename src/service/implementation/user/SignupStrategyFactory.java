package service.implementation.user;

import model.constant.Role;
import service.userServiceInterfaces.SignupStrategy;

public class SignupStrategyFactory {

    public static SignupStrategy getSignupStrategy(Role role) {
        return switch (role) {
            case STUDENT -> new StudentSignupStrategy();
            case TEACHER -> new TeacherSignupStrategy();
            default -> throw new IllegalArgumentException("Unsupported role for signup: " + role);
        };
    }
}
