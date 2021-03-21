package by.epam.training.jwd.godot.controller.command.impl;

import by.epam.training.jwd.godot.bean.IngredientType;
import by.epam.training.jwd.godot.bean.SeasonType;
import by.epam.training.jwd.godot.bean.coffee.Ingredient;
import by.epam.training.jwd.godot.controller.command.Command;
import by.epam.training.jwd.godot.service.CoffeeService;
import by.epam.training.jwd.godot.service.ServiceProvider;
import by.epam.training.jwd.godot.service.exception.ServiceException;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.epam.training.jwd.godot.controller.command.resource.RequestParam.*;

public class IngredientsManager implements Command {

    private static final Logger LOGGER = Logger.getLogger(IngredientsManager.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter(ACTION);
        ServiceProvider provider = ServiceProvider.getInstance();
        CoffeeService service = provider.getCoffeeService();

        if (action.equals(DELETE_ACTION)) {
            String toDelete = request.getParameter(INGREDIENT_TITLE);
            if (toDelete != null) {
                try {
                    if (service.deleteIngredient(toDelete)) {
                        response.getWriter().print("Successfully deleted");
                    } else {
                        response.getWriter().print("No rows were affected");
                    }
                } catch (ServiceException e) {
                    response.getWriter().print("No data was deleted due to bd error");
                }
            }
            //response.sendRedirect("Controller?command=gotomanageingredientspage");
        } else if (action.equals(UPDATE_ACTION)){
            LOGGER.info("update\n");
            String title = request.getParameter("title");
            String iType = request.getParameter("ingr_type");
            String sType = request.getParameter("season_type");
            double price = Double.parseDouble(request.getParameter("price"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            String img = request.getParameter("img");
            String origTitle = request.getParameter("orig_title");

            try {
                service.updateIngredient(new Ingredient(title, quantity, price,
                        IngredientType.valueOf(iType.toUpperCase()), img,
                        SeasonType.valueOf(sType.toUpperCase())), origTitle);
                response.getWriter().print("Successfully updated");
                LOGGER.info("ingredient update performed");
            } catch (ServiceException e) {
                LOGGER.warn("ingredient hasn't been updated!\n");
                response.getWriter().print("Ingredient hasn't been updated!");
            }
        } else if (action.equals("add")){
            LOGGER.info("add\n");
            String title = request.getParameter("title");
            String iType = request.getParameter("ingr_type");
            String sType = request.getParameter("season_type");
            double price = Double.parseDouble(request.getParameter("price"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            String img = request.getParameter("img");
            LOGGER.info(title);
            try {
                service.addIngredient(new Ingredient(title, quantity, price,
                        IngredientType.valueOf(iType.toUpperCase()), img,
                        SeasonType.valueOf(sType.toUpperCase())));
                response.getWriter().print("Successfully added");
                LOGGER.info("ingredient insert performed");
            } catch (ServiceException e) {
                LOGGER.warn("ingredient hasn't been added!\n");
                response.getWriter().print("Ingredient hasn't been added!");
            }
        }
        response.getWriter().flush();
        response.getWriter().close();
    }
}
