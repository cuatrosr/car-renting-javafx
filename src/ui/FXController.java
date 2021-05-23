package ui;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
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

    public void newStage(Parent root) {
        Stage newStage = new Stage();
        Scene scene = new Scene(root);
        newStage.setScene(scene);
        newStage.setTitle("RentingCar");
        newStage.setResizable(false);
        newStage.show();
    }

    public void closeStage(Pane bpMain) {
        Stage stage = (Stage) bpMain.getScene().getWindow();
        stage.close();
    }

    public void disablePane(Pane bpMain, boolean status) {
        bpMain.setDisable(status);
    }

    public void showLogin() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/Login.fxml"));
        fxmlLoader.setController(xLogin);
        Parent root = fxmlLoader.load();
        pMain.getChildren().setAll(root);
    }

    public Pane getPMain() {
        return pMain;
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
        newStage(root);
        xClient.setImagesButton();
    }

    public void showGVehicle() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/AddVehicle.fxml"));
        fxmlLoader.setController(xVehicle);
        Parent root = fxmlLoader.load();
        newStage(root);
        xVehicle.setImagesButton();
    }

    public void showGCity() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/AddCity.fxml"));
        fxmlLoader.setController(xCity);
        Parent root = fxmlLoader.load();
        newStage(root);
    }

    public void showGBrand() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/AddBrand.fxml"));
        fxmlLoader.setController(xBrand);
        Parent root = fxmlLoader.load();
        newStage(root);
    }

    public void showGType() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/AddType.fxml"));
        fxmlLoader.setController(xType);
        Parent root = fxmlLoader.load();
        newStage(root);
    }

    public void showGRent() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/Rent.fxml"));
        fxmlLoader.setController(xRent);
        Parent root = fxmlLoader.load();
        newStage(root);
    }

    public void showGDevolution() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/Devolution.fxml"));
        fxmlLoader.setController(xDevol);
        Parent root = fxmlLoader.load();
        newStage(root);
    }

    public void showListClient() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/ListClients.fxml"));
        fxmlLoader.setController(xClient);
        Parent root = fxmlLoader.load();
        newStage(root);
        xClient.setImagesList();
    }

    public void showListEmployee() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/ListEmployee.fxml"));
        fxmlLoader.setController(xEmployee);
        Parent root = fxmlLoader.load();
        newStage(root);
        xEmployee.setImageEmployee();
    }

    public void showListRent() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/ListRent.fxml"));
        fxmlLoader.setController(xRent);
        Parent root = fxmlLoader.load();
        newStage(root);
        xRent.setImagesList();
    }

    public void showListVehicle() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/ListVehicles.fxml"));
        fxmlLoader.setController(xVehicle);
        Parent root = fxmlLoader.load();
        newStage(root);
        xVehicle.setImagesList();
    }

    public void showReportClient() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/ReportClients.fxml"));
        fxmlLoader.setController(xReport);
        Parent root = fxmlLoader.load();
        closeStage(xReport.getPane());
        newStage(root);
        xReport.setImagesClientReport();
    }

    public void showReportRent() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/ReportRent.fxml"));
        fxmlLoader.setController(xReport);
        Parent root = fxmlLoader.load();
        closeStage(xReport.getPane());
        newStage(root);
        xReport.setImagesRentReport();
    }

    public void showReportVehicles() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/ReportVehicles.fxml"));
        fxmlLoader.setController(xReport);
        Parent root = fxmlLoader.load();
        closeStage(xReport.getPane());
        newStage(root);
        xReport.setImagesVehiclesReport();
    }

    public void showSelectReport() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/SelectReport.fxml"));
        fxmlLoader.setController(xReport);
        Parent root = fxmlLoader.load();
        newStage(root);
        xReport.setImagesButton();
    }

    public void showTopEmployee() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/TopEmployee.fxml"));
        fxmlLoader.setController(xEmployee);
        Parent root = fxmlLoader.load();
        newStage(root);
        xEmployee.setImageTopEmployee();
    }
}
