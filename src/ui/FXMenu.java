package ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import model.*;

/**
 *
 * @author DELL
 */
public class FXMenu implements Initializable {

    private static final long serialVersionUID = 1;
    @FXML
    private Pane pMainMenu;

    //********* Set Images *********\\
    @FXML
    private ImageView iVehicle;

    @FXML
    private ImageView iClient;

    @FXML
    private ImageView iRent;

    @FXML
    private ImageView iDevol;

    @FXML
    private ImageView iReport;

    @FXML
    private ImageView iLogo;

    private RentingCar rc;
    private FXController fxGUI;

    /**
     *
     * @param rc
     * @param fxGUI
     */
    public FXMenu(RentingCar rc, FXController fxGUI) {
        this.rc = rc;
        this.fxGUI = fxGUI;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setImagesButton();
        fxGUI.disablePane(pMainMenu, false);
    }

    /**
     *
     */
    public void setImagesButton() {
        Image iVehiclePNG = new Image("Images/vehicles.png");
        Image iClientPNG = new Image("Images/clients.png");
        Image iRentPNG = new Image("Images/car-key.png");
        Image iDevolPNG = new Image("Images/return.png");
        Image iReportPNG = new Image("Images/report.png");
        Image iLogoPNG = new Image("Images/Logo.png");
        iVehicle.setImage(iVehiclePNG);
        iClient.setImage(iClientPNG);
        iRent.setImage(iRentPNG);
        iDevol.setImage(iDevolPNG);
        iReport.setImage(iReportPNG);
        iLogo.setImage(iLogoPNG);
    }

    /**
     *
     * @return
     */
    public Pane getPane() {
        return pMainMenu;
    }

    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    public void onGClient(ActionEvent event) throws IOException {
        fxGUI.disablePane(pMainMenu, true);
        fxGUI.showGClient();
    }

    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    public void onGVehicle(ActionEvent event) throws IOException {
        fxGUI.disablePane(pMainMenu, true);
        fxGUI.showGVehicle();
    }

    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    public void onGDevol(ActionEvent event) throws IOException {
        fxGUI.disablePane(pMainMenu, true);
        fxGUI.showGDevolution();
    }

    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    public void onGRent(ActionEvent event) throws IOException {
        fxGUI.disablePane(pMainMenu, true);
        fxGUI.showGRent();
    }

    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    public void onGReport(ActionEvent event) throws IOException {
        fxGUI.disablePane(pMainMenu, true);
        fxGUI.showSelectReport();
    }

    /**
     *
     * @param event
     */
    @FXML
    public void onExit(ActionEvent event) {
        System.exit(0);
    }

    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    public void onGBrand(ActionEvent event) throws IOException {
        fxGUI.disablePane(pMainMenu, true);
        fxGUI.showGBrand(true);
    }

    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    public void onGCity(ActionEvent event) throws IOException {
        fxGUI.disablePane(pMainMenu, true);
        fxGUI.showGCity(true);
    }

    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    public void onGType(ActionEvent event) throws IOException {
        fxGUI.disablePane(pMainMenu, true);
        fxGUI.showGType(true);
    }

    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    public void onRClient(ActionEvent event) throws IOException {
        fxGUI.disablePane(pMainMenu, true);
        fxGUI.showReportClient(true);
    }

    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    public void onRRent(ActionEvent event) throws IOException {
        fxGUI.disablePane(pMainMenu, true);
        fxGUI.showReportRent(true);

    }

    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    public void onRVehicle(ActionEvent event) throws IOException {
        fxGUI.disablePane(pMainMenu, true);
        fxGUI.showReportVehicles(true);
    }

    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    public void onListEmployee(ActionEvent event) throws IOException {
        fxGUI.disablePane(pMainMenu, true);
        fxGUI.showListEmployee();
    }

    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    public void onTopEmployee(ActionEvent event) throws IOException {
        fxGUI.disablePane(pMainMenu, true);
        fxGUI.showTopEmployee();
    }

    /**
     *
     * @param event
     */
    @FXML
    public void onKeyPressed(KeyEvent event) {
        if (event.getCode() == event.getCode().UP && iLogo.getLayoutY() >= 30) {
            iLogo.setLayoutY(iLogo.getLayoutY() - 1);
        } else if (event.getCode() == event.getCode().DOWN && iLogo.getLayoutY() <= 319) {
            iLogo.setLayoutY(iLogo.getLayoutY() + 1);
        } else if (event.getCode() == event.getCode().LEFT && iLogo.getLayoutX() >= 365) {
            iLogo.setLayoutX(iLogo.getLayoutX() - 1);
        } else if (event.getCode() == event.getCode().RIGHT && iLogo.getLayoutX() <= 881) {
            iLogo.setLayoutX(iLogo.getLayoutX() + 1);
        }
    }

    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    public void onShowSpeed(ActionEvent event) throws IOException {
        fxGUI.disablePane(pMainMenu, true);
        fxGUI.showSpeed();
    }

    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    public void onImportClient(ActionEvent event) throws IOException {
        rc.importClient();
        fxGUI.saveData();
    }

    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    public void onImportVehicle(ActionEvent event) throws IOException {
        rc.importVehicle();
        fxGUI.saveData();
    }

    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    public void onShowStatRent(ActionEvent event) throws IOException {
        fxGUI.disablePane(pMainMenu, true);
        fxGUI.showPieChart();
    }

    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    public void onShowStatObject(ActionEvent event) throws IOException {
        fxGUI.disablePane(pMainMenu, true);
        fxGUI.showBarChart();
    }
}
