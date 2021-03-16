package by.epam.training.jwd.godot.bean.coffee;

import by.epam.training.jwd.godot.bean.IngredientType;
import by.epam.training.jwd.godot.bean.SeasonType;

import java.io.Serializable;
import java.util.Objects;

public class Ingredient implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    private String title;
    private int quantity;
    private double price;
    private IngredientType ingredientType;
    private String imgSource;
    private SeasonType seasonType;

    public Ingredient(){}

    public Ingredient(int id, String title, int quantity, double price, IngredientType ingredientType, String imgSource, SeasonType seasonType) {
        this.id = id;
        this.title = title;
        this.quantity = quantity;
        this.price = price;
        this.ingredientType = ingredientType;
        this.imgSource = imgSource;
        this.seasonType = seasonType;
    }

    public Ingredient(String title, int quantity, double price, IngredientType ingredientType, String imgSource, SeasonType seasonType) {
        this.title = title;
        this.quantity = quantity;
        this.price = price;
        this.ingredientType = ingredientType;
        this.imgSource = imgSource;
        this.seasonType = seasonType;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public IngredientType getIngredientType() {
        return ingredientType;
    }

    public void setIngredientType(IngredientType ingredientType) {
        this.ingredientType = ingredientType;
    }

    public String getImgSource() {
        return imgSource;
    }

    public void setImgSource(String imgSource) {
        this.imgSource = imgSource;
    }

    public SeasonType getSeasonType() {
        return seasonType;
    }

    public void setSeasonType(SeasonType seasonType) {
        this.seasonType = seasonType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ingredient)) return false;
        Ingredient that = (Ingredient) o;
        return getId() == that.getId() &&
                getQuantity() == that.getQuantity() &&
                Double.compare(that.getPrice(), getPrice()) == 0 &&
                Objects.equals(getTitle(), that.getTitle()) &&
                getIngredientType() == that.getIngredientType() &&
                Objects.equals(getImgSource(), that.getImgSource()) &&
                getSeasonType() == that.getSeasonType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getQuantity(), getPrice(), getIngredientType(), getImgSource(), getSeasonType());
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", ingredientType=" + ingredientType +
                ", imgSource='" + imgSource + '\'' +
                ", seasonType=" + seasonType +
                '}';
    }
}
