package by.epam.training.jwd.godot.dao.impl;

import by.epam.training.jwd.godot.bean.coffee.Coffee;
import by.epam.training.jwd.godot.dao.exception.DAOException;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static org.junit.Assert.*;

public class CoffeeDaoImplTest {

    private CoffeeDaoImpl dao = new CoffeeDaoImpl();
    private Method calculateCoast;

    @Before
    public void setUp() throws Exception {

        calculateCoast = CoffeeDaoImpl.class
                .getDeclaredMethod("calculateCoast", String.class);
        calculateCoast.setAccessible(true);
    }


    @Test
    public void getAll_coffeeList() throws DAOException {
        List<Coffee> all = dao.getAllBeverages();

        for (Coffee el : all){
            System.out.println(el);
        }
    }

    @Test
    public void getCoast_existingRow() throws InvocationTargetException, IllegalAccessException {
        String arg = "latte";

        double expected = 0.56;

        double actual = (Double)calculateCoast.invoke(dao, arg);

        assertEquals(expected, actual, 0.0001);
    }

}