package service.implementation.user;

import model.constant.Gender;
import model.constant.Message;
import service.userServiceInterfaces.SignupStrategy;
import service.validation.ValidationService;
import service.validation.implementation.ValidationServiceImpl;

import java.util.Scanner;

public abstract class SignupStrategyImpl implements SignupStrategy {
    protected Scanner scanner = new Scanner(System.in);
    protected ValidationService valid = new ValidationServiceImpl();

    @Override
    public void signUp() {
        Message.enterFirstName();
        String firstName = scanner.nextLine();
        boolean isValidName = valid.isValidName(firstName);
        if (!isValidName) {
            Message.invalidUsername();
            return;
        }

        Message.enterLastName();
        String lastName = scanner.nextLine();
        if (!isValidName) {
        Message.invalidLastName();
            return;
        }

        Message.enterUsername();
        String username = scanner.nextLine();
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

        System.out.print("Email: ");
        String email = scanner.nextLine();
        boolean isValidEmail = valid.isValidEmail(email);
        if(!isValidEmail) {
            System.out.println("Invalid email");
            return;
        }

        System.out.print("Gender (MALE/FEMALE): ");
        Gender gender = Gender.valueOf(scanner.nextLine().trim().toUpperCase());
        boolean isValidGender = valid.isValidGender(gender);
        if(!isValidGender) {
            System.out.println("Invalid gender");
            return;
        }

        buildAndSave(firstName, lastName, username, password, email, gender);
    }

    protected abstract void buildAndSave(String firstName, String lastName, String username,
                                         String password, String email, Gender gender);

}
