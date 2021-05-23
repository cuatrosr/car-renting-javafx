package ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.*;

public class FXVehicle implements Initializable {

    //********* Set Images *********\\
    @FXML
    private ImageView iAddVehicle;

    @FXML
    private ImageView iSaveVehicle;

    @FXML
    private ImageView iEditVehicle;

    @FXML
    private ImageView iRemoveVehicle;

    @FXML
    private ImageView iPrevVehicle;

    @FXML
    private ImageView iNextVehicle;

    @FXML
    private ImageView iSearchVehicle;

    @FXML
    private ImageView iSelectPhotoVehicle;

    private RentingCar rc;
    private FXController fxGUI;

    public FXVehicle(RentingCar rc, FXController fxGUI) {
        this.rc = rc;
        this.fxGUI = fxGUI;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setImagesButton();
    }

    public void setImagesButton() {
        Image iAddVehiclePNG = new Image("Images/add-file.png");
        Image iSaveVehiclePNG = new Image("Images/save-disk.png");
        Image iEditVehiclePNG = new Image("Images/add-report.png");
        Image iRemoveVehiclePNG = new Image("Images/remove-report.png");
        Image iPrevVehiclePNG = new Image("Images/back-button.png");
        Image iNextVehiclePNG = new Image("Images/next-button.png");
        Image iSearchVehiclePNG = new Image("Images/search.png");
        Image iSelectPhotoVechiclePNG = new Image("Images/picture.png");
        iAddVehicle.setImage(iAddVehiclePNG);
        iSaveVehicle.setImage(iSaveVehiclePNG);
        iEditVehicle.setImage(iEditVehiclePNG);
        iRemoveVehicle.setImage(iRemoveVehiclePNG);
        iPrevVehicle.setImage(iPrevVehiclePNG);
        iNextVehicle.setImage(iNextVehiclePNG);
        iSearchVehicle.setImage(iSearchVehiclePNG);
        iSelectPhotoVehicle.setImage(iSelectPhotoVechiclePNG);
    }
}
