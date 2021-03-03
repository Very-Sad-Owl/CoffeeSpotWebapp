package by.epam.training.jwd.godot.dao;


import by.epam.training.jwd.godot.dao.impl.SQLUserDAO;

public final class DAOProvider {

	private static final DAOProvider instance = new DAOProvider();	
	
	private final UserDAO userdao = new SQLUserDAO();
	
	private DAOProvider() {}
	
	public static DAOProvider getInstance() {
		return instance;
	}

	public UserDAO getUserdao() {
		return userdao;
	}
	
}
