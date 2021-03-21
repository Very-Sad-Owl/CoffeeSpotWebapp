package by.epam.training.jwd.godot.dao.constant;

import by.epam.training.jwd.godot.bean.SeasonType;

import static by.epam.training.jwd.godot.dao.constant.CoffeeTable.*;
import static by.epam.training.jwd.godot.dao.constant.CoffeeTable.INGREDIENT_TITLE;

public interface SQLQuery {

    String GET_ALL_QUERY = "SELECT * FROM %s";
    String GET_AVAILABLE_QUERY = "";
    String GET_COFFEE_COAST = "SELECT SUM(amount*price) AS coast FROM " +
            "(SELECT ingredients.id, recepits.ingredient_id, recepits.coffee_type_id, amount," +
            "price FROM ingredients JOIN recepits on ingredients.id = recepits.ingredient_id) AS sub " +
            "where coffee_type_id = any(select id from coffee_types where title = '%s')";
    String GET_SEASONAL_INGREDIENTS = String.format("select * from %s where %s " +
                    "= any(select id from %s where %s in ('%s',",
            INGREDIENTS_TABLE, INGREDIENT_SEASON_ID, SEASONS_TABLE, SEASON_TITLE, SeasonType.ANY) + " '%s'))";
    String GET_COFFEE_SIZES = "SELECT %s, %s FROM %s WHERE %s" +
            " = any(SELECT %s from %s where %s = '%s')";
    String DELETE_INGREDIENT = String.format("DELETE FROM %s WHERE %s = ?", INGREDIENTS_TABLE, INGREDIENT_TITLE);
    String UPDATE_INGREDIENT = String.format("UPDATE %s " +
                    "SET %s = ?, %s = ?, %s = ?, " +
                    "%s = (select %s from %s where %s = ?), %s = ?, " +
                    "%s = (select %s from %s where %s = ?) " +
                    "WHERE %s = ?", INGREDIENTS_TABLE, INGREDIENT_TITLE, INGREDIENT_QUANTITY, INGREDIENT_PRICE, INGREDIENT_TYPE_ID,
            INGREDIENTS_ID, INGREDIENT_TYPE_TABLE, INGREDIENT_TYPE_TITLE, INGREDIENT_IMG, INGREDIENT_SEASON_ID, SEASON_ID,
            SEASONS_TABLE, SEASON_TITLE, INGREDIENT_TITLE);
    String GET_INGREDIENTS = "SELECT ingredients.id, title, quantity, price, img_source, season, type FROM ingredients JOIN seasons on seasons.id = ingredients.season_id  JOIN ingredient_type on ingredient_type.id = ingredients.type_id";
    String INSERT_INGREDIENT = String.format(
            "INSERT INTO ingredients(%s, %s, %s, %s, %s, %s) values(?, ?, ?, (select id from %s where %s = ?), ?, (select id from %s where %s = ?))"
    , INGREDIENT_TITLE, INGREDIENT_QUANTITY, INGREDIENT_PRICE, INGREDIENT_TYPE_ID, INGREDIENT_IMG, INGREDIENT_SEASON_ID, INGREDIENT_TYPE_TABLE, INGREDIENT_TYPE_TITLE, SEASONS_TABLE, SEASON_TITLE);

}
