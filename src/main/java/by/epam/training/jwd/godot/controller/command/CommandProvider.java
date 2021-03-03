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
		commands.put(CommandName.GOTOINDEXPAGE, new GoToIndexPage());
		commands.put(CommandName.LOGOUT, new Logout());
	}
	
	
	public Command takeCommand(String name) {
		CommandName commandName;
		
		commandName = CommandName.valueOf(name.toUpperCase());
		
		return commands.get(commandName);
	}

}
