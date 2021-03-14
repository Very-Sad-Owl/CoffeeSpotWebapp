package by.epam.training.jwd.godot.service.impl;

import by.epam.training.jwd.godot.bean.SeasonType;
import by.epam.training.jwd.godot.bean.coffee.Coffee;
import by.epam.training.jwd.godot.bean.coffee.CoffeeSize;
import by.epam.training.jwd.godot.bean.coffee.CoffeeType;
import by.epam.training.jwd.godot.bean.coffee.Decoration;
import by.epam.training.jwd.godot.dao.CoffeeDao;
import by.epam.training.jwd.godot.dao.DaoProvider;
import by.epam.training.jwd.godot.dao.exception.DAOException;
import by.epam.training.jwd.godot.service.CoffeeService;
import by.epam.training.jwd.godot.service.exception.ServiceException;
import by.epam.training.jwd.godot.service.util.SeasonManager;

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
            throw new ServiceException("Cannot retrieve coffee data");
        }
        return coffeeList;
    }

    @Override
    public List<Coffee> getAllAvailableCoffee() {
        return null;
    }

    @Override
    public List<Decoration> getDecorators() throws ServiceException {
        List<Decoration> decorationList = new ArrayList<>();

        DaoProvider provider = DaoProvider.getInstance();
        CoffeeDao dao = provider.getCoffeeDao();

        try {
            decorationList.addAll(dao.getDecorators(SeasonType.of(SeasonManager.getCurrentMonth())));
        } catch (DAOException e) {
            throw new ServiceException("Cannot retrieve ingredient data");
        }
        return decorationList;
    }

    @Override
    public List<CoffeeSize> getSizes(CoffeeType type) throws ServiceException {
        List<CoffeeSize> sizesList = new ArrayList<>();

        DaoProvider provider = DaoProvider.getInstance();
        CoffeeDao dao = provider.getCoffeeDao();

        try {
            sizesList.addAll(dao.getCoffeeTypeSizes(type));
        } catch (DAOException e) {
            throw new ServiceException("Cannot retrieve sizes data");
        }
        return sizesList;
    }
}
