package by.epam.training.jwd.godot.controller.command.impl;

import by.epam.training.jwd.godot.controller.command.Command;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static by.epam.training.jwd.godot.controller.command.resource.RequestParam.*;
import static by.epam.training.jwd.godot.controller.command.resource.SessionAttr.AUTHORIZATION;
import static by.epam.training.jwd.godot.controller.command.resource.SessionAttr.*;

public class SwitchLanguage implements Command {

    private static final Logger LOGGER = Logger.getLogger(SwitchLanguage.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String chosenLang = request.getParameter(CHOSEN_LANGUAGE);

        HttpSession session = request.getSession();

        if(session != null) {
            session.setAttribute(LOCALE, chosenLang);
        }
        LOGGER.info("prev " + request.getSession().getAttribute("previousUrl") + "\n");
        response.sendRedirect((String) request.getSession().getAttribute("previousUrl"));
    }
}
