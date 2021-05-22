package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import model.*;

public class LoginController {

    // ************ Controllers ************
    @SuppressWarnings("FieldMayBeFinal")
    private RentingCar rc;
    @SuppressWarnings("FieldMayBeFinal")
    private FXMainController fxGUI;

    // ************ ID's ************
    @FXML
    private Pane mainPane;

    @FXML
    private StackPane stackPane;

    @FXML
    private JFXTextField txtUserLogin;

    @FXML
    private JFXPasswordField txtPassWordLogin;
    

    public LoginController(FXMainController fxGUI, RentingCar rc) {
        this.rc = rc;
        this.fxGUI = fxGUI;
    }

    public Pane getPane() {
        return mainPane;
    }

    @FXML
    public void onCreateAccount(ActionEvent event) throws IOException {
        fxGUI.showPaneRegister();
    }
}
