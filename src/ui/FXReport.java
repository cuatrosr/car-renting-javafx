package ui;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import model.*;

public class FXReport {

    private static final long serialVersionUID = 1;

    @FXML
    private Pane reportPane;

    @FXML
    private Pane pExportClient;

    @FXML
    private Pane pExportCar;
    
    @FXML
    private Pane pExportRent;

    @FXML
    private StackPane stackPane;

    //********* Set Images *********\\
    @FXML
    private ImageView iReportClient;

    @FXML
    private ImageView iReportVehicle;

    @FXML
    private ImageView iReportRent;

    @FXML
    private ImageView iPrintAllClientReport;

    @FXML
    private ImageView iPrintFilterClientReport;

    @FXML
    private ImageView iPrintAllRentReport;

    @FXML
    private ImageView iPrintFilterRentReport;

    @FXML
    private ImageView iPrintAllVehiclesReport;

    @FXML
    private ImageView iPrintFilterVehiclesReport;

    //***************** Filter ******************\\
    @FXML
    private JFXComboBox<String> cbFilterCityClient;

    @FXML
    private JFXComboBox<String> cbFilterTypeCar;

    @FXML
    private JFXDatePicker dpInit;

    @FXML
    private JFXDatePicker dpFinal;

    private RentingCar rc;
    private FXController fxGUI;

    public FXReport(RentingCar rc, FXController fxGUI) {
        this.rc = rc;
        this.fxGUI = fxGUI;
    }

    public void setImagesButton() {
        Image iReportVehiclePNG = new Image("Images/vehicles.png");
        Image iReportClientPNG = new Image("Images/clients.png");
        Image iReportRentPNG = new Image("Images/car-key.png");
        iReportClient.setImage(iReportClientPNG);
        iReportVehicle.setImage(iReportVehiclePNG);
        iReportRent.setImage(iReportRentPNG);
    }

    public Image getImagePrint() {
        Image iPrintReport = new Image("Images/printer.png");
        return iPrintReport;
    }

    public void setImagesClientReport() {
        iPrintAllClientReport.setImage(getImagePrint());
        iPrintFilterClientReport.setImage(getImagePrint());
    }

    public void setImagesVehiclesReport() {
        iPrintAllVehiclesReport.setImage(getImagePrint());
        iPrintFilterVehiclesReport.setImage(getImagePrint());
    }

    public void setImagesRentReport() {
        iPrintAllRentReport.setImage(getImagePrint());
        iPrintFilterRentReport.setImage(getImagePrint());
    }

    public Pane getPane() {
        return reportPane;
    }

    @FXML
    void onSelecetClientReport(ActionEvent event) throws IOException {
        fxGUI.disablePane(reportPane, true);
        fxGUI.showReportClient(false);
    }

    @FXML
    void onSelecetRentReport(ActionEvent event) throws IOException {
        fxGUI.disablePane(reportPane, true);
        fxGUI.showReportRent(false);
    }

    @FXML
    void onSelecetVehicleReport(ActionEvent event) throws IOException {
        fxGUI.disablePane(reportPane, true);
        fxGUI.showReportVehicles(false);
    }

    public void setCbCities() {
        try {
            List<String> citiesName = new ArrayList<>();
            for (int i = 0; i < rc.getListCities().size(); i++) {
                citiesName.add(rc.getListCities().get(i).getNameCi());
            }
            ObservableList<String> obs;
            obs = FXCollections.observableArrayList(citiesName);
            cbFilterCityClient.setItems(obs);
        } catch (NullPointerException e) {
        }
    }

    public void setCbTypeV() {
        try {
            List<String> typeName = new ArrayList<>();
            for (int i = 0; i < rc.getListTypeV().size(); i++) {
                typeName.add(rc.getListTypeV().get(i).getNameTB() + " " + rc.getListTypeV().get(i).getQuality());
            }

            ObservableList<String> obs;
            obs = FXCollections.observableArrayList(typeName);
            cbFilterTypeCar.setItems(obs);
        } catch (NullPointerException e) {
        }
    }

    public void exportClientSelection(boolean out, City cityFilter) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Exportar clientes");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        File f = fileChooser.showSaveDialog(pExportClient.getScene().getWindow());
        if (f != null) {
            try {
                rc.exportClient(out, cityFilter, f.getAbsolutePath());
                fxGUI.showAlert(true, "Se ha generado correctamente", stackPane);
            } catch (FileNotFoundException e) {
                fxGUI.showAlert(false, "No fue generado exitosamente. \\nVerifica que el archivo donde guardaras este vacio", stackPane);
            }
        }
    }

    @FXML
    public void onExportAllClients(ActionEvent event) {
        exportClientSelection(true, null);
    }

    @FXML
    public void onFilterCityClient(ActionEvent event) {
        if (cbFilterCityClient.getValue() != null) {
            exportClientSelection(false, rc.findCitySelected(cbFilterCityClient.getValue()));

        } else {
            fxGUI.showAlert(false, "Por favor selecciona una ciudad", stackPane);
        }
    }

    public void exportCarSelection(boolean out, TypeV type) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Exportar carros");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        File f = fileChooser.showSaveDialog(pExportCar.getScene().getWindow());
        if (f != null) {
            try {
                rc.exportVehicle(out, type, f.getAbsolutePath());
                fxGUI.showAlert(true, "Se ha generado correctamente", stackPane);
            } catch (FileNotFoundException e) {
                fxGUI.showAlert(false, "No fue generado exitosamente. \\nVerifica que el archivo donde guardaras este vacio", stackPane);
            }
        }
    }

    @FXML
    public void onExportAllCar(ActionEvent event) {
        exportCarSelection(true, null);
    }

    @FXML
    public void onFilterTypeCar(ActionEvent event) {
        if (cbFilterTypeCar.getValue() != null) {
            exportCarSelection(false, rc.findTypeVSelected(cbFilterTypeCar.getValue()));
        } else {
            fxGUI.showAlert(false, "Por favor selecciona una tipo de vehículo", stackPane);
        }
    }

    public void exportRentSelection(boolean out, LocalDate init, LocalDate end) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Exportar rentas");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        File f = fileChooser.showSaveDialog(pExportRent.getScene().getWindow());
        if (f != null) {
            try {
                rc.exportRent(out, init, end, f.getAbsolutePath());
                fxGUI.showAlert(true, "Se ha generado correctamente", stackPane);
            } catch (FileNotFoundException e) {
                fxGUI.showAlert(false, "No fue generado exitosamente. \\nVerifica que el archivo donde guardaras este vacio", stackPane);
            }
        }
    }

    @FXML
    public void onFilterDateRent(ActionEvent event) {
        if(dpFinal.getValue() != null && dpInit.getValue() != null){
            exportRentSelection(false, dpInit.getValue(), dpFinal.getValue());
        } else {
            fxGUI.showAlert(false, "Por favor, selecciona una fecha inicial y una fecha final", stackPane);
        }
    }

    @FXML
    public void onShowAllReports(ActionEvent event) {
        exportRentSelection(true, null, null);
    }
}
