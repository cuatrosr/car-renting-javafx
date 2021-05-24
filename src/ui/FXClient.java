package ui;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.*;

public class FXClient {

    @FXML
    private Pane pClient;

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

    public void setImagesList() {
        Image iSearchClientPNG = new Image("Images/search.png");
        iSearchInListClient.setImage(iSearchClientPNG);
    }
    
    public Pane getPane(){
        return pClient;
    }

    @FXML
    public void onGCity(ActionEvent event) throws IOException {
        fxGUI.disablePane(pClient, true);
        fxGUI.showGCity(false);
    }

    @FXML
    public void onListClients(ActionEvent event) throws IOException {
        fxGUI.disablePane(pClient, true);
        fxGUI.showListClient(true);
    }
}
