package by.epam.training.jwd.godot.controller.command.impl;

import by.epam.training.jwd.godot.controller.command.Command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoToRegistrationPage implements Command {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/registration.jsp");
		requestDispatcher.forward(request, response);
		
	}

}
