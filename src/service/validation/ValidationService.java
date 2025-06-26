package service.validation;

import model.constant.Gender;
import model.constant.Role;

public interface ValidationService {

    boolean isValidName(String name);

    boolean isValidUsername(String userName);

    boolean isValidEmail(String email);

    boolean isValidPassword(String password);

    boolean isValidPhoneNumber(String phoneNumber);

    boolean isValidGender(Gender gender);

    boolean isValidRole(Role role);


 }
