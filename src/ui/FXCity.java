package ui;

import com.jfoenix.controls.*;
import exception.Reference;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
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

public class FXCity implements Initializable {

    private static final long serialVersionUID = 1;

    @FXML
    private StackPane stackPane;

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

    //********* Text Field *********\\
    @FXML
    private JFXTextField txtCodeCity;

    @FXML
    private JFXTextField txtNameCity;

    @FXML
    private JFXTextField txtSearchClient;

    //********* Button City *********\\
    @FXML
    private Button btnNewCity;

    @FXML
    private Button btnSaveCity;

    @FXML
    private Button btnEditCity;

    @FXML
    private Button btnRemoveCity;

    @FXML
    private Button btnSearchCity;

    //********* Table City *********\\
    @FXML
    private TableView<City> tblCity;

    @FXML
    private TableColumn<City, Integer> tblcCodeCity;

    @FXML
    private TableColumn<City, String> tblcNameCity;

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
        initializeButtons();
    }

    @FXML
    public void onNewCity(ActionEvent event) {
        txtCodeCity.setText(rc.getCode() + "");
        statButtonsWhenNew(true);
    }

    @FXML
    public void onSaveCity(ActionEvent event) throws IOException {
        if (!txtNameCity.getText().equals("")) {
            if (rc.addCity(rc.getCode(), txtNameCity.getText(), 0)) {
                fxGUI.showAlert(true, "La Ciudad se ha creado con exito", stackPane);
                statButtonsWhenNew(false);
                fxGUI.saveData();
                onTableListCities();
                txtNameCity.clear();
                txtCodeCity.clear();
                initializeButtons();
            } else {
                fxGUI.showAlert(false, "Ya existe una ciudad con este nombre", stackPane);
                txtNameCity.clear();
            }
        } else {
            fxGUI.showAlert(false, "Por favor, llena todos los campos", stackPane);
        }
    }

    public void statButtonsWhenNew(boolean stat) {
        btnNewCity.setDisable(stat);
        btnSaveCity.setDisable(!stat);
        btnEditCity.setDisable(stat);
        btnRemoveCity.setDisable(stat);
        btnSearchCity.setDisable(stat);
    }

    public void initializeButtons() {
        btnNewCity.setDisable(false);
        btnSaveCity.setDisable(true);
        btnRemoveCity.setDisable(true);
        btnEditCity.setDisable(true);
    }

    public void onTableListCities() {
        List<City> cities = rc.getListCities();
        ObservableList<City> newTableCities;
        newTableCities = FXCollections.observableArrayList(cities);

        tblCity.setItems(newTableCities);
        tblcCodeCity.setCellValueFactory(new PropertyValueFactory<>("codeCi"));
        tblcNameCity.setCellValueFactory(new PropertyValueFactory<>("nameCi"));

        tblCity.refresh();
    }

    @FXML
    public void onSelectCity(MouseEvent event) {
        City citySelected;
        if (event.getClickCount() == 2) {
            citySelected = tblCity.getSelectionModel().getSelectedItem();
            if (citySelected != null) {
                fxGUI.showAlert(true, "Ciudad seleccionada con exito", stackPane);
                fxGUI.setSelectObjectCode(citySelected.getCodeCi());
                txtCodeCity.setText(citySelected.getCodeCi() + "");
                txtNameCity.setText(citySelected.getNameCi());
                btnNewCity.setDisable(true);
                btnSaveCity.setDisable(true);
                btnEditCity.setDisable(false);
                btnRemoveCity.setDisable(false);
            }
        }
    }

    @FXML
    public void onRemoveCity(ActionEvent event) throws IOException {
        try {
            rc.removeCity(fxGUI.getSelectObjectCode());
            fxGUI.showAlert(true, "Ciudad eliminada con exito", stackPane);
            onTableListCities();
            txtCodeCity.setText("");
            txtNameCity.setText("");
            fxGUI.saveData();
        } catch (Reference ex) {
            fxGUI.showAlert(false, "Esta ciudad esta referenciada en otro objeto, no se elimino", stackPane);
            txtCodeCity.setText("");
            txtNameCity.setText("");
        }
        initializeButtons();
        fxGUI.setSelectObjectCode(0);
    }

    @FXML
    public void onEditCity(ActionEvent event) throws IOException {
        if (!txtNameCity.getText().equals("")) {
            if (rc.uptadeCity(fxGUI.getSelectObjectCode(), txtNameCity.getText())) {
                fxGUI.showAlert(true, "Se ha actualizado correctamente", stackPane);
                fxGUI.saveData();
                onTableListCities();
            } else {
                fxGUI.showAlert(false, "No se ha actualizado,\n debido a que hay otra ciudad con el mismo nombre", stackPane);
            }
        } else {
            fxGUI.showAlert(false, "No se puede actualizar sin un nombre\nNo se actualizo", stackPane);
        }
        txtCodeCity.setText("");
        txtNameCity.setText("");
        initializeButtons();
        fxGUI.setSelectObjectCode(0);
    }

    public void onTableSearchCity(String name) {
        tblCity.getItems().clear();

        List<City> cities = rc.searchCityName(name);
        ObservableList<City> newTableCities;
        newTableCities = FXCollections.observableArrayList(cities);

        tblCity.setItems(newTableCities);
        tblcCodeCity.setCellValueFactory(new PropertyValueFactory<>("codeCi"));
        tblcNameCity.setCellValueFactory(new PropertyValueFactory<>("nameCi"));

        tblCity.refresh();
    }

    @FXML
    public void onSearchCity(ActionEvent event) {
        if(!txtSearchClient.getText().equals("")){
        onTableSearchCity(txtSearchClient.getText());
        } else {
            fxGUI.showAlert(false, "Por favor ingresa un criterio de busquedad", stackPane);
        }
    }

}
