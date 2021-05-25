package ui;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.*;

public class FXRent {

    private static final long serialVersionUID = 1;
    @FXML
    private Pane rPane;

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

    public void setImagesList() {
        Image iSearchRentPNG = new Image("Images/search.png");
        iSearchIDRent.setImage(iSearchRentPNG);
        iSearchTicketRent.setImage(iSearchRentPNG);
    }

    public Pane getPane() {
        return rPane;
    }

    @FXML
    public void onSearchClientsInRent(ActionEvent event) throws IOException {
        fxGUI.disablePane(rPane, true);
        fxGUI.showListClient(false);
    }

    @FXML
    public void onSearchVehicleInRent(ActionEvent event) throws IOException {
        fxGUI.disablePane(rPane, true);
        fxGUI.showListVehicle(false);
    }
}
