package ui;

import com.jfoenix.controls.JFXTextField;
import exception.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import model.*;

public class FXBrand implements Initializable {

    private static final long serialVersionUID = 1;

    @FXML
    private StackPane stackPane;

    @FXML
    private Pane bPane;

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

    //******** Buttons ID **********\\
    @FXML
    private Button btnNewBrand;

    @FXML
    private Button btnSaveBrand;

    @FXML
    private Button btnEditBrand;

    @FXML
    private Button btnRemoveBrand;

    @FXML
    private Button btnSearchBrand;

    //******* Text Fields ********\\
    @FXML
    private JFXTextField txtCodeBrand;

    @FXML
    private JFXTextField txtNameBrand;

    @FXML
    private JFXTextField txtCountryBrand;

    //******* Table Brand ********\\
    @FXML
    private TableView<Brand> tblBrand;

    @FXML
    private TableColumn<Brand, Integer> tblcCodeBrand;

    @FXML
    private TableColumn<Brand, String> tblcNameBrand;

    @FXML
    private TableColumn<Brand, String> tblcCountryBrand;

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
        btnInitialize();
        onTableListBrand();
    }

    public void btnInitialize() {
        btnNewBrand.setDisable(false);
        btnSaveBrand.setDisable(true);
        btnEditBrand.setDisable(true);
        btnRemoveBrand.setDisable(true);
        btnSearchBrand.setDisable(false);
    }

    public void statButtonsWhenNew(boolean stat) {
        btnNewBrand.setDisable(stat);
        btnSaveBrand.setDisable(!stat);
        btnEditBrand.setDisable(stat);
        btnRemoveBrand.setDisable(stat);
        btnSearchBrand.setDisable(stat);
    }

    @FXML
    public void onNewBrand(ActionEvent event) {
        statButtonsWhenNew(true);
        txtCodeBrand.setText(rc.getCode() + "");
    }

    @FXML
    public void onSaveBrand(ActionEvent event) throws IOException {
        if (!txtNameBrand.getText().equals("") && !txtCountryBrand.getText().equals("")) {
            if (rc.addBrand(txtCountryBrand.getText(), 0, rc.getCode(), txtNameBrand.getText())) {
                fxGUI.showAlert(true, "Se ha creado la marca correctamente", stackPane);
                fxGUI.saveData();
                txtCodeBrand.clear();
                txtCountryBrand.clear();
                txtNameBrand.clear();
                btnInitialize();
                onTableListBrand();
            } else {
                fxGUI.showAlert(false, "Ya se encuentra otra marca con\neste nombre, ingresa otro nombre", stackPane);
                txtNameBrand.clear();
            }
        } else {
            fxGUI.showAlert(false, "Por favor, llena todos los campos", stackPane);
        }
    }

    @FXML
    public void onEditBrand(ActionEvent event) throws IOException {
        if (!txtNameBrand.getText().equals("") && !txtCountryBrand.getText().equals("")) {
            if (rc.uptadeBrand(fxGUI.getSelectObjectCode(), txtNameBrand.getText(), txtCountryBrand.getText())) {
                fxGUI.showAlert(true, "Se ha actualizado correctamente la marca", stackPane);
                fxGUI.saveData();
                onTableListBrand();
            } else {
                fxGUI.showAlert(false, "Ya existe otra marca con el mismo nombre, no se actualizo", stackPane);
            }
        } else {
            fxGUI.showAlert(false, "Por favor, ingresa todos los datos necesarion", stackPane);
        }
        fxGUI.setSelectObjectCode(0);
        txtCodeBrand.clear();
        txtNameBrand.clear();
        txtCountryBrand.clear();
        btnInitialize();
    }

    @FXML
    public void onRemoveBrand(ActionEvent event) throws IOException {
        try {
            rc.removeBrand(fxGUI.getSelectObjectCode());
            fxGUI.showAlert(true, "Se ha eliminado la marca correctamente", stackPane);
            fxGUI.saveData();
            onTableListBrand();
            txtCodeBrand.clear();
            txtNameBrand.clear();
            txtCountryBrand.clear();
        } catch (Reference e) {
            fxGUI.showAlert(false, "Esta marca esta referenciada en otro objeto\nNo se elimino", stackPane);
            txtCodeBrand.clear();
            txtNameBrand.clear();
            txtCountryBrand.clear();
        }
        btnInitialize();
    }

    @FXML
    public void onSearchBrand(ActionEvent event) {

    }

    @FXML
    public void onSelectBrand(MouseEvent event) {
        Brand brandSelected;
        if (event.getClickCount() == 2) {
            brandSelected = tblBrand.getSelectionModel().getSelectedItem();
            if (brandSelected != null) {
                fxGUI.showAlert(true, "Marca seleccionada correctamente", stackPane);
                fxGUI.setSelectObjectCode(brandSelected.getCodeA());
                txtCodeBrand.setText(brandSelected.getCodeA() + "");
                txtNameBrand.setText(brandSelected.getNameTB());
                txtCountryBrand.setText(brandSelected.getCountry());
                btnNewBrand.setDisable(true);
                btnSaveBrand.setDisable(true);
                btnEditBrand.setDisable(false);
                btnRemoveBrand.setDisable(false);
            }
        }
    }

    public void onTableListBrand() {
        List<Brand> brands = rc.getListBrand();
        ObservableList<Brand> newTableBrand;
        newTableBrand = FXCollections.observableArrayList(brands);

        tblBrand.setItems(newTableBrand);
        tblcCodeBrand.setCellValueFactory(new PropertyValueFactory<>("codeA"));
        tblcNameBrand.setCellValueFactory(new PropertyValueFactory<>("nameTB"));
        tblcCountryBrand.setCellValueFactory(new PropertyValueFactory<>("country"));

        tblBrand.refresh();
    }
}
