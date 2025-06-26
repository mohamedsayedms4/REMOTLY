package service.validation.implementation;

import model.constant.Gender;
import model.constant.Role;
import service.validation.ValidationService;

public class ValidationServiceImpl implements ValidationService {

    /**
     * Validates whether the given name is acceptable.
     * A valid name must meet the following criteria:

     *     Not null
     *     Trimmed length must be at least 3 characters
     *     Must only contain letters (Arabic or English) and spaces

     *
     * If any unexpected exception occurs during validation, the method catches it
     * and returns false safely without crashing the program.
     *
     * @param name The name string to validate
     * @return {@code true} if the name is valid; {@code false} otherwise
     */
    @Override
    public boolean isValidName(String name) {
        try {
            if (name == null) return false;

            String trimmed = name.trim();
            return trimmed.length() >= 3 && trimmed.matches("[a-zA-Zأ-ي\\s]+");
        } catch (Exception e) {
            System.err.println("❌ Error validating name: " + e.getMessage());
            return false;
        }
    }

    /**
     * Checks if the username is valid:
     * - length >= 3
     * - starts with an uppercase letter
     * @param userName the username to validate
     * @return true if valid, false otherwise
     */
    @Override
    public boolean isValidUsername(String userName) {
        return userName.length() >= 3
                && Character.isUpperCase(userName.charAt(0));    }

    /**
     * Validates whether the given email address is in a proper format.
     *
     * A valid email must:
     *
     *     Not be null or blank
     *     Match standard email format (e.g., name@example.com)
     *
     *
     * The method safely handles any unexpected exception and returns {@code false} if validation fails.
     *
     * @param email The email string to validate
     * @return {@code true} if the email is in valid format; {@code false} otherwise
     */
    @Override
    public boolean isValidEmail(String email) {
        try {
            if (email == null || email.trim().isEmpty()) return false;

            String trimmed = email.trim();
            String emailRegex = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";

            return trimmed.matches(emailRegex);
        } catch (Exception e) {
            System.err.println("❌ Error validating email: " + e.getMessage());
            return false;
        }
    }


    /**
     * Validates the password according to these rules:
     * - at least 6 characters
     * - contains at least one uppercase letter
     * - contains at least one lowercase letter
     * - contains at least one digit
     * - contains at least one special character from #$@&
     * @param password the password to validate
     * @return true if valid, false otherwise
     */
    @Override
    public boolean isValidPassword(String password) {
        if (password == null || password.length() < 6) {
            return false;
        }

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                hasUpper = true;
            } else if (Character.isLowerCase(ch)) {
                hasLower = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            } else if ("#$@&".indexOf(ch) >= 0) {
                hasSpecial = true;
            }
        }
        return hasUpper && hasLower && hasDigit && hasSpecial;
    }

    /**
     * Validates whether the given phone number is a valid Egyptian mobile number.
     * <p>
     * A valid Egyptian phone number must:

     *     Be exactly 11 digits long<
     *     Start with one of the allowed prefixes: 010, 011, 012, or 015
     *     Contain only numeric characters

     *
     * If the phone number is null, empty, or invalid, the method returns {@code false}.
     *
     * @param phoneNumber The phone number to validate
     * @return {@code true} if the phone number is a valid Egyptian mobile number, {@code false} otherwise
     */
    @Override
    public boolean isValidPhoneNumber(String phoneNumber) {
        try {
            if (phoneNumber == null || phoneNumber.trim().isEmpty()) return false;

            String trimmed = phoneNumber.trim();

            // Regex: starts with 010, 011, 012, 015 + 8 digits = 11 total
            String egyptianMobileRegex = "^(010|011|012|015)[0-9]{8}$";

            return trimmed.matches(egyptianMobileRegex);
        } catch (Exception e) {
            System.err.println("❌ Error validating phone number: " + e.getMessage());
            return false;
        }
    }


    /**
     * Validates whether the provided gender value is not null and belongs to the defined Gender enum.
     * This method ensures that the gender is explicitly set (either MALE or FEMALE)
     * and avoids null references or uninitialized values.
     *
     * @param gender The gender value to validate
     * @return {@code true} if the gender is not null; {@code false} otherwise
     */
    @Override
    public boolean isValidGender(Gender gender) {
        try {
            return gender != null;
        } catch (Exception e) {
            System.err.println("❌ Error validating gender: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean isValidRole(Role role){
        try {
            return role != null;
        }catch (Exception e){
            System.err.println("❌Error validating role: " + e.getMessage());
            return false;
        }
    }

}
