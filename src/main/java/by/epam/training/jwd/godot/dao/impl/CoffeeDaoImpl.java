package by.epam.training.jwd.godot.dao.impl;

import by.epam.training.jwd.godot.bean.IngredientType;
import by.epam.training.jwd.godot.bean.SeasonType;
import by.epam.training.jwd.godot.bean.coffee.*;
import by.epam.training.jwd.godot.dao.CoffeeDao;
import by.epam.training.jwd.godot.dao.connection.ConnectionPool;
import by.epam.training.jwd.godot.dao.connection.ConnectionProvider;
import by.epam.training.jwd.godot.dao.connection.ecxeption.ConnectionPoolException;
import by.epam.training.jwd.godot.dao.exception.DAOException;
import org.apache.commons.math3.util.Precision;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static by.epam.training.jwd.godot.dao.constant.CoffeeTable.*;
import static by.epam.training.jwd.godot.dao.constant.SQLQuery.*;

public class CoffeeDaoImpl implements CoffeeDao {

    private static final Logger LOGGER = Logger.getLogger(CoffeeDaoImpl.class);

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
    public List<Ingredient> getAllIngredients() throws DAOException {
        Statement st = null;
        ResultSet rs = null;
        ConnectionPool pool = null;
        Connection con = null;

        List<Ingredient> ingredients = new ArrayList<>();

        try {
            pool = ConnectionProvider.getConnectionPool();
            con = pool.takeConnection();
            st = con.createStatement();
            rs = st.executeQuery(GET_INGREDIENTS);

            while(rs.next()) {
                int id = rs.getInt(INGREDIENTS_ID);
                String title = rs.getString(INGREDIENT_TITLE);
                double price = rs.getDouble(INGREDIENT_PRICE);
                String img = rs.getString(INGREDIENT_IMG);
                int quantity = rs.getInt(INGREDIENT_QUANTITY);
                String ingredientType = rs.getString(INGREDIENT_TYPE_TITLE);
                String seasonType = rs.getString(SEASON_TITLE);

                Ingredient ingredient = new Ingredient();
                ingredient.setIngredientType(IngredientType.valueOf(ingredientType.toUpperCase()));
                ingredient.setImgSource(img);
                ingredient.setPrice(price);
                ingredient.setQuantity(quantity);
                ingredient.setSeasonType(SeasonType.valueOf(seasonType.toUpperCase()));
                ingredient.setTitle(title);
                ingredient.setId(id);

                ingredients.add(ingredient);

            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DAOException(e);
        } finally {
            if (pool != null) {
                pool.closeConnection(con, st, rs);
            }
        }
        return ingredients;
    }

    @Override
    public List<String> getIngredientColumns() throws DAOException {
        Statement st = null;
        ResultSet rs = null;
        ConnectionPool pool = null;
        Connection con = null;

        List<String> columns = new ArrayList<>();

        try {
            pool = ConnectionProvider.getConnectionPool();
            con = pool.takeConnection();
            st = con.createStatement();
            rs = st.executeQuery(GET_INGREDIENTS);
            ResultSetMetaData metaData = rs.getMetaData();
            int count = metaData.getColumnCount(); //number of column
            String label;

            for (int i = 1; i <= count; i++) {
                label = metaData.getColumnLabel(i);
                if (!label.equals(INGREDIENTS_ID)) {
                    columns.add(label);
                }
            }

        } catch (SQLException | ConnectionPoolException e) {
            throw new DAOException(e);
        } finally {
            if (pool != null) {
                pool.closeConnection(con, st, rs);
            }
        }
        return columns;
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
                coast = Precision.round(rs.getDouble("coast"), 2);
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

    @Override
    public boolean deleteIngredient(String title) throws DAOException {
        PreparedStatement st = null;
        ConnectionPool pool = null;
        Connection con = null;
        boolean res = false;

        try {
            pool = ConnectionProvider.getConnectionPool();
            con = pool.takeConnection();
            st = con.prepareStatement(DELETE_INGREDIENT);
            st.setString(1, title);
            res = st.executeUpdate() != 0;

            LOGGER.info(st);

        } catch (SQLException | ConnectionPoolException e) {
            throw new DAOException(e);
        } finally {
            if (pool != null) {
                pool.closeConnection(con, st);
            }
        }
        return res;
    }

    @Override
    public boolean updateIngredient(Ingredient ingredient, String originalTitle) throws DAOException {
        PreparedStatement st = null;
        ConnectionPool pool = null;
        Connection con = null;
        boolean res = false;

        try {
            pool = ConnectionProvider.getConnectionPool();
            con = pool.takeConnection();
            st = con.prepareStatement(UPDATE_INGREDIENT);
            st.setString(1, ingredient.getTitle());
            st.setInt(2, ingredient.getQuantity());
            st.setDouble(3, ingredient.getPrice());
            st.setString(4, ingredient.getIngredientType().toString());
            st.setString(5, ingredient.getImgSource());
            st.setString(6, ingredient.getSeasonType().toString());
            st.setString(7, originalTitle);

            res = st.executeUpdate() != 0;

        } catch (SQLException | ConnectionPoolException e) {
            throw new DAOException(e);
        } finally {
            if (pool != null) {
                pool.closeConnection(con, st);
            }
        }
        return res;
    }

    @Override
    public boolean addIngredient(Ingredient ingredient) throws DAOException {
        PreparedStatement st = null;
        ConnectionPool pool = null;
        Connection con = null;
        boolean res = false;

        try {
            pool = ConnectionProvider.getConnectionPool();
            con = pool.takeConnection();
            st = con.prepareStatement(INSERT_INGREDIENT);
            st.setString(1, ingredient.getTitle());
            st.setInt(2, ingredient.getQuantity());
            st.setDouble(3, ingredient.getPrice());
            st.setString(4, ingredient.getIngredientType().toString());
            st.setString(5, ingredient.getImgSource());
            st.setString(6, ingredient.getSeasonType().toString());

            res = st.executeUpdate() != 0;

        } catch (SQLException | ConnectionPoolException e) {
            throw new DAOException(e);
        } finally {
            if (pool != null) {
                pool.closeConnection(con, st);
            }
        }
        return res;
    }
}
