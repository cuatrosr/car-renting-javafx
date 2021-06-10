package thread;

import javafx.application.Platform;
import model.RentingCar;
import ui.FXSpeed;

public class ThreadCarMove extends Thread {

    private FXSpeed xSpeed;
    @SuppressWarnings("unused")
	private RentingCar rc;
    private int velocity;

    public ThreadCarMove(FXSpeed xSpeed, RentingCar rc, int velocity) {
        this.xSpeed = xSpeed;
        this.rc = rc;
        this.velocity = velocity;
    }

    @Override
    public void run() {
        int sleep = velocity(velocity);
        int i = 0;
        while (i < 850 && isAlive()) {
            Platform.runLater(new Thread() {
                @Override
                public void run() {
                    xSpeed.moveCar();
                }
            });
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
            }
            i++;
        }
    }

    public int velocity(int velocity) {
        if (velocity < 100) {
            return 13;
        } else if (velocity < 200) {
            return 5;
        } else if (velocity < 300) {
            return 3;
        } else {
            return 1;
        }
    }
}
