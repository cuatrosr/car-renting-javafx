package ui;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.*;

public class FXController {

    @FXML
    private Pane pMain;

    private RentingCar rc;
    private FXLogin xLogin;
    private FXRegister xRegister;
    private FXMenu xMenu;
    private FXClient xClient;
    private FXVehicle xVehicle;

    public FXController(RentingCar rc) {
        this.rc = new RentingCar();
        xLogin = new FXLogin(rc, this);
        xRegister = new FXRegister(rc, this);
        xMenu = new FXMenu(rc, this);
        xClient = new FXClient(rc, this);
    }

    public void newStage(Parent root) {
        Stage newStage = new Stage();
        Scene scene = new Scene(root);
        newStage.setScene(scene);
        newStage.setTitle("RentingCar");
        newStage.setResizable(false);
        newStage.show();
    }

    public void closeStage(Pane bpMain) {
        Stage stage = (Stage) bpMain.getScene().getWindow();
        stage.close();
    }

    public void disablePane(Pane bpMain, boolean status) {
        bpMain.setDisable(status);
    }

    public void showLogin() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/Login.fxml"));
        fxmlLoader.setController(xLogin);
        Parent root = fxmlLoader.load();
        pMain.getChildren().setAll(root);
    }

    public Pane getPMain() {
        return pMain;
    }

    public void showRegister() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/Register.fxml"));
        fxmlLoader.setController(xRegister);
        Parent root = fxmlLoader.load();
        pMain.getChildren().setAll(root);
    }

    public void showMenu() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/Menu.fxml"));
        fxmlLoader.setController(xMenu);
        Parent root = fxmlLoader.load();
        newStage(root);
    }

    public void showGClient() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/AddClient.fxml"));
        fxmlLoader.setController(xClient);
        Parent root = fxmlLoader.load();
        newStage(root);
    }

    public void showGVehicle() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/AddVehicle.fxml"));
        fxmlLoader.setController(xVehicle);
        Parent root = fxmlLoader.load();
        newStage(root);
    }
}
