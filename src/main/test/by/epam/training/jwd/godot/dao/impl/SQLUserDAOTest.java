package by.epam.training.jwd.godot.dao.impl;

import by.epam.training.jwd.godot.bean.SignInInfo;
import by.epam.training.jwd.godot.bean.RegistrationInfo;
import by.epam.training.jwd.godot.bean.User;
import by.epam.training.jwd.godot.dao.exception.DAOException;
import org.junit.Test;

import static org.junit.Assert.*;

public class SQLUserDAOTest {
    private SQLUserDAO dao = new SQLUserDAO();

    @Test
    public void existingUserLogin() throws DAOException {
        User user = dao.authorization(new SignInInfo("owl", "529123"));

        assertNotNull(user);
    }

    @Test
    public void insertUserTest() throws DAOException {
        boolean res = dao.registration(new RegistrationInfo("oleg", "720290", "oleg.gmail.com"));

        assertNotEquals(0, res);
    }

}