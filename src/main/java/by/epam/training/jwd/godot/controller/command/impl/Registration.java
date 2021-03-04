package by.epam.training.jwd.godot.controller.command.impl;

import by.epam.training.jwd.godot.bean.RegistrationInfo;
import by.epam.training.jwd.godot.controller.command.Command;
import by.epam.training.jwd.godot.service.exception.ServiceException;
import by.epam.training.jwd.godot.service.ServiceProvider;
import by.epam.training.jwd.godot.service.UserService;
import org.apache.log4j.Logger;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static by.epam.training.jwd.godot.controller.command.resource.CommandUrlPath.*;
import static by.epam.training.jwd.godot.controller.command.resource.CommandParam.*;
import static by.epam.training.jwd.godot.controller.command.resource.RequestParam.*;

public class Registration implements Command {

	private static final Logger LOGGER = Logger.getLogger(Registration.class);

	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String login = request.getParameter(LOGIN);
		String password = request.getParameter(PASSWORD);
		String email = request.getParameter(EMAIL);

		ServiceProvider provider = ServiceProvider.getInstance();
		UserService userService = provider.getUserService();

		try {
			userService.registration(new RegistrationInfo(login, password, email));
			response.sendRedirect(String.format(GOTOINDEXPAGE_WITH_MSG, REGISTRATION_SUCCESS));
			LOGGER.info("registered\n");
		} catch (ServiceException e) {
			response.sendRedirect(String.format(GOTOREGISTRATIONPAGE_WITH_MSG, e.getMessage()));
			LOGGER.info(e.getMessage());
			LOGGER.info(e.getStackTrace());
		}
		
	}

}
