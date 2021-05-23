package ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.*;

public class FXCity implements Initializable {

    //********* Set Images *********\\
    @FXML
    private ImageView iAddCity;

    @FXML
    private ImageView iSaveCity;

    @FXML
    private ImageView iEditCity;

    @FXML
    private ImageView iRemoveCity;

    @FXML
    private ImageView iSearchCity;
    private RentingCar rc;
    private FXController fxGUI;

    public FXCity(RentingCar rc, FXController fxGUI) {
        this.rc = rc;
        this.fxGUI = fxGUI;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setImagesButton();
    }

    public void setImagesButton() {
        Image iAddCityPNG = new Image("Images/add-file.png");
        Image iSaveCityPNG = new Image("Images/save-disk.png");
        Image iEditCityPNG = new Image("Images/add-report.png");
        Image iRemoveCityPNG = new Image("Images/remove-report.png");
        Image iSearchCityPNG = new Image("Images/search.png");
        iAddCity.setImage(iAddCityPNG);
        iSaveCity.setImage(iSaveCityPNG);
        iEditCity.setImage(iEditCityPNG);
        iRemoveCity.setImage(iRemoveCityPNG);
        iSearchCity.setImage(iSearchCityPNG);
    }
}
