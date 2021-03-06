package by.epam.training.jwd.godot.controller.command.impl;

import java.io.IOException;

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

import static by.epam.training.jwd.godot.controller.command.resource.CommandUrlPath.*;
import static by.epam.training.jwd.godot.controller.command.resource.CommandParam.*;
import static by.epam.training.jwd.godot.controller.command.resource.RequestParam.*;
import static by.epam.training.jwd.godot.controller.command.resource.SessionAttr.*;

public class SigningIn implements Command {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String login;
		String password;

		login = request.getParameter(LOGIN);
		password = request.getParameter(PASSWORD);

		ServiceProvider provider = ServiceProvider.getInstance();
		UserService userService = provider.getUserService();

		User user = null;
		try {
			user = userService.authorization(new SignInInfo(login, password));
			
			if (user == null) {
				response.sendRedirect(String.format(GOTOLOGINPAGE_WITH_MSG,NONEXISTING_USER));
				return;
			}

			if (user.getRoleId() == 3){
				HttpSession session = request.getSession(true);
				session.setAttribute(AUTHORIZATION, true);
				response.sendRedirect(GOTOADMINPAGE);
			} else if (user.getRoleId() == 2){
				HttpSession session = request.getSession(true);
				session.setAttribute(AUTHORIZATION, true);
				response.sendRedirect(GOTOINDEXPAGE);
			} else {
				HttpSession session = request.getSession(true);
				session.setAttribute(AUTHORIZATION, false);
				response.sendRedirect(GOTOINDEXPAGE);
			}

		} catch (ServiceException e) {
			response.sendRedirect(String.format(GOTOLOGINPAGE_WITH_MSG, e.getMessage()));
		}

	}

}
