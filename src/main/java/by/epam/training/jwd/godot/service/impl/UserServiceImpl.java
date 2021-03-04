package by.epam.training.jwd.godot.service.impl;

import by.epam.training.jwd.godot.bean.RegistrationInfo;
import by.epam.training.jwd.godot.bean.User;
import by.epam.training.jwd.godot.bean.SignInInfo;
import by.epam.training.jwd.godot.dao.exception.DAOException;
import by.epam.training.jwd.godot.dao.DAOProvider;
import by.epam.training.jwd.godot.dao.UserDAO;
import by.epam.training.jwd.godot.service.exception.ServiceException;
import by.epam.training.jwd.godot.service.UserService;
import by.epam.training.jwd.godot.service.validator.UserValidator;
import by.epam.training.jwd.godot.service.validator.exception.InvalidSigningUuDataException;

public class UserServiceImpl implements UserService {

	public User authorization(SignInInfo info) throws ServiceException {

		DAOProvider provider = DAOProvider.getInstance();
        UserDAO userDAO = provider.getUserdao();
        
		User user;
		try {
			user = userDAO.authorization(info);
		}catch(DAOException e) {
			throw new ServiceException("Signing in error.", e);
		}
		return user;
	}

	@Override
	public boolean registration(RegistrationInfo regInfo) throws ServiceException {

		try {
			UserValidator.isLoginValid(regInfo.getLogin());
			UserValidator.isPasswordValid(regInfo.getPassword());
			UserValidator.isEmailValid(regInfo.getEmail());
		} catch (InvalidSigningUuDataException e) {
			throw new ServiceException(e.getMessage());
		}

		DAOProvider provider = DAOProvider.getInstance();
		UserDAO userDAO = provider.getUserdao();

		try {
			userDAO.registration(regInfo);
		} catch (DAOException e) {
			throw new ServiceException("Registration failed. Please, try again later.");
		}

		return true;
	}

}
