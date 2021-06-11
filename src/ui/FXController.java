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

/**
 *
 * @author DELL
 */
public class FXController implements Serializable {

    //---------------------------- Attributes of FXController class ----------------------------\\
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
    private FXSpeed xSpeed;
    private FXShapes xShapes;
    private int selectObjectCode;
    private int selectClientRent;
    private int selectCarRent;
    private boolean otherWindowSelected;

    //-------------------------- Constructor, getter and setter class --------------------------\\
    /**
     * FXController class constructor, initialize all relations.
     *
     * @throws IOException
     * @param rc object's RentingCar
     */
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
        xSpeed = new FXSpeed(this.rc, this);
        xShapes = new FXShapes(this.rc, this);
    }

    /**
     *
     * @return
     */
    public Pane getPMain() {
        return pMain;
    }

    /**
     *
     * @return
     */
    public int getSelectObjectCode() {
        return selectObjectCode;
    }

    /**
     *
     * @param code
     */
    public void setSelectObjectCode(int code) {
        this.selectObjectCode = code;
    }

    /**
     *
     * @return
     */
    public int getSelectClientRent() {
        return selectClientRent;
    }

    /**
     *
     * @param selectClientRent
     */
    public void setSelectClientRent(int selectClientRent) {
        this.selectClientRent = selectClientRent;
    }

    /**
     *
     * @return
     */
    public int getSelectCarRent() {
        return selectCarRent;
    }

    /**
     *
     * @param selectCarRent
     */
    public void setSelectCarRent(int selectCarRent) {
        this.selectCarRent = selectCarRent;
    }

    /**
     *
     * @return
     */
    public boolean isOtherWindowSelected() {
        return otherWindowSelected;
    }

    /**
     *
     * @param otherWindowSelected
     */
    public void setOtherWindowSelected(boolean otherWindowSelected) {
        this.otherWindowSelected = otherWindowSelected;
    }

    //-------------------------- Save and load data --------------------------\\
    /**
     * Load the data from a file with extension .CGD
     *
     * @throws FileNotFoundException
     */
    public void loadData() throws FileNotFoundException {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(SAVE_PATH_FILE)));
            RentingCar rc = (RentingCar) ois.readObject();
            this.rc = rc;
            ois.close();
        } catch (Exception e) {
        }
    }

    /**
     * Save the data to a file with extension .CGD
     * @throws java.io.IOException
     */
    public void saveData() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_FILE));
        oos.writeObject(this.rc);
        oos.close();
    }

    //-------------------------- Gestion stages, panes --------------------------\\
    /**
     * Open a new Stage
     *
     * @param root Parent's object to initiallize the scene. a Parent not null
     * @return 
     */
    public Stage newStage(Parent root) {
        Stage newStage = new Stage();
        Scene scene = new Scene(root);
        newStage.setScene(scene);
        newStage.setTitle("RentingCar");
        newStage.setResizable(false);
        newStage.show();
        return newStage;
    }

    /**
     * Close a new Stage
     *
     * @param bpMain Pane's object to be closed. Pane not null
     */
    public void closeStage(Pane bpMain) {
        Stage stage = (Stage) bpMain.getScene().getWindow();
        stage.close();
    }

    /**
     * Disable a Pane
     *
     * @param bpMain Pane's object to be disable. Pane not null
     * @param status Pane's next status (True = disable | False = enable)
     */
    public void disablePane(Pane bpMain, boolean status) {
        bpMain.setDisable(status);
    }

    /**
     * Hability Pane
     *
     * @param bpMain Pane's object to be enable. Pane not null
     * @param closed Pane's closed
     */
    public void habilityPane(Pane bpMain, Stage closed) {
        closed.setOnCloseRequest((WindowEvent event) -> {
            disablePane(bpMain, false);
            xClient.showCitiesDisp();
            xVehicle.showBrandDisp();
            xVehicle.showTypeDisp();
            try {
                xRent.setTextClient(rc.searchClientSelected(selectClientRent));
                otherWindowSelected = false;
                selectClientRent = 0;
            } catch (NullPointerException e) {
            }
            try {
                xRent.setTextCar(rc.findCar(selectCarRent));
                otherWindowSelected = false;
                selectCarRent = 0;
            } catch (NullPointerException e) {
            }
            try {
                xSpeed.interrupThreads();
            } catch (NullPointerException e) {
            }
        });
    }

    //-------------------------- Show GUI Methods --------------------------\\
    /**
     * Show Login GUI
     *
     * @throws IOException
     */
    public void showLogin() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/Login.fxml"));
        fxmlLoader.setController(xLogin);
        Parent root = fxmlLoader.load();
        pMain.getChildren().setAll(root);
    }

    /**
     * Show Register GUI
     *
     * @throws IOException
     */
    public void showRegister() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/Register.fxml"));
        fxmlLoader.setController(xRegister);
        Parent root = fxmlLoader.load();
        pMain.getChildren().setAll(root);
    }

    /**
     * Show Menu GUI
     *
     * @throws IOException
     */
    public void showMenu() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/Menu.fxml"));
        fxmlLoader.setController(xMenu);
        Parent root = fxmlLoader.load();
        newStage(root);
    }

    /**
     * Show Client GUI
     *
     * @throws IOException
     */
    public void showGClient() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/AddClient.fxml"));
        fxmlLoader.setController(xClient);
        Parent root = fxmlLoader.load();
        Stage clientStage = newStage(root);
        xClient.setImagesButton();
        xClient.btnInitialize();
        xClient.showCitiesDisp();
        habilityPane(xMenu.getPane(), clientStage);
    }

    /**
     * Show Vehicle GUI
     *
     * @throws IOException
     */
    public void showGVehicle() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/AddVehicle.fxml"));
        fxmlLoader.setController(xVehicle);
        Parent root = fxmlLoader.load();
        Stage vehicleStage = newStage(root);
        xVehicle.showBrandDisp();
        xVehicle.showTypeDisp();
        xVehicle.btnInitialize();
        xVehicle.setImagesButton();
        habilityPane(xMenu.getPane(), vehicleStage);
    }

    /**
     * Show City GUI
     *
     * @param out
     * @throws IOException
     */
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

    /**
     * Show Brand GUI
     *
     * @param out
     * @throws IOException
     */
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

    /**
     * Show Type GUI
     *
     * @param out
     * @throws IOException
     */
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

    /**
     * Show Rent GUI
     *
     * @throws IOException
     */
    public void showGRent() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/Rent.fxml"));
        fxmlLoader.setController(xRent);
        Parent root = fxmlLoader.load();
        Stage rentStage = newStage(root);
        xRent.setImagesButton();
        xRent.btnInitialize();
        habilityPane(xMenu.getPane(), rentStage);
    }

    /**
     * Show Devolution GUI
     *
     * @throws IOException
     */
    public void showGDevolution() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/Devolution.fxml"));
        fxmlLoader.setController(xDevol);
        Parent root = fxmlLoader.load();
        Stage devolStage = newStage(root);
        xDevol.setImagesButton();
        habilityPane(xMenu.getPane(), devolStage);
    }

    /**
     * Show List Client GUI
     *
     * @param out
     * @throws IOException
     */
    public void showListClient(boolean out) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/ListClients.fxml"));
        fxmlLoader.setController(xClient);
        Parent root = fxmlLoader.load();
        Stage listClientStage = newStage(root);
        xClient.setImagesList();
        xClient.onTableListClient();
        if (out) {
            habilityPane(xClient.getPane(), listClientStage);
        } else {
            habilityPane(xRent.getPane(), listClientStage);
        }
    }

    /**
     * Show List Employee GUI
     *
     * @throws IOException
     */
    public void showListEmployee() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/ListEmployee.fxml"));
        fxmlLoader.setController(xEmployee);
        Parent root = fxmlLoader.load();
        Stage listEmployeeStage = newStage(root);
        xEmployee.setImageEmployee();
        xEmployee.onTableEmployeeName();
        rc.setShowRootName();
        xEmployee.onTableEmployeeName();
        habilityPane(xMenu.getPane(), listEmployeeStage);
    }

    /**
     * Show List Rent GUI
     *
     * @throws IOException
     */
    public void showListRent() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/ListRent.fxml"));
        fxmlLoader.setController(xDevol);
        Parent root = fxmlLoader.load();
        Stage listRentStage = newStage(root);
        xDevol.setImagesList();
        xDevol.onTableListRent();
        habilityPane(xDevol.getPane(), listRentStage);
    }

    /**
     * Show List Vehicle GUI
     *
     * @param out
     * @throws IOException
     */
    public void showListVehicle(boolean out) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/ListVehicles.fxml"));
        fxmlLoader.setController(xVehicle);
        Parent root = fxmlLoader.load();
        Stage listVehicleStage = newStage(root);
        xVehicle.setImagesList();
        rc.setShowRootCar();
        xVehicle.onTableVehicle();
        if (out) {
            habilityPane(xVehicle.getPane(), listVehicleStage);
        } else {
            habilityPane(xRent.getPane(), listVehicleStage);
        }
    }

    /**
     * Show Report Client GUI
     *
     * @param out
     * @throws IOException
     */
    public void showReportClient(boolean out) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/ReportClients.fxml"));
        fxmlLoader.setController(xReport);
        Parent root = fxmlLoader.load();
        Stage rClientStage = newStage(root);
        xReport.setImagesClientReport();
        xReport.setCbCities();
        if (out) {
            habilityPane(xMenu.getPane(), rClientStage);
        } else {
            habilityPane(xReport.getPane(), rClientStage);
        }
    }

    /**
     * Show Report Rent GUI
     *
     * @param out
     * @throws IOException
     */
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

    /**
     * Show Report Vehicle GUI
     *
     * @param out
     * @throws IOException
     */
    public void showReportVehicles(boolean out) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/ReportVehicles.fxml"));
        fxmlLoader.setController(xReport);
        Parent root = fxmlLoader.load();
        Stage rVehicleStage = newStage(root);
        xReport.setImagesVehiclesReport();
        xReport.setCbTypeV();
        if (out) {
            habilityPane(xMenu.getPane(), rVehicleStage);
        } else {
            habilityPane(xReport.getPane(), rVehicleStage);
        }
    }

    /**
     * Show Select Report GUI
     *
     * @throws IOException
     */
    public void showSelectReport() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/SelectReport.fxml"));
        fxmlLoader.setController(xReport);
        Parent root = fxmlLoader.load();
        Stage sReportStage = newStage(root);
        xReport.setImagesButton();
        habilityPane(xMenu.getPane(), sReportStage);
    }

    /**
     * Show Top Employee GUI
     *
     * @throws IOException
     */
    public void showTopEmployee() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/TopEmployee.fxml"));
        fxmlLoader.setController(xEmployee);
        Parent root = fxmlLoader.load();
        Stage topEmployeeStage = newStage(root);
        xEmployee.setImageTopEmployee();
        rc.setShowRootName();
        xEmployee.onTableTopEmployee();
        habilityPane(xMenu.getPane(), topEmployeeStage);
    }

    /**
     * Show Save Pay on Devol GUI
     *
     * @throws IOException
     */
    public void showSavePay() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/SavePay.fxml"));
        fxmlLoader.setController(xDevol);
        Parent root = fxmlLoader.load();
        Stage savePayStage = newStage(root);
        habilityPane(xDevol.getPane(), savePayStage);
    }

    /**
     * Show Alert GUI
     *
     * @param success
     * @param msg
     * @param stackPane
     * @throws IOException
     */
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

    /**
     * Show Speed Test GUI
     *
     * @throws IOException
     */
    public void showSpeed() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/Speed.fxml"));
        fxmlLoader.setController(xSpeed);
        Parent root = fxmlLoader.load();
        Stage testSpeed = newStage(root);
        habilityPane(xMenu.getPane(), testSpeed);
    }

    /**
     * Show Pie Chart GUI
     *
     * @throws IOException
     */
    public void showPieChart() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/StatRent.fxml"));
        fxmlLoader.setController(xShapes);
        Parent root = fxmlLoader.load();
        Stage pieChartStage = newStage(root);
        xShapes.loadPieChart();
        habilityPane(xMenu.getPane(), pieChartStage);
    }

    /**
     * Show Bar Chart GUI
     *
     * @throws IOException
     */
    public void showBarChart() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/StatObjects.fxml"));
        fxmlLoader.setController(xShapes);
        Parent root = fxmlLoader.load();
        Stage barChartStage = newStage(root);
        xShapes.loadBarChart();
        habilityPane(xMenu.getPane(), barChartStage);
    }
}
