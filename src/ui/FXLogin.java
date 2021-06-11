package ui;

import model.*;
import thread.*;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 *
 * @author DELL
 */
public class FXLogin {

    private static final long serialVersionUID = 1;
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

    /**
     *
     * @param rc
     * @param fxGUI
     * @throws IOException
     */
    public FXLogin(RentingCar rc, FXController fxGUI) throws IOException {
        this.rc = rc;
        this.fxGUI = fxGUI;
    }

    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    public void onCreateAccount(ActionEvent event) throws IOException {
        fxGUI.showRegister();
    }

    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    public void onLogIn(ActionEvent event) throws IOException {
        boolean login = checkLogin();
        if (login) {
            fxGUI.closeStage(fxGUI.getPMain());
            fxGUI.closeStage(mainPane);
            //fxGUI.showMenu();
            ThreadChangeWindow hil = new ThreadChangeWindow(this, fxGUI);
            hil.run();
        }
    }

    private boolean checkLogin() {
        try {
            if (!txtUserLogin.getText().equals("") && !txtPassWordLogin.getText().equals("")) {
                boolean login = rc.loginEmployee(txtUserLogin.getText(), txtPassWordLogin.getText());
                if (login) {
                    return true;
                } else {
                    fxGUI.showAlert(false, "Usuario o Contraseña Incorrecta!", stackPane);
                    return false;
                }
            } else {
                fxGUI.showAlert(false, "Debes llenar todos los campos!", stackPane);
                return false;
            }
        } catch (NullPointerException e) {
            fxGUI.showAlert(false, "Base de datos vacia", stackPane);
            return false;
        }
    }
}
