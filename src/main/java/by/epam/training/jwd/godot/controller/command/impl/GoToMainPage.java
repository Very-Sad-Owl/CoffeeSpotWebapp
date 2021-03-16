package by.epam.training.jwd.godot.controller.command.impl;

import by.epam.training.jwd.godot.bean.coffee.Coffee;
import by.epam.training.jwd.godot.bean.coffee.CoffeeSize;
import by.epam.training.jwd.godot.bean.coffee.Decoration;
import by.epam.training.jwd.godot.controller.command.Command;
import by.epam.training.jwd.godot.controller.command.resource.CommandUrlPath;
import by.epam.training.jwd.godot.service.CoffeeService;
import by.epam.training.jwd.godot.service.ServiceProvider;
import by.epam.training.jwd.godot.service.exception.ServiceException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoToMainPage implements Command {

	private Coffee chosen = null;

	private static final Logger LOGGER = Logger.getLogger(GoToMainPage.class);

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ServiceProvider provider = ServiceProvider.getInstance();
		CoffeeService service = provider.getCoffeeService();
		ObjectMapper mapper = new ObjectMapper();

		try {
			List<Coffee> allCoffee = service.getAllCoffee();
			request.setAttribute("coffee", allCoffee);
			LOGGER.info("retrieved: " + allCoffee.size() + "\n");

			String chosenPos = request.getParameter("toOrder");
			String action = request.getParameter("action");
			String posId = request.getParameter("id");
			if (chosenPos != null){
				if (chosen == null){
					chosen = allCoffee.get(Integer.parseInt(chosenPos));
				}
				//Coffee chosen = allCoffee.get(Integer.parseInt(chosenPos));
				List<CoffeeSize> sizes = service.getSizes(chosen.getType());
				List<Decoration> allDecorators = service.getDecorators();
				request.setAttribute("sizes", sizes);
				request.setAttribute("chosen", chosen);
				request.setAttribute("decoration", allDecorators);

				if(action != null){
					LOGGER.info("action");
					if (action.equals("addDecor")) {
						LOGGER.info("not updated coffee " + chosen + "\n");
						chosen.addDecoration(allDecorators.get(Integer.parseInt(posId)));
					} else if (action.equals("removeDecor")){
						LOGGER.info("not updated coffee " + chosen + "\n");
						chosen.removeDecoration(allDecorators.get(Integer.parseInt(posId)));
					}
					chosen.calculateCoast();
					LOGGER.info("updated coffee " + chosen + "\n");
					mapper.writeValue(response.getOutputStream(), chosen);
				}
			}
		} catch (ServiceException e) {
			//redirect to error page
		}


		RequestDispatcher requestDispatcher = request.getRequestDispatcher(CommandUrlPath.MAINPAGE);
		requestDispatcher.forward(request, response);

	}

}
