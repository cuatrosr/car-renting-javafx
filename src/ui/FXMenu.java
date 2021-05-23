package ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.*;

public class FXMenu implements Initializable {

    @FXML
    private Pane pMainMenu;

    //********* Set Images *********\\
    @FXML
    private ImageView iVehicle;

    @FXML
    private ImageView iClient;

    @FXML
    private ImageView iRent;

    @FXML
    private ImageView iDevol;

    @FXML
    private ImageView iReport;

    private RentingCar rc;
    private FXController fxGUI;

    public FXMenu(RentingCar rc, FXController fxGUI) {
        this.rc = rc;
        this.fxGUI = fxGUI;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setImagesButton();
        fxGUI.disablePane(pMainMenu, false);
    }

    public void setImagesButton() {
        Image iVehiclePNG = new Image("Images/vehicles.png");
        Image iClientPNG = new Image("Images/clients.png");
        Image iRentPNG = new Image("Images/car-key.png");
        Image iDevolPNG = new Image("Images/return.png");
        Image iReportPNG = new Image("Images/report.png");
        iVehicle.setImage(iVehiclePNG);
        iClient.setImage(iClientPNG);
        iRent.setImage(iRentPNG);
        iDevol.setImage(iDevolPNG);
        iReport.setImage(iReportPNG);
    }

    @FXML
    public void onGClient(ActionEvent event) throws IOException {
        fxGUI.disablePane(pMainMenu, true);
        fxGUI.showGClient();
    }

    @FXML
    public void onGVehicle(ActionEvent event) throws IOException {
        fxGUI.disablePane(pMainMenu, true);
        fxGUI.showGVehicle();
    }
}
