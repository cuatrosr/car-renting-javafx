package model;

import java.io.Serializable;

public class Car extends Vehicle implements Serializable {

    private static final long serialVersionUID = 1;
    private String model;
    private String color;
    private int year;
    private Brand brand;
    private TypeV typeV;
    private double priceXDay;
    private int refV;
    private Car prev;
    private Car next;

    private Car parent;
    private Car left;
    private Car right;

    public Car(String model, String color, Brand brand, TypeV typeV, double priceXDay, int codeV, String plate, boolean dispV, String photo, int year, int refV) {
        super(codeV, plate, dispV, photo);
        this.model = model;
        this.color = color;
        this.brand = brand;
        this.typeV = typeV;
        this.priceXDay = priceXDay;
        this.year = year;
        this.refV = refV;
    }

    public int getRefV() {
        return refV;
    }

    public void setRefV(int refV) {
        this.refV = refV;
    }

    public Car getParent() {
        return parent;
    }

    public void setParent(Car parent) {
        this.parent = parent;
    }

    public Car getLeft() {
        return left;
    }

    public void setLeft(Car left) {
        this.left = left;
    }

    public Car getRight() {
        return right;
    }

    public void setRight(Car right) {
        this.right = right;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
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

    public String getNameType() {
        if (typeV != null) {
            return typeV.getNameTB();
        } else {
            return "";
        }
    }

    public String getNameBrand() {
        if (brand != null) {
            return brand.getNameTB();
        } else {
            return "";
        }
    }
}
