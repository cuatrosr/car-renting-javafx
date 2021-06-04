package model;

import java.io.Serializable;
import javafx.scene.image.Image;

public class Car extends Vehicle implements Serializable {

    private static final long serialVersionUID = 1;
    private String model;
    private String color;
    private Brand brand;
    private TypeV typeV;
    private double priceXDay;
    private Car prev;
    private Car next;

    public Car(String model, String color, Brand brand, TypeV typeV, double priceXDay, int codeV, String plate, boolean dispV, Image photo) {
        super(codeV, plate, dispV, photo);
        this.model = model;
        this.color = color;
        this.brand = brand;
        this.typeV = typeV;
        this.priceXDay = priceXDay;
    }

    public Car getPrev() {
        return prev;
    }

    public void setPrev(Car prev) {
        this.prev = prev;
    }

    public Car getNext() {
        return next;
    }

    public void setNext(Car next) {
        this.next = next;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public TypeV getTypeV() {
        return typeV;
    }

    public void setTypeV(TypeV typeV) {
        this.typeV = typeV;
    }

    public double getPriceXDay() {
        return priceXDay;
    }

    public void setPriceXDay(double priceXDay) {
        this.priceXDay = priceXDay;
    }
}
