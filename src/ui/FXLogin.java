package ui;
import model.*;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
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
    void onCreateAccount(ActionEvent event) {

    }

    @FXML
    void onLogIn(ActionEvent event) {

    }

}
