package by.epam.training.jwd.godot.bean.coffee;

import java.io.Serializable;
import java.util.Objects;

public class Coffee implements Serializable {

    private static final long serialVersionUID = 1L;
    private CoffeeType type;
    private String description;
    private double coast;
    private String imgPath;

    public Coffee(){}

    public Coffee(CoffeeType type, String description, double coast, String imgPath) {
        this.type = type;
        this.description = description;
        this.coast = coast;
        this.imgPath = imgPath;
    }

    public Coffee(CoffeeType type, String imgPath) {
        this.type = type;
        this.imgPath = imgPath;
    }

    public Coffee(CoffeeType type, String description, String imgPath) {
        this.type = type;
        this.description = description;
        this.imgPath = imgPath;
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

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coffee)) return false;
        Coffee coffee = (Coffee) o;
        return Double.compare(coffee.getCoast(), getCoast()) == 0 &&
                getType() == coffee.getType() &&
                Objects.equals(getDescription(), coffee.getDescription()) &&
                Objects.equals(getImgPath(), coffee.getImgPath());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getDescription(), getCoast(), getImgPath());
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "type=" + type +
                ", description='" + description + '\'' +
                ", coast=" + coast +
                ", imgPath='" + imgPath + '\'' +
                '}';
    }
}
