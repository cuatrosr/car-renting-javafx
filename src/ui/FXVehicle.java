package ui;

import model.*;

public class FXVehicle {

    private RentingCar rc;
    private FXController fxGUI;

    public FXVehicle(RentingCar rc, FXController fxGUI) {
        this.rc = rc;
        this.fxGUI = fxGUI;
    }
}