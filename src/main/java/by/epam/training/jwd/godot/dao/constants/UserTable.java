package by.epam.training.jwd.godot.dao.constants;

public interface UserTable {

    String TABLE_NAME = "users";
    String ID_COL = "id";
    String LOGIN_COL = "login";
    String PASSWORD_COL = "password";
    String EMAIL_COL = "email";
    String BALANCE_COL = "balance";
    String ROLE_COL = "role_id";
    int GUEST_ROLE_ID = 1;
    int USER_ROLE_ID = 2;
    int ADMIN_ROLE_ID = 3;

}
