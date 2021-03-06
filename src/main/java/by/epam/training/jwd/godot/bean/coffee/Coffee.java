package by.epam.training.jwd.godot.bean.coffee;

import java.io.Serializable;
import java.util.Objects;

public class Coffee implements Serializable {

    private static final long serialVersionUID = 1L;
    private CoffeeType type;
    private String description;
    private double coast;
    private String img_path;

    public Coffee(){}

    public Coffee(CoffeeType type, String description, double coast, String img_path) {
        this.type = type;
        this.description = description;
        this.coast = coast;
        this.img_path = img_path;
    }

    public Coffee(CoffeeType type, String img_path) {
        this.type = type;
        this.img_path = img_path;
    }

    public Coffee(CoffeeType type, String description, String img_path) {
        this.type = type;
        this.description = description;
        this.img_path = img_path;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCoast() {
        return coast;
    }

    public void setCoast(double coast) {
        this.coast = coast;
    }

    public CoffeeType getType() {
        return type;
    }

    public void setType(CoffeeType type) {
        this.type = type;
    }

    public String getImg_path() {
        return img_path;
    }

    public void setImg_path(String img_path) {
        this.img_path = img_path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coffee)) return false;
        Coffee coffee = (Coffee) o;
        return Double.compare(coffee.getCoast(), getCoast()) == 0 &&
                getType() == coffee.getType() &&
                Objects.equals(getDescription(), coffee.getDescription()) &&
                Objects.equals(getImg_path(), coffee.getImg_path());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getDescription(), getCoast(), getImg_path());
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "type=" + type +
                ", description='" + description + '\'' +
                ", coast=" + coast +
                ", img_path='" + img_path + '\'' +
                '}';
    }
}
