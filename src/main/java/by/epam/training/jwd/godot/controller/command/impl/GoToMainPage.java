package by.epam.training.jwd.godot.controller.command.impl;

import by.epam.training.jwd.godot.bean.coffee.Coffee;
import by.epam.training.jwd.godot.bean.coffee.CoffeeSize;
import by.epam.training.jwd.godot.bean.coffee.CoffeeType;
import by.epam.training.jwd.godot.bean.coffee.Decoration;
import by.epam.training.jwd.godot.controller.command.Command;
import by.epam.training.jwd.godot.controller.command.resource.CommandUrlPath;
import by.epam.training.jwd.godot.service.CoffeeService;
import by.epam.training.jwd.godot.service.ServiceProvider;
import by.epam.training.jwd.godot.service.exception.ServiceException;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoToMainPage implements Command {

	private static final Logger LOGGER = Logger.getLogger(GoToMainPage.class);

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ServiceProvider provider = ServiceProvider.getInstance();
		CoffeeService service = provider.getCoffeeService();

		try {
			List<Coffee> allCoffee = service.getAllCoffee();
			request.setAttribute("coffee", allCoffee);
			LOGGER.info("retrieved: " + allCoffee.size() + "\n");

			String orderedType = request.getParameter("toOrder");
			String decorId = request.getParameter("addDecor");
			if (orderedType != null){
				Coffee chosen = allCoffee.get(Integer.parseInt(orderedType));
				List<CoffeeSize> sizes = service.getSizes(chosen.getType());
				request.setAttribute("sizes", sizes);
				request.setAttribute("chosen", chosen);
				LOGGER.info(orderedType + " - chosen\n");

				List<Decoration> allDecorators = service.getDecorators();
				request.setAttribute("decoration", allDecorators);
				LOGGER.info("retrieved decors: " + allDecorators.size() + "\n");
				LOGGER.info("retrieved sizes: " + sizes.size() + "\n");

				if(decorId != null){
					LOGGER.info("ajax пашет\n");
					PrintWriter out = response.getWriter();
					out.print("hey boi");
				}
			}
		} catch (ServiceException e) {
			//redirect to error page
		}


		RequestDispatcher requestDispatcher = request.getRequestDispatcher(CommandUrlPath.MAINPAGE);
		requestDispatcher.forward(request, response);

	}

}
