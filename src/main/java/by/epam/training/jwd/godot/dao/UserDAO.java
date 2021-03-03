package by.epam.training.jwd.godot.dao;


import by.epam.training.jwd.godot.bean.RegistrationInfo;
import by.epam.training.jwd.godot.bean.User;
import by.epam.training.jwd.godot.bean.SignInInfo;
import by.epam.training.jwd.godot.dao.exception.DAOException;

public interface UserDAO {
	
	User authorization (SignInInfo info) throws DAOException;
	boolean	registration(RegistrationInfo info) throws DAOException;
	
}
