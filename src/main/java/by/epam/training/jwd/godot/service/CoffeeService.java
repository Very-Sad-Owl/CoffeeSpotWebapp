package by.epam.training.jwd.godot.service;

import by.epam.training.jwd.godot.bean.coffee.Coffee;
import by.epam.training.jwd.godot.service.exception.ServiceException;

import java.util.List;

public interface CoffeeService {
    List<Coffee> getAllCoffee() throws ServiceException;
    List<Coffee> getAllAvailableCoffee();
}
