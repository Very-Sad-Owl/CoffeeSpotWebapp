package by.epam.training.jwd.godot.dao.impl;

import by.epam.training.jwd.godot.bean.SeasonType;
import by.epam.training.jwd.godot.bean.coffee.Coffee;
import by.epam.training.jwd.godot.bean.coffee.CoffeeSize;
import by.epam.training.jwd.godot.bean.coffee.CoffeeType;
import by.epam.training.jwd.godot.bean.coffee.Decoration;
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

import static by.epam.training.jwd.godot.dao.constant.CoffeeTable.*;

public class CoffeeDaoImpl implements CoffeeDao {

    private static final String GET_ALL_QUERY = "SELECT * FROM %s";
    private static final String GET_AVAILABLE_QUERY = "";
    private static final String GET_COFFEE_COAST = "SELECT SUM(amount*price) AS coast FROM " +
            "(SELECT ingredients.id, recepits.ingredient_id, recepits.coffee_type_id, amount," +
            "price FROM ingredients JOIN recepits on ingredients.id = recepits.ingredient_id) AS sub " +
            "where coffee_type_id = any(select id from coffee_types where title = '%s')";
    private static final String GET_SEASONAL_INGREDIENTS = String.format("select * from %s where %s " +
            "= any(select id from %s where %s in ('%s',",
            INGREDIENTS_TABLE, INGREDIENT_SEASON_ID, SEASONS_TABLE, SEASON_TITLE, SeasonType.ANY) + " '%s'))";
    private static final String GET_COFFEE_SIZES = "SELECT %s, %s FROM %s WHERE %s" +
            " = any(SELECT %s from %s where %s = '%s')";

    @Override
    public List<Coffee> getAllBeverages() throws DAOException {
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
                    COFFEE_TYPES_TABLE));

            while(rs.next()) {
                String type = rs.getString(TYPE).toUpperCase();
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
    public List<Coffee> getAvailableBeverages() throws DAOException {
       return null;
    }

    @Override
    public List<Decoration> getDecorators(SeasonType season) throws DAOException {
        Statement st = null;
        ResultSet rs = null;
        ConnectionPool pool = null;
        Connection con = null;

        List<Decoration> all = new ArrayList<>();

        try {
            pool = ConnectionProvider.getConnectionPool();
            con = pool.takeConnection();
            st = con.createStatement();
            rs = st.executeQuery(String.format(GET_SEASONAL_INGREDIENTS, season));

            while(rs.next()) {
                String title = rs.getString(INGREDIENT_TITLE);
                double price = rs.getDouble(INGREDIENT_PRICE);
                String img = rs.getString(INGREDIENT_IMG);
                Decoration decoration = new Decoration(title, price, img);
                all.add(decoration);
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
    public List<CoffeeSize> getCoffeeTypeSizes(CoffeeType type) throws DAOException {
        Statement st = null;
        ResultSet rs = null;
        ConnectionPool pool = null;
        Connection con = null;

        List<CoffeeSize> sizes = new ArrayList<>();

        try {
            pool = ConnectionProvider.getConnectionPool();
            con = pool.takeConnection();
            st = con.createStatement();
            rs = st.executeQuery(String.format(GET_COFFEE_SIZES,
                    SIZE_VOL, SIZE_INCREMENT, SIZES_TABLE, SIZE_COFFE_TYPE_ID,
                    COFFE_TYPE_ID, COFFEE_TYPES_TABLE, TYPE, type));

            while(rs.next()) {
                int vol = rs.getInt(SIZE_VOL);
                double incr = rs.getDouble(SIZE_INCREMENT);
                CoffeeSize sizeEl = new CoffeeSize(vol, incr);
                sizes.add(sizeEl);
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DAOException(e);
        } finally {
            if (pool != null) {
                pool.closeConnection(con, st, rs);
            }
        }
        return sizes;

    }

    private double calculateCoast(String type) throws DAOException {
        Statement st = null;
        ResultSet rs = null;
        ConnectionPool pool = null;
        Connection con = null;

        double coast = 0;

        try {
            pool = ConnectionProvider.getConnectionPool();
            con = pool.takeConnection();
            st = con.createStatement();
            rs = st.executeQuery(String.format(GET_COFFEE_COAST, type.toLowerCase()));

            if(rs.next()) {
                coast = rs.getDouble("coast");
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DAOException(e);
        } finally {
            if (pool != null) {
                pool.closeConnection(con, st, rs);
            }
        }
        return coast;
    }
}
