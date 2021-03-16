package by.epam.training.jwd.godot.controller.command;

import java.util.HashMap;
import java.util.Map;

import by.epam.training.jwd.godot.controller.command.impl.*;

public class CommandProvider {
	private Map<CommandName, Command> commands = new HashMap<>();
	
	public CommandProvider() {
		commands.put(CommandName.LOGINATION, new SigningIn());
		commands.put(CommandName.GOTOLOGINATIONPAGE, new GoToLoginationPage());
		commands.put(CommandName.GOTOREGISTRATIONPAGE, new GoToRegistrationPage());
		commands.put(CommandName.REGISTRATION, new Registration());
		commands.put(CommandName.GOTOINDEXPAGE, new GoToMainPage());
		commands.put(CommandName.LOGOUT, new Logout());
		commands.put(CommandName.GOTOADMINPAGE, new GoToAdminPage());
		commands.put(CommandName.GOTOMANAGEINGREDIENTSPAGE, new GoToIngredientManagementPage());
		commands.put(CommandName.MANAGEINGREDIENTS, new IngredientsManager());
		commands.put(CommandName.SWITCHLANGUAGE, new SwitchLanguage());
	}
	
	
	public Command takeCommand(String name) {
		CommandName commandName;
		
		commandName = CommandName.valueOf(name.toUpperCase());
		
		return commands.get(commandName);
	}

}
