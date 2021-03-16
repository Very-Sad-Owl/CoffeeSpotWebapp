package by.epam.training.jwd.godot.bean.coffee;

import java.io.Serializable;
import java.util.Objects;

public class Decoration implements Serializable {

    private static final long serialVersionUID = 1L;
    private String title;
    private double coast;
    private String imgPath;

    public Decoration(){}


    public Decoration(String title, double coast, String imgPath) {
        this.title = title;
        this.coast = coast;
        this.imgPath = imgPath;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getCoast() {
        return coast;
    }

    public void setCoast(double coast) {
        this.coast = coast;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Decoration)) return false;
        Decoration that = (Decoration) o;
        return Double.compare(that.getCoast(), getCoast()) == 0 &&
                Objects.equals(getTitle(), that.getTitle()) &&
                Objects.equals(getImgPath(), that.getImgPath());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getCoast(), getImgPath());
    }

    @Override
    public String toString() {
        return "Decoration{" +
                "title='" + title + '\'' +
                ", coast=" + coast +
                ", imgPath='" + imgPath + '\'' +
                '}';
    }
}
