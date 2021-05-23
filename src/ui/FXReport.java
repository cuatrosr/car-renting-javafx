package ui;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.*;

public class FXReport {

    
    @FXML
    private Pane reportPane;
    
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
    
    public Pane getPane(){
        return reportPane;
    }

    @FXML
    void onSelecetClientReport(ActionEvent event) throws IOException {
        fxGUI.showReportClient();
    }

    @FXML
    void onSelecetRentReport(ActionEvent event) throws IOException {
        fxGUI.showReportRent();
    }

    @FXML
    void onSelecetVehicleReport(ActionEvent event) throws IOException {
        fxGUI.showReportVehicles();
    }
}
