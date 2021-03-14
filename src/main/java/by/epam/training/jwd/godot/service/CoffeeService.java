package by.epam.training.jwd.godot.service;

import by.epam.training.jwd.godot.bean.SeasonType;
import by.epam.training.jwd.godot.bean.coffee.Coffee;
import by.epam.training.jwd.godot.bean.coffee.CoffeeSize;
import by.epam.training.jwd.godot.bean.coffee.CoffeeType;
import by.epam.training.jwd.godot.bean.coffee.Decoration;
import by.epam.training.jwd.godot.service.exception.ServiceException;

import java.util.List;

public interface CoffeeService {
    List<Coffee> getAllCoffee() throws ServiceException;
    List<Coffee> getAllAvailableCoffee();
    List<Decoration> getDecorators() throws ServiceException;
    List<CoffeeSize> getSizes(CoffeeType type) throws ServiceException;

}
