package by.epam.training.jwd.godot.controller.command.impl;

import by.epam.training.jwd.godot.bean.RegistrationInfo;
import by.epam.training.jwd.godot.controller.command.Command;
import by.epam.training.jwd.godot.service.exception.ServiceException;
import by.epam.training.jwd.godot.service.ServiceProvider;
import by.epam.training.jwd.godot.service.UserService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Registration implements Command {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String email = request.getParameter("email");

		ServiceProvider provider = ServiceProvider.getInstance();
		UserService userService = provider.getUserService();

		try {
			userService.registration(new RegistrationInfo(login, password, email));
			response.sendRedirect("Controller?command=gotoindexpage&message=registered");
		} catch (ServiceException e) {
			response.sendRedirect(String.format("Controller?command=gotoregistrationpage&message=%s", e.getMessage()));
		}
		
	}

}
