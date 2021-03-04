package by.epam.training.jwd.godot.service.validator;

public class UserValidator {
    private static final String LOGIN_PATTERN = "^.[^\\s\\W]{3,20}";
    private static final String PASSWORD_PATTERN = "^.{6,20}";
    private static final String EMAIL_PATTERN = "[\\w+\\-.]+@[a-z\\d\\-]+(\\.[a-z\\d\\-]+)*\\.[a-z]+";

    private UserValidator(){}

    public static boolean isLoginValid(String login){
        return login != null && login.matches(LOGIN_PATTERN);
    }

    public static boolean isPasswordValid(String password){
        return password != null && password.matches(PASSWORD_PATTERN);
    }

    public static boolean isEmailValid(String email){
        return email != null && email.matches(EMAIL_PATTERN);
    }
}
