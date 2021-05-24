package ui;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.*;

public class FXController {

    @FXML
    private Pane pMain;

    private RentingCar rc;
    private FXLogin xLogin;
    private FXRegister xRegister;
    private FXMenu xMenu;
    private FXClient xClient;
    private FXVehicle xVehicle;
    private FXCity xCity;
    private FXBrand xBrand;
    private FXType xType;
    private FXReport xReport;
    private FXEmployee xEmployee;
    private FXRent xRent;
    private FXDevol xDevol;

    public FXController(RentingCar rc) {
        this.rc = new RentingCar();
        xLogin = new FXLogin(rc, this);
        xRegister = new FXRegister(rc, this);
        xMenu = new FXMenu(rc, this);
        xClient = new FXClient(rc, this);
        xVehicle = new FXVehicle(rc, this);
        xCity = new FXCity(rc, this);
        xBrand = new FXBrand(rc, this);
        xType = new FXType(rc, this);
        xReport = new FXReport(rc, this);
        xEmployee = new FXEmployee(rc, this);
        xRent = new FXRent(rc, this);
        xDevol = new FXDevol(rc, this);
    }

    public Stage newStage(Parent root) {
        Stage newStage = new Stage();
        Scene scene = new Scene(root);
        newStage.setScene(scene);
        newStage.setTitle("RentingCar");
        newStage.setResizable(false);
        newStage.show();
        return newStage;
    }

    public void closeStage(Pane bpMain) {
        Stage stage = (Stage) bpMain.getScene().getWindow();
        stage.close();
    }

    public void disablePane(Pane bpMain, boolean status) {
        bpMain.setDisable(status);
    }

    public void habilityPane(Pane bpMain, Stage closed) {
        closed.setOnCloseRequest((WindowEvent event) -> {
            disablePane(bpMain, false);
        });
    }

    public Pane getPMain() {
        return pMain;
    }

    public void showLogin() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/Login.fxml"));
        fxmlLoader.setController(xLogin);
        Parent root = fxmlLoader.load();
        pMain.getChildren().setAll(root);
    }

    public void showRegister() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/Register.fxml"));
        fxmlLoader.setController(xRegister);
        Parent root = fxmlLoader.load();
        pMain.getChildren().setAll(root);
    }

    public void showMenu() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/Menu.fxml"));
        fxmlLoader.setController(xMenu);
        Parent root = fxmlLoader.load();
        newStage(root);
    }

    public void showGClient() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/AddClient.fxml"));
        fxmlLoader.setController(xClient);
        Parent root = fxmlLoader.load();
        Stage clientStage = newStage(root);
        xClient.setImagesButton();
        habilityPane(xMenu.getPane(), clientStage);
    }

    public void showGVehicle() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/AddVehicle.fxml"));
        fxmlLoader.setController(xVehicle);
        Parent root = fxmlLoader.load();
        Stage vehicleStage = newStage(root);
        xVehicle.setImagesButton();
        habilityPane(xMenu.getPane(), vehicleStage);
    }

    public void showGCity(boolean out) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/AddCity.fxml"));
        fxmlLoader.setController(xCity);
        Parent root = fxmlLoader.load();
        Stage cityStage = newStage(root);
        if (out) {
            habilityPane(xMenu.getPane(), cityStage);
        } else {
            habilityPane(xClient.getPane(), cityStage);
        }
    }

    public void showGBrand(boolean out) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/AddBrand.fxml"));
        fxmlLoader.setController(xBrand);
        Parent root = fxmlLoader.load();
        Stage brandStage = newStage(root);
        if (out) {
            habilityPane(xMenu.getPane(), brandStage);
        } else {
            habilityPane(xVehicle.getPane(), brandStage);
        }
    }

    public void showGType(boolean out) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/AddType.fxml"));
        fxmlLoader.setController(xType);
        Parent root = fxmlLoader.load();
        Stage typeStage = newStage(root);
        if (out) {
            habilityPane(xMenu.getPane(), typeStage);
        } else {
            habilityPane(xVehicle.getPane(), typeStage);
        }
    }

    public void showGRent() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/Rent.fxml"));
        fxmlLoader.setController(xRent);
        Parent root = fxmlLoader.load();
        Stage rentStage = newStage(root);
        xRent.setImagesButton();
        habilityPane(xMenu.getPane(), rentStage);
    }

    public void showGDevolution() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/Devolution.fxml"));
        fxmlLoader.setController(xDevol);
        Parent root = fxmlLoader.load();
        Stage devolStage = newStage(root);
        habilityPane(xMenu.getPane(), devolStage);
    }

    public void showListClient(boolean out) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/ListClients.fxml"));
        fxmlLoader.setController(xClient);
        Parent root = fxmlLoader.load();
        Stage listClientStage = newStage(root);
        xClient.setImagesList();
        if (out) {
            habilityPane(xClient.getPane(), listClientStage);
        } else {
            habilityPane(xRent.getPane(), listClientStage);
        }
    }

    public void showListEmployee() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/ListEmployee.fxml"));
        fxmlLoader.setController(xEmployee);
        Parent root = fxmlLoader.load();
        Stage listEmployeeStage = newStage(root);
        xEmployee.setImageEmployee();
        habilityPane(xMenu.getPane(), listEmployeeStage);
    }

    public void showListRent() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/ListRent.fxml"));
        fxmlLoader.setController(xRent);
        Parent root = fxmlLoader.load();
        Stage listRentStage = newStage(root);
        xRent.setImagesList();
        habilityPane(xDevol.getPane(), listRentStage);
    }

    public void showListVehicle(boolean out) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/ListVehicles.fxml"));
        fxmlLoader.setController(xVehicle);
        Parent root = fxmlLoader.load();
        Stage listVehicleStage = newStage(root);
        xVehicle.setImagesList();
        if(out){
            habilityPane(xVehicle.getPane(), listVehicleStage);
        } else {
            habilityPane(xRent.getPane(), listVehicleStage);
        }
    }

    public void showReportClient(boolean out) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/ReportClients.fxml"));
        fxmlLoader.setController(xReport);
        Parent root = fxmlLoader.load();
        Stage rClientStage = newStage(root);
        xReport.setImagesClientReport();
        if(out){
            habilityPane(xMenu.getPane(), rClientStage);
        } else {
            habilityPane(xReport.getPane(), rClientStage);
        }
    }

    public void showReportRent(boolean out) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/ReportRent.fxml"));
        fxmlLoader.setController(xReport);
        Parent root = fxmlLoader.load();
        Stage rRentStage = newStage(root);
        xReport.setImagesRentReport();
        if (out) {
            habilityPane(xMenu.getPane(), rRentStage);
        } else {
            habilityPane(xReport.getPane(), rRentStage);
        }
    }

    public void showReportVehicles(boolean out) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/ReportVehicles.fxml"));
        fxmlLoader.setController(xReport);
        Parent root = fxmlLoader.load();
        Stage rVehicleStage = newStage(root);
        xReport.setImagesVehiclesReport();
        if(out){
            habilityPane(xMenu.getPane(), rVehicleStage);
        } else {
            habilityPane(xReport.getPane(), rVehicleStage);
        }
    }

    public void showSelectReport() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/SelectReport.fxml"));
        fxmlLoader.setController(xReport);
        Parent root = fxmlLoader.load();
        Stage sReportStage = newStage(root);
        xReport.setImagesButton();
        habilityPane(xMenu.getPane(), sReportStage);
    }

    public void showTopEmployee() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/TopEmployee.fxml"));
        fxmlLoader.setController(xEmployee);
        Parent root = fxmlLoader.load();
        Stage topEmployeeStage = newStage(root);
        xEmployee.setImageTopEmployee();
        habilityPane(xMenu.getPane(), topEmployeeStage);
    }
}
