package ui;

import model.*;

public class FXClient {

    private RentingCar rc;
    private FXController fxGUI;

    public FXClient(RentingCar rc, FXController fxGUI) {
        this.rc = rc;
        this.fxGUI = fxGUI;
    }
}
