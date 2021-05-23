package ui;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import model.*;

public class FXController {

    @FXML
    private Pane pMain;

    private RentingCar rc;
    private FXLogin xLogin;

    public FXController(RentingCar rc) {
        this.rc = new RentingCar();
        xLogin = new FXLogin(rc, this);
    }

    public void showLogin() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/Login.fxml"));
        fxmlLoader.setController(xLogin);
        Parent root = fxmlLoader.load();
        pMain.getChildren().setAll(root);
    }
}
