package by.epam.training.jwd.godot.service;


import by.epam.training.jwd.godot.service.impl.CoffeeServiseImpl;
import by.epam.training.jwd.godot.service.impl.UserServiceImpl;

public final class ServiceProvider {
	
	private static final ServiceProvider instance = new ServiceProvider(); 

	private ServiceProvider() {}
	
	private final UserService userService = new UserServiceImpl();
	private final CoffeeService coffeeService = new CoffeeServiseImpl();

	public static ServiceProvider getInstance() {
		return instance;
	}

	public UserService getUserService() {
		return userService;
	}
	public CoffeeService getCoffeeService() {return coffeeService;}

}
