package ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.*;

public class FXBrand implements Initializable {

    //********* Set Images *********\\
    @FXML
    private ImageView iAddBrand;

    @FXML
    private ImageView iSaveBrand;

    @FXML
    private ImageView iEditBrand;

    @FXML
    private ImageView iRemoveBrand;

    @FXML
    private ImageView iSearchBrand;

    private RentingCar rc;
    private FXController fxGUI;

    public FXBrand(RentingCar rc, FXController fxGUI) {
        this.rc = rc;
        this.fxGUI = fxGUI;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setImagesButton();
    }

    public void setImagesButton() {
        Image iAddBrandPNG = new Image("Images/add-file.png");
        Image iSaveBrandPNG = new Image("Images/save-disk.png");
        Image iEditBrandPNG = new Image("Images/add-report.png");
        Image iRemoveBrandPNG = new Image("Images/remove-report.png");
        Image iSearchBrandPNG = new Image("Images/search.png");
        iAddBrand.setImage(iAddBrandPNG);
        iSaveBrand.setImage(iSaveBrandPNG);
        iEditBrand.setImage(iEditBrandPNG);
        iRemoveBrand.setImage(iRemoveBrandPNG);
        iSearchBrand.setImage(iSearchBrandPNG);
    }

}
