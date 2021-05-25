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
    private JFXPasswordField txtRegisterKey;

    private RentingCar rc;
    private FXController fxGUI;

    public FXRegister(RentingCar rc, FXController fxGUI) throws IOException {
        this.rc = rc;
        this.fxGUI = fxGUI;
    }

    @FXML
    public void onIhaveAccount(ActionEvent event) throws IOException {
        fxGUI.showLogin();
    }

    @FXML
    public void onRegister(ActionEvent event) throws IOException {
        boolean added = addRegister();
        if (added) {
            fxGUI.saveData();
            fxGUI.closeStage(fxGUI.getPMain());
            fxGUI.closeStage(bpMain);
            fxGUI.showMenu();
        }
    }

    public boolean addRegister() {
        try {
            if (!txtRegisterName.getText().equals("") && !txtRegisterLastName.getText().equals("") && !txtRegisterID.getText().equals("")
                    && !txtRegisterUserName.getText().equals("") && !txtRegisterPassword.getText().equals("") && !txtRegisterKey.getText().equals("")) {
                if (txtRegisterKey.getText().equals("x")) {
                    rc.addEmployee(txtRegisterName.getText(), txtRegisterPassword.getText(), 0, 0, rc.getCode(), 0, txtRegisterUserName.getText(), txtRegisterLastName.getText(), Long.parseLong(txtRegisterID.getText()));
                    return true;
                } else {
                    fxGUI.showAlert(true, "Acceso denegado!", stackPane);
                    return false;
                }
            } else {
                fxGUI.showAlert(false, "Porfavor, llena todo los campos!", stackPane);
                return false;
            }
        } catch (NumberFormatException e) {
            fxGUI.showAlert(false, "La identificacion debe ser numerica!", stackPane);
            return false;
        }
    }
}
