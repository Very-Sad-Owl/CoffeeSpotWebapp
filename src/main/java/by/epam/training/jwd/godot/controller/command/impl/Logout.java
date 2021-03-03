package by.epam.training.jwd.godot.controller.command.impl;

import by.epam.training.jwd.godot.controller.command.Command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout implements Command {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		if(session != null) {
			session.removeAttribute("auth");
		}
		
		response.sendRedirect("Controller?command=gotoindexpage&message=logout");
		
	}

}
