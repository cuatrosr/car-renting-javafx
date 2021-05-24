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
    
    public Pane getPane(){
        return pMainMenu;
    }

    @FXML
    public void onGClient(ActionEvent event) throws IOException {
        fxGUI.disablePane(pMainMenu, true);
        fxGUI.showGClient();
    }

    @FXML
    public void onGVehicle(ActionEvent event) throws IOException {
        //fxGUI.disablePane(pMainMenu, true);
        fxGUI.showGVehicle();
    }

    @FXML
    public void onGDevol(ActionEvent event) throws IOException {
        //fxGUI.disablePane(pMainMenu, true);
        fxGUI.showGDevolution();
    }

    @FXML
    public void onGRent(ActionEvent event) throws IOException {
        //fxGUI.disablePane(pMainMenu, true);
        fxGUI.showGRent();
    }

    @FXML
    public void onGReport(ActionEvent event) throws IOException {
        //fxGUI.disablePane(pMainMenu, true);
        fxGUI.showSelectReport();
    }

    @FXML
    public void onExit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    public void onGBrand(ActionEvent event) throws IOException {
        fxGUI.showGBrand();
    }

    @FXML
    public void onGCity(ActionEvent event) throws IOException {
        fxGUI.showGCity();
    }

    @FXML
    public void onGType(ActionEvent event) throws IOException {
        fxGUI.showGType();
    }

    @FXML
    public void onListEmployee(ActionEvent event) throws IOException {
        fxGUI.showListEmployee();
    }

    @FXML
    public void onRClient(ActionEvent event) throws IOException {
        fxGUI.showReportClient();
    }

    @FXML
    public void onRRent(ActionEvent event) throws IOException {
        fxGUI.showReportRent();
        
    }

    @FXML
    public void onRVehicle(ActionEvent event) throws IOException {
        fxGUI.showReportVehicles();
    }

    @FXML
    public void onTopEmployee(ActionEvent event) throws IOException {
        fxGUI.showTopEmployee();
    }
}
