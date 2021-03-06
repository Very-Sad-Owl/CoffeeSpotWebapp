package by.epam.training.jwd.godot.dao;


import by.epam.training.jwd.godot.dao.impl.CoffeeDaoImpl;
import by.epam.training.jwd.godot.dao.impl.UserDaoImpl;

public final class DaoProvider {

	private static final DaoProvider instance = new DaoProvider();

	private final UserDao userdao = new UserDaoImpl();
	private final CoffeeDao coffeedao = new CoffeeDaoImpl();

	private DaoProvider() {}
	
	public static DaoProvider getInstance() {
		return instance;
	}

	public UserDao getUserDao() {
		return userdao;
	}
	public CoffeeDao getCoffeeDao(){return coffeedao;}
	
}
