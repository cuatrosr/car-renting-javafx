package ui;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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

    //********* Text Fields *********\\
    @FXML
    private JFXTextField txtCodeTypeV;

    @FXML
    private JFXTextField txtNameTypeV;

    @FXML
    private JFXTextField txtQuialityTypeV;

    //********* Buttons TypeV *********\\
    @FXML
    private Button btnNewTypeV;

    @FXML
    private Button btnSaveTypeV;

    @FXML
    private Button btnEditTypeV;

    @FXML
    private Button btnRemoveTypeV;
    
    @FXML
    private Button btnSearchTypeV;

    //********* Table TypeV *********\\
    @FXML
    private TableView<TypeV> tblTypeV;

    @FXML
    private TableColumn<TypeV, Integer> tblcCodeTypeV;

    @FXML
    private TableColumn<TypeV, String> tblcNameTypeV;

    @FXML
    private TableColumn<TypeV, Integer> tblcQuialityTypeV;

    private RentingCar rc;
    private FXController fxGUI;

    public FXType(RentingCar rc, FXController fxGUI) {
        this.rc = rc;
        this.fxGUI = fxGUI;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setImagesButton();
        btnInitializae();
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

    public void btnInitializae() {
        btnNewTypeV.setDisable(false);
        btnSaveTypeV.setDisable(true);
        btnEditTypeV.setDisable(true);
        btnRemoveTypeV.setDisable(true);
        btnSearchTypeV.setDisable(false);
    }

    public void statButtonsWhenNew(boolean stat) {
        btnNewTypeV.setDisable(stat);
        btnSaveTypeV.setDisable(!stat);
        btnEditTypeV.setDisable(stat);
        btnRemoveTypeV.setDisable(stat);
        btnSearchTypeV.setDisable(stat);
    }

    @FXML
    public void onNewTypeV(ActionEvent event) {
        txtCodeTypeV.setText(rc.getCode() + "");
        statButtonsWhenNew(true);
    }

    @FXML
    public void onSaveTypeV(ActionEvent event) {

    }

    @FXML
    public void onEditTypeV(ActionEvent event) {

    }

    @FXML
    public void onRemoveTypeV(ActionEvent event) {

    }

    @FXML
    public void onSelectTypeV(MouseEvent event) {

    }
}
