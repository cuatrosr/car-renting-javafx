package ui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import exception.Reference;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import model.*;

public class FXVehicle {

    private static final long serialVersionUID = 1;
    @FXML
    private Pane vPane;

    @FXML
    private StackPane stackPane;

    @FXML
    private StackPane stackPane1;

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

    //*********** Combo box ************\\
    @FXML
    private JFXComboBox<String> cbTypeV;

    @FXML
    private JFXComboBox<String> cbBrandV;

    //********** Buttons Vehicle ************\\
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
    private Button btnListV;

    @FXML
    private JFXButton btnImageV;

    //********* Text Field ***********\\
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
    private ImageView iPhotoV;

    @FXML
    private JFXTextField txtSearchPlateV;

    //********** Table Vehicle *********\\
    @FXML
    private TableView<Car> tblVehicle;

    @FXML
    private TableColumn<Car, Integer> tblcCodeV;

    @FXML
    private TableColumn<Car, String> tblcPlateV;

    @FXML
    private TableColumn<Car, String> tblcTypeV;

    @FXML
    private TableColumn<Car, String> tblcModelV;

    @FXML
    private TableColumn<Car, String> tblcBrandV;

    @FXML
    private TableColumn<Car, String> tblcColorV;

    @FXML
    private TableColumn<Car, Double> tblcPriceV;

    @FXML
    private TableColumn<Car, Integer> tblcYearV;

    @FXML
    private TableColumn<Car, Boolean> tblcDispV;

    private int positionCar;
    private int amountCar;
    private String imagePath;

    private RentingCar rc;
    private FXController fxGUI;

    public FXVehicle(RentingCar rc, FXController fxGUI) {
        this.rc = rc;
        this.fxGUI = fxGUI;
        positionCar = 0;
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
                brandName.add(rc.getListBrand().get(i).getNameTB() + " " + rc.getListBrand().get(i).getCountry());
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
                typeName.add(rc.getListTypeV().get(i).getNameTB() + " " + rc.getListTypeV().get(i).getQuality());
            }

            ObservableList<String> obs;
            obs = FXCollections.observableArrayList(typeName);
            cbTypeV.setItems(obs);
        } catch (NullPointerException e) {
        }
    }

    @FXML
    public void onSelectImageV(ActionEvent event) {
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Selecciona una imagen");
            fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));

            Stage stage = (Stage) vPane.getScene().getWindow();
            File iconImageR = fileChooser.showOpenDialog(stage);

            if (iconImageR != null) {
                imagePath = iconImageR.getAbsolutePath();
                iPhotoV.setImage(stringToImage(imagePath));
            } else {
                fxGUI.showAlert(false, "Por favor seleeciona una imagen", stackPane);
            }
        } catch (NullPointerException e) {
            fxGUI.showAlert(false, "Imagen no encontrada, por favor selecciona una imagen", stackPane);
        }
    }

    public Image stringToImage(String image) {
        try {
            File f = new File(image);
            Image imP = new Image(f.toURI().toString());
            return imP;
        } catch (NullPointerException e) {
        }
        return null;
    }

    @FXML
    void onNewV(ActionEvent event) {
        clearTextField();
        statButtonsWhenNew(true);
        txtCodeV.setText(rc.getCode() + "");
        iPhotoV.setImage(null);
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
    public void onSaveV(ActionEvent event) throws IOException {
        if (!txtCodeV.getText().equals("") && cbBrandV.getValue() != null && cbTypeV.getValue() != null && !txtPlateV.getText().equals("")
                && !txtYearV.getText().equals("") && !txtColorV.getText().equals("") && !txtPriceV.getText().equals("") && !txtModelV.getText().equals("") && rbDisp.getSelectedToggle() != null) {
            try {
                boolean added = rc.addCar(txtModelV.getText(), txtColorV.getText(), rc.findBrandSelected(cbBrandV.getValue()),
                        rc.findTypeVSelected(cbTypeV.getValue()), Double.parseDouble(txtPriceV.getText()), rc.getCode(),
                        txtPlateV.getText(), getSelectedDisp(), imagePath, Integer.parseInt(txtYearV.getText()));
                if (added) {
                    fxGUI.showAlert(true, "Se ha agregado el vehículo correctamente", stackPane);
                    fxGUI.saveData();
                    btnInitialize();
                    clearTextField();
                    amountCar++;
                } else {
                    fxGUI.showAlert(false, "No se agrego, ya existe otro vehículo con la misma placa", stackPane);
                    txtPlateV.clear();
                }
            } catch (NumberFormatException e) {
                fxGUI.showAlert(true, "No se agrego, no puedes ingresar letras en el precio o en el año", stackPane);
                txtPriceV.clear();
                txtYearV.clear();
            }
        } else {
            fxGUI.showAlert(false, "Por favor llene todos los campos, no se agrego", stackPane);
        }
        imagePath = "";
        iPhotoV.setImage(null);
    }

    public boolean getSelectedDisp() {
        return rbDispVY.isSelected();
    }

    public void clearTextField() {
        txtCodeV.clear();
        cbBrandV.setValue(null);
        cbTypeV.setValue(null);
        txtModelV.clear();
        txtPlateV.clear();
        txtYearV.clear();
        txtColorV.clear();
        txtPriceV.clear();
        rbDispVN.setSelected(false);
        rbDispVY.setSelected(false);
    }

    public void onTableVehicle() {
        rc.showBinaryTreeVehicle(rc.getRootNameC());

        List<Car> cars = rc.getShowRootCar();
        ObservableList<Car> newTableCar;
        newTableCar = FXCollections.observableArrayList(cars);

        tblVehicle.setItems(newTableCar);
        tblcCodeV.setCellValueFactory(new PropertyValueFactory<>("codeV"));
        tblcPlateV.setCellValueFactory(new PropertyValueFactory<>("plate"));
        tblcTypeV.setCellValueFactory(new PropertyValueFactory<>("nameType"));
        tblcModelV.setCellValueFactory(new PropertyValueFactory<>("model"));
        tblcBrandV.setCellValueFactory(new PropertyValueFactory<>("nameBrand"));
        tblcColorV.setCellValueFactory(new PropertyValueFactory<>("color"));
        tblcPriceV.setCellValueFactory(new PropertyValueFactory<>("priceXDay"));
        tblcYearV.setCellValueFactory(new PropertyValueFactory<>("year"));
        tblcDispV.setCellValueFactory(new PropertyValueFactory<>("dispV"));

        tblVehicle.refresh();
    }

    @FXML
    public void onSelecteVehicle(MouseEvent event) {
        Car selectedCar;
        if (event.getClickCount() == 2) {
            selectedCar = tblVehicle.getSelectionModel().getSelectedItem();
            if (selectedCar != null) {
                fxGUI.showAlert(true, "Se ha seleccionado el vehículo", stackPane1);
                if (!fxGUI.isOtherWindowSelected()) {
                    fxGUI.setSelectCarRent(selectedCar.getCodeV());
                    fxGUI.setSelectObjectCode(selectedCar.getCodeV());
                    changeTextFieldsSelecteds(selectedCar);
                    imagePath = selectedCar.getPhoto();
                    btnNewV.setDisable(true);
                    btnSaveV.setDisable(true);
                    btnRemoveV.setDisable(false);
                    btnEditV.setDisable(false);
                    btnNewV.setDisable(true);
                    btnPrevV.setDisable(true);
                    btnImageV.setDisable(false);
                } else {
                    fxGUI.setSelectCarRent(selectedCar.getCodeV());
                }
            }
        }
    }

    @FXML
    void onNextV(ActionEvent event) {
        try {
            changeTextFieldsSelecteds(rc.findVehicletoShowNext(positionCar));
            positionCar++;
        } catch (NullPointerException e) {
            fxGUI.showAlert(false, "No hay vehiculos para mostrar", stackPane);
        }
    }

    @FXML
    void onPrevV(ActionEvent event) {
        try {
            changeTextFieldsSelecteds(rc.findVehicletoShowPrev(Math.abs(amountCar)));
            amountCar--;
        } catch (NullPointerException e) {
            fxGUI.showAlert(false, "No hay vehiculos para mostrar", stackPane);
        }
    }

    public void changeTextFieldsSelecteds(Car carSelected) {
        txtCodeV.setText(carSelected.getCodeV() + "");
        cbBrandV.setValue(carSelected.getBrand().getNameP());
        cbTypeV.setValue(carSelected.getTypeV().getNameQ());
        txtPlateV.setText(carSelected.getPlate());
        txtModelV.setText(carSelected.getModel());
        txtColorV.setText(carSelected.getColor());
        txtYearV.setText(carSelected.getYear() + "");
        txtPriceV.setText(carSelected.getPriceXDay() + "");
        iPhotoV.setImage(stringToImage(carSelected.getPhoto()));
        if (carSelected.isDispV()) {
            rbDispVY.setSelected(true);
            rbDispVN.setSelected(false);
        } else {
            rbDispVN.setSelected(true);
            rbDispVY.setSelected(false);
        }
    }

    @FXML
    public void onRemoveEdit(ActionEvent event) throws IOException {
        try {
            rc.removeCarBinaryTree(fxGUI.getSelectObjectCode());
            rc.removeCar(fxGUI.getSelectObjectCode());
            fxGUI.showAlert(true, "Se elimino, este vehículo ya no esta registrado", stackPane);
            fxGUI.saveData();
        } catch (Reference ex) {
            fxGUI.showAlert(false, "No se elimino, este vehículo ya esta referenciado", stackPane);
        }
        clearTextField();
        fxGUI.setSelectObjectCode(0);
        btnInitialize();
        imagePath = "";
        iPhotoV.setImage(null);
    }

    @FXML
    public void onEditV(ActionEvent event) throws IOException {
        if (!txtCodeV.getText().equals("") && cbBrandV.getValue() != null && cbTypeV.getValue() != null && !txtPlateV.getText().equals("")
                && !txtYearV.getText().equals("") && !txtColorV.getText().equals("") && !txtPriceV.getText().equals("") && !txtModelV.getText().equals("") && rbDisp.getSelectedToggle() != null) {
            try {
                if (rc.uptadeCar(fxGUI.getSelectObjectCode(), txtModelV.getText(), txtColorV.getText(), rc.findBrandSelected(cbBrandV.getValue()),
                        rc.findTypeVSelected(cbTypeV.getValue()), Double.parseDouble(txtPriceV.getText()), txtPlateV.getText(),
                        getSelectedDisp(), imagePath, Integer.parseInt(txtYearV.getText()))) {
                    fxGUI.showAlert(true, "Se actualizo el vehículo correctamente", stackPane);
                    fxGUI.saveData();
                } else {
                    fxGUI.showAlert(false, "Otro vehículo se encuentra con la misma placa, no se actualizo", stackPane);
                }
            } catch (NumberFormatException e) {
                fxGUI.showAlert(false, "No puedes ingresar letras en el precio o año, no se actualizo", stackPane);
            }
        } else {
            fxGUI.showAlert(false, "Para actualizar llena todos los campos, no se actualizo", stackPane);
        }
        clearTextField();
        fxGUI.setSelectObjectCode(0);
        btnInitialize();
        iPhotoV.setImage(null);
        imagePath = "";
    }

    public void onTableSearchPlate(String plate) {
        tblVehicle.getItems().clear();

        List<Car> cars = rc.searchPlateVehicle(plate);
        ObservableList<Car> newTableCar;
        newTableCar = FXCollections.observableArrayList(cars);

        tblVehicle.setItems(newTableCar);
        tblcCodeV.setCellValueFactory(new PropertyValueFactory<>("codeV"));
        tblcPlateV.setCellValueFactory(new PropertyValueFactory<>("plate"));
        tblcTypeV.setCellValueFactory(new PropertyValueFactory<>("nameType"));
        tblcModelV.setCellValueFactory(new PropertyValueFactory<>("model"));
        tblcBrandV.setCellValueFactory(new PropertyValueFactory<>("nameBrand"));
        tblcColorV.setCellValueFactory(new PropertyValueFactory<>("color"));
        tblcPriceV.setCellValueFactory(new PropertyValueFactory<>("priceXDay"));
        tblcYearV.setCellValueFactory(new PropertyValueFactory<>("year"));
        tblcDispV.setCellValueFactory(new PropertyValueFactory<>("dispV"));

        tblVehicle.refresh();
    }

    @FXML
    public void onShowAllV(ActionEvent event) {
        tblVehicle.getItems().clear();
        rc.setShowRootCar();
        onTableVehicle();
    }

    @FXML
    public void onSearchPlateV(ActionEvent event) {
        if (!txtSearchPlateV.getText().equals("")) {
            onTableSearchPlate(txtSearchPlateV.getText());
        } else {
            fxGUI.showAlert(false, "Por favor ingresa un criterio de busqueda", stackPane1);
        }
    }
}
