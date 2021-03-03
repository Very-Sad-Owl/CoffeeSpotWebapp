package by.epam.training.jwd.godot.dao.impl;

import by.epam.training.jwd.godot.bean.SignInInfo;
import by.epam.training.jwd.godot.bean.RegistrationInfo;
import by.epam.training.jwd.godot.bean.User;
import by.epam.training.jwd.godot.dao.exception.DAOException;
import by.epam.training.jwd.godot.dao.UserDAO;
import by.epam.training.jwd.godot.dao.connection.ConnectionPool;
import by.epam.training.jwd.godot.dao.connection.ConnectionProvider;
import by.epam.training.jwd.godot.dao.connection.ecxeption.ConnectionPoolException;
import org.apache.log4j.Logger;

import java.sql.*;

import static by.epam.training.jwd.godot.dao.constants.UserTable.*;

public class SQLUserDAO implements UserDAO {

	private static final Logger LOGGER = Logger.getLogger(SQLUserDAO.class);
	private static final String FIND_USER = "SELECT * FROM %s WHERE %s = \"%s\" AND %s = \"%s\"";
	private static final String INSERT_USER = "INSERT INTO %s(%s,%s,%s,%s) values(\"%s\", \"%s\", \"%s\", %d)";

	public User authorization(SignInInfo info) throws DAOException {

		Statement st = null;
		ResultSet rs = null;
		ConnectionPool pool = null;
		Connection con = null;

		User user = null;

		try {
			pool = ConnectionProvider.getConnectionPool();
			con = pool.takeConnection();
			st = con.createStatement();
			rs = st.executeQuery(String.format(FIND_USER,
					TABLE_NAME, LOGIN_COL, info.getLogin(), PASSWORD_COL, info.getPassword()));

			while(rs.next()) {
				int id = rs.getInt(ID_COL);
				String foundLogin = rs.getString(LOGIN_COL);
				String foundPassword = rs.getString(PASSWORD_COL);
				String foundEmail = rs.getString(EMAIL_COL);
				double foundBalance = rs.getDouble(BALANCE_COL);
				int foundRole = rs.getInt(ROLE_COL);
				user = new User(id, foundLogin, foundPassword, foundEmail, foundBalance, foundRole);
			}
		} catch (SQLException | ConnectionPoolException e) {
			LOGGER.error(e);
			throw new DAOException(e);
		} finally {
			if (pool != null) {
				pool.closeConnection(con, st, rs);
			}
		}
		return user;
	}

	public boolean registration(RegistrationInfo info) throws DAOException {

		ConnectionPool pool = null;
		Connection con = null;
		PreparedStatement ps = null;
		int res;

		try {

			pool = ConnectionProvider.getConnectionPool();
			con = pool.takeConnection();
			ps = con.prepareStatement(String.format(INSERT_USER,
					TABLE_NAME, LOGIN_COL, PASSWORD_COL, EMAIL_COL, ROLE_COL,
					info.getLogin(), info.getLogin(), info.getEmail(), USER_ROLE_ID));

			res = ps.executeUpdate();

		} catch (SQLException | ConnectionPoolException e) {
			LOGGER.error(e);
			throw new DAOException(e);
		} finally {
			if (pool != null) {
				pool.closeConnection(con, ps);
			}
		}

		return res == 0;
	}

}
