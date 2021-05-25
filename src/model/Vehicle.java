package model;

import java.io.Serializable;
import javafx.scene.image.Image;

public class Vehicle implements Serializable {

    private static final long serialVersionUID = 1;
    private Vehicle next;
    private int codeV;
    private String plate;
    private boolean dispV;
    private Image photo;

    public Vehicle(int codeV, String plate, boolean dispV, Image photo) {
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

    public Image getPhoto() {
        return photo;
    }

    public void setPhoto(Image photo) {
        this.photo = photo;
    }
}
