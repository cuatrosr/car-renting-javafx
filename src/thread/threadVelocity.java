package thread;

import ui.*;
import model.*;

public class threadVelocity extends Thread{
    
    private FXVehicle xVechicle;
    private RentingCar rc;

    public threadVelocity(FXVehicle xVechicle, RentingCar rc) {
        this.xVechicle = xVechicle;
        this.rc = rc;
    }

    @Override
    public void run(){
        
    }
    

}
