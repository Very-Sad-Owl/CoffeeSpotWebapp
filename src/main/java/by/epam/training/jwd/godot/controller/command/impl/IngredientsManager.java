package by.epam.training.jwd.godot.controller.command.impl;

import by.epam.training.jwd.godot.controller.command.Command;
import by.epam.training.jwd.godot.service.CoffeeService;
import by.epam.training.jwd.godot.service.ServiceProvider;
import by.epam.training.jwd.godot.service.exception.ServiceException;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class IngredientsManager implements Command {

    private static final Logger LOGGER = Logger.getLogger(IngredientsManager.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        ServiceProvider provider = ServiceProvider.getInstance();
        CoffeeService service = provider.getCoffeeService();

        if (action.equals("delete")) {
            String toDelete = request.getParameter("id");
            if (toDelete != null) {
                try {
                    if (service.deleteIngredient(Integer.parseInt(toDelete))) {
                        response.getWriter().print("Successfully deleted");
                    } else {
                        response.getWriter().print("No rows were affected");
                    }
                } catch (ServiceException e) {
                    response.getWriter().print("No data was deleted due to bd error");
                }
            }
        } else if (action.equals("update")){
            LOGGER.info("update\n");
        }


    }
}
