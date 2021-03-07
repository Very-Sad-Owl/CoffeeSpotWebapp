package by.epam.training.jwd.godot.service.impl;

import by.epam.training.jwd.godot.bean.coffee.Coffee;
import by.epam.training.jwd.godot.dao.CoffeeDao;
import by.epam.training.jwd.godot.dao.DaoProvider;
import by.epam.training.jwd.godot.dao.exception.DAOException;
import by.epam.training.jwd.godot.service.CoffeeService;
import by.epam.training.jwd.godot.service.exception.ServiceException;

import java.util.ArrayList;
import java.util.List;

public class CoffeeServiseImpl implements CoffeeService {
    @Override
    public List<Coffee> getAllCoffee() throws ServiceException {
        List<Coffee> coffeeList = new ArrayList<>();

        DaoProvider provider = DaoProvider.getInstance();
        CoffeeDao dao = provider.getCoffeeDao();

        try {
            coffeeList.addAll(dao.getAllBeverages());
        } catch (DAOException e) {
            throw new ServiceException("Cannot retrieve data");
        }
        return coffeeList;
    }

    @Override
    public List<Coffee> getAllAvailableCoffee() {
        return null;
    }
}
