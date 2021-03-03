package by.epam.training.jwd.godot.service;

import by.epam.training.jwd.godot.bean.RegistrationInfo;
import by.epam.training.jwd.godot.bean.User;
import by.epam.training.jwd.godot.bean.SignInInfo;
import by.epam.training.jwd.godot.service.exception.ServiceException;

public interface UserService {
	User authorization(SignInInfo logInfo) throws ServiceException;
	boolean registration(RegistrationInfo regInfo) throws ServiceException;
}
