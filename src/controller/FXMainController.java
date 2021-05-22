package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.*;

public class FXMainController implements Initializable{

    @FXML
    private Pane pMain;

    @SuppressWarnings("FieldMayBeFinal")
    private RentingCar rc;
    @SuppressWarnings("FieldMayBeFinal")
    private LoginController loginC;

    public FXMainController(RentingCar rc) {
        this.rc = rc;
        loginC = new LoginController(this, rc);
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Sapa hpta");
    }
    
    public void newStage(Parent root) {
        Stage newStage = new Stage();
        Scene scene = new Scene(root);
        newStage.setScene(scene);
        newStage.setTitle("Renting Car");
        newStage.setResizable(false);
        newStage.show();
    }

    public void closeStage(Pane bpMain) {
        Stage stage = (Stage) bpMain.getScene().getWindow();
        stage.close();
    }

    public void showPaneLogin() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/Login.fxml"));
        fxmlLoader.setController(loginC);
        Parent root = fxmlLoader.load();
        newStage(root);
    }

    public void showPaneRegister() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/Register.fxml"));
        fxmlLoader.setController(loginC);
        Parent root = fxmlLoader.load();
        newStage(root);

    }
}
