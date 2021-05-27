package ui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.*;

public class FXController implements Serializable {

    @FXML
    private Pane pMain;
    private static final long serialVersionUID = 1;
    private final String SAVE_PATH_FILE = "data/RentingCar.cgd";
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
    private int selectObjectCode;

    public FXController(RentingCar rc) throws IOException {
        this.rc = rc;
        loadData();
        xLogin = new FXLogin(this.rc, this);
        xRegister = new FXRegister(this.rc, this);
        xMenu = new FXMenu(this.rc, this);
        xClient = new FXClient(this.rc, this);
        xVehicle = new FXVehicle(this.rc, this);
        xCity = new FXCity(this.rc, this);
        xBrand = new FXBrand(this.rc, this);
        xType = new FXType(this.rc, this);
        xReport = new FXReport(this.rc, this);
        xEmployee = new FXEmployee(this.rc, this);
        xRent = new FXRent(this.rc, this);
        xDevol = new FXDevol(this.rc, this);
    }

    public void loadData() throws FileNotFoundException {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(SAVE_PATH_FILE)));
            RentingCar rc = (RentingCar) ois.readObject();
            this.rc = rc;
            ois.close();
        } catch (Exception e) {
        }
    }

    public void saveData() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_FILE));
        oos.writeObject(this.rc);
        oos.close();
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
    
    public int getSelectObjectCode(){
        return selectObjectCode;
    }
    
    public void setSelectObjectCode(int code){
        this.selectObjectCode = code;
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
        xCity.onTableListCities();
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
        if (out) {
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
        if (out) {
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
        if (out) {
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

    public void showAlert(boolean success, String msg, StackPane stackPane) {
        JFXDialogLayout content = new JFXDialogLayout();
        JFXButton button = new JFXButton("Okay");
        JFXDialog dialog = new JFXDialog(stackPane, content, JFXDialog.DialogTransition.CENTER);
        button.setOnAction((ActionEvent event) -> {
            dialog.close();
        });
        content.setActions(button);
        if (success) {
            content.setHeading(new Text("¡Listo!"));
            content.setBody(new Text(msg));
            dialog.show();
        } else {
            content.setHeading(new Text("¡Error!"));
            content.setBody(new Text(msg));
            dialog.show();
        }
    }
}
