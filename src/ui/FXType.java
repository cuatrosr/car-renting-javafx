package ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.*;

public class FXType implements Initializable {

    private static final long serialVersionUID = 1;
    //********* Set Images *********\\
    @FXML
    private ImageView iAddType;

    @FXML
    private ImageView iSaveType;

    @FXML
    private ImageView iEditType;

    @FXML
    private ImageView iRemoveType;

    @FXML
    private ImageView iSearchType;

    private RentingCar rc;
    private FXController fxGUI;

    public FXType(RentingCar rc, FXController fxGUI) {
        this.rc = rc;
        this.fxGUI = fxGUI;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setImagesButton();
    }

    public void setImagesButton() {
        Image iAddTypePNG = new Image("Images/add-file.png");
        Image iSaveTypePNG = new Image("Images/save-disk.png");
        Image iEditTypePNG = new Image("Images/add-report.png");
        Image iRemoveTypePNG = new Image("Images/remove-report.png");
        Image iSearchTypePNG = new Image("Images/search.png");
        iAddType.setImage(iAddTypePNG);
        iSaveType.setImage(iSaveTypePNG);
        iEditType.setImage(iEditTypePNG);
        iRemoveType.setImage(iRemoveTypePNG);
        iSearchType.setImage(iSearchTypePNG);
    }

}
