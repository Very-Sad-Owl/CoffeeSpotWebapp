package by.epam.training.jwd.godot.controller.command.impl;

import by.epam.training.jwd.godot.bean.coffee.Coffee;
import by.epam.training.jwd.godot.controller.command.Command;
import by.epam.training.jwd.godot.controller.command.resource.CommandUrlPath;
import by.epam.training.jwd.godot.service.CoffeeService;
import by.epam.training.jwd.godot.service.ServiceProvider;
import by.epam.training.jwd.godot.service.exception.ServiceException;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoToIndexPage implements Command {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ServiceProvider provider = ServiceProvider.getInstance();
		CoffeeService service = provider.getCoffeeService();

		try {
			List<Coffee> allCoffee = service.getAllCoffee();
			request.setAttribute("coffee", allCoffee);
		} catch (ServiceException e) {
			//redirect to error page
		}

		RequestDispatcher requestDispatcher = request.getRequestDispatcher(CommandUrlPath.INDEXPAGE);
		requestDispatcher.forward(request, response);

	}

}
