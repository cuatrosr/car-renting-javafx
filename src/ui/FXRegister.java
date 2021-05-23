package ui;

import model.*;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class FXRegister {

    @FXML
    private BorderPane bpMain;

    @FXML
    private StackPane stackPane;

    @FXML
    private JFXTextField txtRegisterName;

    @FXML
    private JFXTextField txtRegisterLastName;

    @FXML
    private JFXTextField txtRegisterID;

    @FXML
    private JFXTextField txtRegisterUserName;

    @FXML
    private JFXPasswordField txtRegisterPassword;

    @FXML
    private JFXPasswordField txtRegisterPassword1;

    private RentingCar rc;
    private FXController fxGUI;

    public FXRegister(RentingCar rc, FXController fxGUI) {
        this.rc = rc;
        this.fxGUI = fxGUI;
    }

    @FXML
    public void onIhaveAccount(ActionEvent event) throws IOException {
        fxGUI.showLogin();
    }

    @FXML
    public void onRegister(ActionEvent event) throws IOException{
        fxGUI.closeStage(fxGUI.getPMain());
        fxGUI.closeStage(bpMain);
        fxGUI.showMenu();
    } 
}
