package by.epam.training.jwd.godot.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.epam.training.jwd.godot.bean.SignInInfo;
import by.epam.training.jwd.godot.bean.User;
import by.epam.training.jwd.godot.controller.command.Command;
import by.epam.training.jwd.godot.service.exception.ServiceException;
import by.epam.training.jwd.godot.service.ServiceProvider;
import by.epam.training.jwd.godot.service.UserService;

public class SigningIn implements Command {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String login;
		String password;

		login = request.getParameter("login");
		password = request.getParameter("password");

		ServiceProvider provider = ServiceProvider.getInstance();
		UserService userService = provider.getUserService();

		User user = null;
		RequestDispatcher requestDispatcher = null;
		try {
			user = userService.authorization(new SignInInfo(login, password));
			
			if (user == null) {

				response.sendRedirect("Controller?command=gotologinationpage&message=nosuchuser");
				return;
			}

			HttpSession session = request.getSession(true);
			session.setAttribute("auth", true);
			response.sendRedirect("Controller?command=gotoindexpage");

		} catch (ServiceException e) {
			response.sendRedirect("Controller?command=gotoindexpage&message=servicefail");
		}

	}

}
