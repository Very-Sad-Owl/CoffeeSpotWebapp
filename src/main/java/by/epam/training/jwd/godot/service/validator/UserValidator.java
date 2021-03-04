package by.epam.training.jwd.godot.service.validator;

import by.epam.training.jwd.godot.service.validator.exception.InvalidSigningUuDataException;

public class UserValidator {
    private static final String LOGIN_PATTERN = "^.[^\\s\\W]{3,20}";
    private static final String PASSWORD_PATTERN = "^.{6,20}";
    private static final String EMAIL_PATTERN = "[\\w+\\-.]+@[a-z\\d\\-]+(\\.[a-z\\d\\-]+)*\\.[a-z]+";

    private UserValidator(){}

    public static void isLoginValid(String login) throws InvalidSigningUuDataException {
        if (login == null || !login.matches(LOGIN_PATTERN)){
            throw new InvalidSigningUuDataException("Invalid login");
        }
    }

    public static void isPasswordValid(String password) throws InvalidSigningUuDataException {
        if (password == null || !password.matches(PASSWORD_PATTERN)){
            throw new InvalidSigningUuDataException("Invalid password");
        }
    }

    public static void isEmailValid(String email) throws InvalidSigningUuDataException {
        if (email == null || !email.matches(EMAIL_PATTERN)){
            throw new InvalidSigningUuDataException("Invalid email");
        }
    }
}
