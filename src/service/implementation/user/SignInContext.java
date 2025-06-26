package service.implementation.user;

import service.userServiceInterfaces.SignInStrategy;

public class SignInContext {
    private SignInStrategy strategy;

    public void setStrategy(SignInStrategy strategy) {
        this.strategy = strategy;
    }

    public void execute() {
        if (strategy != null) {
            strategy.signIn();
        } else {
            System.out.println("⚠️ No logi n strategy defined.");
        }
    }
}
