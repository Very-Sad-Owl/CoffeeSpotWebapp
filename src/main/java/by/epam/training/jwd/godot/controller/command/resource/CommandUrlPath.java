package by.epam.training.jwd.godot.controller.command.resource;

public interface CommandUrlPath {

    String MAINPAGE = "jsp/main_page.jsp";
    String LOGINATIONPAGE = "jsp/logination.jsp";
    String REGISTRATIONPAGE = "jsp/registration.jsp";
    String ADMIN_PAGE = "jsp/admin_page.jsp";
    String INGREDIENTS_MANAGE_PAGE = "jsp/ingredients_manager.jsp";
    String GOTOINDEXPAGE_WITH_MSG = "Controller?command=gotoindexpage&message=%S";
    String GOTOINDEXPAGE = "Controller?command=gotoindexpage";
    String GOTOLOGINPAGE = "Controller?command=gotologinationpage";
    String GOTOLOGINPAGE_WITH_MSG = "Controller?command=gotologinationpage&message=%s";
    String GOTOREGISTRATIONPAGE = "Controller?command=gotoregistrationpage";
    String GOTOREGISTRATIONPAGE_WITH_MSG = "Controller?command=gotoregistrationpage&message=%s";
    String GOTOADMINPAGE = "Controller?command=gotoadminpage";
    String MANAGE_INGREDIENTS = "Controller?command=manageingredients";
    String SWITCHLANGUAGE = "Controller?command=switchlanguage";
}
