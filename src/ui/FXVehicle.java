package ui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.*;

public class FXVehicle {

    private static final long serialVersionUID = 1;
    @FXML
    private Pane vPane;

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

    @FXML
    private ImageView iSearchInListVehicle;

    @FXML
    private JFXComboBox<String> cbTypeV;

    @FXML
    private JFXComboBox<String> cbBrandV;

    @FXML
    private Button btnNewV;

    @FXML
    private Button btnSaveV;

    @FXML
    private Button btnEditV;

    @FXML
    private Button btnRemoveV;

    @FXML
    private Button btnPrevV;

    @FXML
    private Button btnNextV;

    @FXML
    private JFXTextField txtCodeV;

    @FXML
    private JFXTextField txtPlateV;

    @FXML
    private JFXTextField txtYearV;

    @FXML
    private JFXTextField txtColorV;

    @FXML
    private JFXRadioButton rbDispVY;

    @FXML
    private ToggleGroup rbDisp;

    @FXML
    private JFXRadioButton rbDispVN;

    @FXML
    private JFXTextField txtPriceV;

    @FXML
    private JFXTextField txtModelV;

    @FXML
    private Button btnListV;

    @FXML
    private JFXButton btnImageV;

    @FXML
    private ImageView iPhotoV;

    private RentingCar rc;
    private FXController fxGUI;

    public FXVehicle(RentingCar rc, FXController fxGUI) {
        this.rc = rc;
        this.fxGUI = fxGUI;
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

    public void setImagesList() {
        Image iSearchVehiclePNG = new Image("Images/search.png");
        iSearchInListVehicle.setImage(iSearchVehiclePNG);
    }

    public Pane getPane() {
        return vPane;
    }

    @FXML
    public void onGBrand(ActionEvent event) throws IOException {
        fxGUI.disablePane(vPane, true);
        fxGUI.showGBrand(false);
    }

    @FXML
    public void onGType(ActionEvent event) throws IOException {
        fxGUI.disablePane(vPane, true);
        fxGUI.showGType(false);
    }

    @FXML
    public void onListVehicle(ActionEvent event) throws IOException {
        fxGUI.disablePane(vPane, true);
        fxGUI.showListVehicle(true);
    }

    public void showBrandDisp() {
        try {
            List<String> brandName = new ArrayList<>();
            for (int i = 0; i < rc.getListBrand().size(); i++) {
                brandName.add(rc.getListBrand().get(i).getNameTB());
            }

            ObservableList<String> obs;
            obs = FXCollections.observableArrayList(brandName);
            cbBrandV.setItems(obs);
        } catch (NullPointerException e) {
        }
    }

    public void showTypeDisp() {
        try {
            List<String> typeName = new ArrayList<>();
            for (int i = 0; i < rc.getListTypeV().size(); i++) {
                typeName.add(rc.getListTypeV().get(i).getNameTB());
            }

            ObservableList<String> obs;
            obs = FXCollections.observableArrayList(typeName);
            cbTypeV.setItems(obs);
        } catch (NullPointerException e) {
        }
    }

    @FXML
    public void onSelectImageV(ActionEvent event) {

    }

    @FXML
    void onNewV(ActionEvent event) {
        statButtonsWhenNew(true);
        txtCodeV.setText(rc.getCode() + "");
    }

    public void statButtonsWhenNew(boolean stat) {
        btnNewV.setDisable(stat);
        btnSaveV.setDisable(!stat);
        btnEditV.setDisable(stat);
        btnRemoveV.setDisable(stat);
        btnPrevV.setDisable(stat);
        btnNextV.setDisable(stat);
        btnListV.setDisable(stat);
        btnImageV.setDisable(!stat);
    }

    public void btnInitialize() {
        btnNewV.setDisable(false);
        btnSaveV.setDisable(true);
        btnEditV.setDisable(true);
        btnRemoveV.setDisable(true);
        btnPrevV.setDisable(false);
        btnNextV.setDisable(false);
        btnImageV.setDisable(true);
        btnListV.setDisable(false);
    }

    @FXML
    public void onSaveV(ActionEvent event) {
        if (!txtCodeV.getText().equals("") && cbBrandV.getValue() != null && cbTypeV.getValue() != null && !txtPlateV.getText().equals("") 
                && !txtYearV.getText().equals("") && !txtColorV.getText().equals("") && !txtPriceV.getText().equals("") && !txtModelV.getText().equals("") && rbDisp.getSelectedToggle() != null) {
            try {
                boolean added = rc.addCar(txtModelV.getText(), txtColorV.getText(), rc.findBrandSelected(cbBrandV.getValue()), rc.findTypeVSelected(cbTypeV.getValue()), Double.parseDouble(txtPriceV.getText()), rc.getCode(), txtPlateV.getText(), getSelectedDisp(), null, Integer.parseInt(txtYearV.getText()));
                if (added) {
                    System.out.println("Se agrego");
                } else {
                    System.out.println("No se agrego");
                }
            } catch (NumberFormatException e) {
                System.out.println("Num");
            }
        } else {
            System.out.println("rellene");
        }
    }
    
    public boolean getSelectedDisp() {
        if (rbDispVY.isSelected()) {
            return true;
        } else {
            return false;
        }
    }
}
