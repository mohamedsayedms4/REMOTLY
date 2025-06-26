package service.implementation.user;

import model.constant.Message;
import service.userServiceInterfaces.SignInStrategy;
import service.validation.ValidationService;
import service.validation.implementation.ValidationServiceImpl;

import java.util.Scanner;

public abstract class AbstractSignInStrategy implements SignInStrategy {
    protected Scanner scanner = new Scanner(System.in);

    protected ValidationService valid = new ValidationServiceImpl();
    @Override
    public void signIn() {
        Message.enterUsername();
        String username = scanner.nextLine().trim();
        boolean isValidUserName = valid.isValidUsername(username);
        if(!isValidUserName) {
            Message.invalidUsername();
            return;
        }

        Message.enterPassword();
        String password = scanner.nextLine();
        boolean isValidPassword =  valid.isValidPassword(password);
        if(!isValidPassword) {
            Message.invalidPassword();
            return;
        }

        Object user = findUser(username, password);

        if (user != null) {
            onSuccess(user);
        } else {
            Message.userDoesNotExist();
        }
    }

    /**
     * Searches for a user in the appropriate user list.
     * Must be implemented by subclasses (e.g., Student, Teacher).
     *
     * @param username The username
     * @param password The password
     * @return The matched user object if found; otherwise null
     */
    protected abstract Object findUser(String username, String password);

    /**
     * Action to take if login succeeds.
     *
     * @param user The matched user object
     */
    protected abstract void onSuccess(Object user);
}
