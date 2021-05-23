package ui;
import model.*;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class FXLogin {

    @FXML
    private Pane mainPane;

    @FXML
    private StackPane stackPane;

    @FXML
    private JFXTextField txtUserLogin;

    @FXML
    private JFXPasswordField txtPassWordLogin;

    private RentingCar rc;
    private FXController fxGUI;

    public FXLogin(RentingCar rc, FXController fxGUI) {
        this.rc = rc;
        this.fxGUI = fxGUI;
    }

    @FXML
    public void onCreateAccount(ActionEvent event) throws IOException {
        fxGUI.showRegister();
    }

    @FXML
    public void onLogIn(ActionEvent event) throws IOException {
        fxGUI.closeStage(fxGUI.getPMain());
        fxGUI.closeStage(mainPane);
        fxGUI.showMenu();

    }

}
