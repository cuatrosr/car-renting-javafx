package ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.*;

public class FXRent implements Initializable {

    //********* Set Images *********\\
    @FXML
    private ImageView iAddRent;

    @FXML
    private ImageView iRefreshRent;

    @FXML
    private ImageView iSelectClientRent;

    @FXML
    private ImageView iSelectVehicleRent;

    @FXML
    private ImageView iSearchTicketRent;

    @FXML
    private ImageView iSearchIDRent;

    private RentingCar rc;
    private FXController fxGUI;

    public FXRent(RentingCar rc, FXController fxGUI) {
        this.rc = rc;
        this.fxGUI = fxGUI;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setImagesButton();
    }

    public void setImagesButton() {
        Image iAddRentPNG = new Image("Images/add-file.png");
        Image iRefreshRentPNG = new Image("Images/return-sign.png");
        Image iSelectClientRentPNG = new Image("Images/clients.png");
        Image iSelectVehicleRentPNG = new Image("Images/vehicles.png");
        iAddRent.setImage(iAddRentPNG);
        iRefreshRent.setImage(iRefreshRentPNG);
        iSelectClientRent.setImage(iSelectClientRentPNG);
        iSelectVehicleRent.setImage(iSelectVehicleRentPNG);
    }
    
    public void setImagesList(){
        Image iSearchRentPNG = new Image("Images/search.png");
        iSearchIDRent.setImage(iSearchRentPNG);
        iSearchTicketRent.setImage(iSearchRentPNG);
    }

    @FXML
    public void onSearchClientsInRent(ActionEvent event) throws IOException {
        fxGUI.showListClient();
    }

    @FXML
    public void onSearchVehicleInRent(ActionEvent event) throws IOException {
        fxGUI.showListVehicle();
    }
}
