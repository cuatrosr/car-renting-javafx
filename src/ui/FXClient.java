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

public class FXClient implements Initializable {

    //********* Set Images *********\\
    @FXML
    private ImageView iAddClient;

    @FXML
    private ImageView iSaveClient;

    @FXML
    private ImageView iEditClient;

    @FXML
    private ImageView iRemoveClient;

    @FXML
    private ImageView iOpenCity;

    @FXML
    private ImageView iSearchClient;

    @FXML
    private ImageView iSearchInListClient;

    private RentingCar rc;
    private FXController fxGUI;

    public FXClient(RentingCar rc, FXController fxGUI) {
        this.rc = rc;
        this.fxGUI = fxGUI;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setImagesButton();
    }

    public void setImagesButton() {
        Image iAddClientPNG = new Image("Images/add-file.png");
        Image iSaveClientPNG = new Image("Images/save-disk.png");
        Image iEditClientPNG = new Image("Images/add-report.png");
        Image iRemoveClientPNG = new Image("Images/remove-report.png");
        Image iOpenCityPNG = new Image("Images/city.png");
        Image iSearchClientPNG = new Image("Images/search.png");
        iAddClient.setImage(iAddClientPNG);
        iSaveClient.setImage(iSaveClientPNG);
        iEditClient.setImage(iEditClientPNG);
        iRemoveClient.setImage(iRemoveClientPNG);
        iOpenCity.setImage(iOpenCityPNG);
        iSearchClient.setImage(iSearchClientPNG);
    }

    @FXML
    public void onGCity(ActionEvent event) throws IOException {
        fxGUI.showGCity();
    }

    @FXML
    public void onListClients(ActionEvent event) throws IOException {
        fxGUI.showListClient();
        Image iSearchClientPNG = new Image("Images/search.png");
        iSearchInListClient.setImage(iSearchClientPNG);
    }
}
