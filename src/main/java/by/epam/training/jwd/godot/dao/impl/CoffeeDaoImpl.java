package by.epam.training.jwd.godot.dao.impl;

import by.epam.training.jwd.godot.bean.coffee.Coffee;
import by.epam.training.jwd.godot.bean.coffee.CoffeeType;
import by.epam.training.jwd.godot.dao.CoffeeDao;
import by.epam.training.jwd.godot.dao.connection.ConnectionPool;
import by.epam.training.jwd.godot.dao.connection.ConnectionProvider;
import by.epam.training.jwd.godot.dao.connection.ecxeption.ConnectionPoolException;
import by.epam.training.jwd.godot.dao.exception.DAOException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static by.epam.training.jwd.godot.dao.constant.CoffeTable.*;

public class CoffeeDaoImpl implements CoffeeDao {

    private static final String GET_ALL_QUERY = "SELECT * FROM %s";
    private static final String GET_AVAILABLE_QUERY = "";
    public static final String GET_COAST = "";

    @Override
    public List<Coffee> getAll() throws DAOException {
        Statement st = null;
        ResultSet rs = null;
        ConnectionPool pool = null;
        Connection con = null;

        List<Coffee> all = new ArrayList<>();

        try {
            pool = ConnectionProvider.getConnectionPool();
            con = pool.takeConnection();
            st = con.createStatement();
            rs = st.executeQuery(String.format(GET_ALL_QUERY,
                    TABLE_NAME));

            while(rs.next()) {
                String type = rs.getString(TYPE);
                String imgPath = rs.getString(IMG);
                Coffee coffee = new Coffee(CoffeeType.valueOf(type), CoffeeType.valueOf(type).toString(), imgPath);
                coffee.setCoast(calculateCoast(coffee.getType().toString()));

                all.add(coffee);
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DAOException(e);
        } finally {
            if (pool != null) {
                pool.closeConnection(con, st, rs);
            }
        }
        return all;
    }

    @Override
    public List<Coffee> getAvailable() {
        return null;
    }

    private double calculateCoast(String type){
        return 0;
    }
}
