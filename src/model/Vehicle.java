package model;

import java.io.Serializable;

public class Vehicle implements Serializable, Comparable<Vehicle> {

    private static final long serialVersionUID = 1;
    private Vehicle next;
    private int codeV;
    private String plate;
    private boolean dispV;
    private String photo;

    public Vehicle(int codeV, String plate, boolean dispV, String photo) {
        this.codeV = codeV;
        this.plate = plate;
        this.dispV = dispV;
        this.photo = photo;
        next = null;
    }

    public Vehicle getNext() {
        return next;
    }

    public int getCodeV() {
        return codeV;
    }

    public void setCodeV(int codeV) {
        this.codeV = codeV;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public boolean isDispV() {
        return dispV;
    }

    public void setDispV(boolean dispV) {
        this.dispV = dispV;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public int compareTo(Vehicle o) {
        return this.getPlate().compareToIgnoreCase(o.getPlate());
    }
}
