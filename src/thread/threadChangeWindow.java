package thread;

import java.io.IOException;
import javafx.application.Platform;
import ui.*;

public class threadChangeWindow extends Thread {

    private FXLogin xLogin;
    private FXRegister xRegister;
    private FXController xController;

    public threadChangeWindow(FXLogin xLogin, FXController xController) {
        this.xLogin = xLogin;
        this.xController = xController;
    }

    public threadChangeWindow(FXRegister xRegister, FXController xController) {
        this.xRegister = xRegister;
        this.xController = xController;
    }

    @Override
    public void run() {
        Platform.runLater(new Thread() {
            @Override
            public void run() {
                try {
                    xController.showMenu();
                } catch (IOException ex) {

                }
            }
        });
    }
}
