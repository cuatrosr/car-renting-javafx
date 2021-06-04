package ui;

import com.jfoenix.controls.JFXTextField;
import exception.Reference;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.layout.StackPane;
import model.*;

public class FXType implements Initializable {

    private static final long serialVersionUID = 1;

    @FXML
    private StackPane stackPane;

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
        onTableListTypeV();
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
    public void onSaveTypeV(ActionEvent event) throws IOException {
        if (!txtNameTypeV.getText().equals("") && !txtQuialityTypeV.getText().equals("")) {
            try {
                if (rc.addTypeV(Integer.parseInt(txtQuialityTypeV.getText()), 0, rc.getCode(), txtNameTypeV.getText())) {
                    fxGUI.showAlert(true, "Se ha creado correctamente el tipo de vehículo", stackPane);
                    fxGUI.saveData();
                    txtNameTypeV.clear();
                    txtQuialityTypeV.clear();
                    txtCodeTypeV.clear();
                    btnInitializae();
                    onTableListTypeV();
                } else {
                    fxGUI.showAlert(false, "Ya se encuentra otro tipo de vehiculo con el mismo nombre", stackPane);
                    txtNameTypeV.clear();
                }
            } catch (NumberFormatException e) {
                fxGUI.showAlert(false, "Por favor ingresa un numero en el apartado de calidad", stackPane);
                txtQuialityTypeV.clear();
            }
        } else {
            fxGUI.showAlert(false, "Por favor, llena todos los campos", stackPane);
        }
    }

    @FXML
    public void onEditTypeV(ActionEvent event) throws IOException {
        if (!txtNameTypeV.getText().equals("") && !txtQuialityTypeV.getText().equals("")) {
            try {
                if (rc.uptadeTypeV(fxGUI.getSelectObjectCode(), txtNameTypeV.getText(), Integer.parseInt(txtQuialityTypeV.getText()))) {
                    fxGUI.showAlert(true, "Se ha actualizado correctamente el tipo de vehículo", stackPane);
                    fxGUI.saveData();
                    onTableListTypeV();
                } else {
                    fxGUI.showAlert(false, "Ya existe otro tipo de vehículo con el mismo nombre, no se actualizo", stackPane);
                }
            } catch (NumberFormatException e) {
                fxGUI.showAlert(false, "Por favor ingresa un numero en el apartado de calidad, no se actualizo", stackPane);
            }
        } else {
            fxGUI.showAlert(false, "Por favor, ingresa todos los campos\nNo se actualizo", stackPane);
        }
        fxGUI.setSelectObjectCode(0);
        txtCodeTypeV.clear();
        txtNameTypeV.clear();
        txtQuialityTypeV.clear();
        btnInitializae();
    }

    @FXML
    public void onRemoveTypeV(ActionEvent event) throws IOException {
        try {
            rc.removTypeV(fxGUI.getSelectObjectCode());
            fxGUI.showAlert(true, "Tipo de vehículo eliminado con exito", stackPane);
            onTableListTypeV();
            txtCodeTypeV.clear();
            txtNameTypeV.clear();
            txtQuialityTypeV.clear();
            fxGUI.saveData();
        } catch (Reference e) {
            fxGUI.showAlert(false, "Este tipo de vehículo este referneciado en\notro objeto, no se elimino", stackPane);
            txtCodeTypeV.clear();
            txtNameTypeV.clear();
            txtQuialityTypeV.clear();
        }
        btnInitializae();
        fxGUI.setSelectObjectCode(0);
    }

    @FXML
    public void onSelectTypeV(MouseEvent event) {
        TypeV typeVSelected;
        if (event.getClickCount() == 2) {
            typeVSelected = tblTypeV.getSelectionModel().getSelectedItem();
            if (typeVSelected != null) {
                fxGUI.showAlert(true, "Se ha seleccionado el tipo correctamente", stackPane);
                fxGUI.setSelectObjectCode(typeVSelected.getCodeA());
                txtCodeTypeV.setText(typeVSelected.getCodeA() + "");
                txtNameTypeV.setText(typeVSelected.getNameTB());
                txtQuialityTypeV.setText(typeVSelected.getQuality() + "");
                btnNewTypeV.setDisable(true);
                btnSaveTypeV.setDisable(true);
                btnRemoveTypeV.setDisable(false);
                btnEditTypeV.setDisable(false);
            }
        }
    }

    public void onTableListTypeV() {
        List<TypeV> types = rc.getListTypeV();
        ObservableList<TypeV> newTableTypeV;
        newTableTypeV = FXCollections.observableArrayList(types);

        tblTypeV.setItems(newTableTypeV);
        tblcCodeTypeV.setCellValueFactory(new PropertyValueFactory<>("codeA"));
        tblcNameTypeV.setCellValueFactory(new PropertyValueFactory<>("nameTB"));
        tblcQuialityTypeV.setCellValueFactory(new PropertyValueFactory<>("quality"));

        tblTypeV.refresh();
    }
}
