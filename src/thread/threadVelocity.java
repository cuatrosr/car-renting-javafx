package thread;

import javafx.application.Platform;
import ui.*;
import model.*;

public class ThreadVelocity extends Thread {

    private FXSpeed xSpeed;
    private RentingCar rc;
    private int velocity;

    public ThreadVelocity(FXSpeed xSpeed, RentingCar rc, int velocity) {
        this.xSpeed = xSpeed;
        this.rc = rc;
        this.velocity = velocity;
    }

    @Override
    public void run() {
        String msg = rc.calculateCategorySpeed(velocity);
        Platform.runLater(new Thread() {
            @Override
            public void run() {
                xSpeed.showResult(msg);
            }
        });
    }
}
