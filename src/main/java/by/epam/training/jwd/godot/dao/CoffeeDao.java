package by.epam.training.jwd.godot.dao;

import by.epam.training.jwd.godot.bean.coffee.Coffee;
import by.epam.training.jwd.godot.dao.exception.DAOException;

import java.util.List;

public interface CoffeeDao {
    List<Coffee> getAll() throws DAOException;
    List<Coffee> getAvailable();
}