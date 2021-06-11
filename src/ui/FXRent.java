package ui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import model.*;

/**
 *
 * @author DELL
 */
public class FXRent {

    private static final long serialVersionUID = 1;
    private final String PREFTICKET = "TRC";

    @FXML
    private Pane rPane;

    @FXML
    private StackPane stackPane;

    //********* Set Images *********\\
    @FXML
    private ImageView iAddRent;

    @FXML
    private ImageView iRefreshRent;

    @FXML
    private ImageView iSelectClientRent;

    @FXML
    private ImageView iSelectVehicleRent;

    //********** Buttons Rent ************\\
    @FXML
    private Button btnNewR;

    @FXML
    private Button btnReverseR;

    @FXML
    private Button btnSearchClientR;

    @FXML
    private Button btnSearchCarR;

    @FXML
    private JFXButton btnAddDateRent;

    @FXML
    private JFXButton btnCleanDateR;

    @FXML
    private JFXButton btnAddRent;

    //********* TextFields Rent ***********\\
    @FXML
    private JFXTextField txtCodeCR;

    @FXML
    private JFXTextField txtAddresCR;

    @FXML
    private JFXTextField txtPhoneCR;

    @FXML
    private JFXTextField txtNameCR;

    @FXML
    private JFXTextField txtCodeVR;

    @FXML
    private JFXTextField txtPlateVR;

    @FXML
    private JFXTextField txtBrandVR;

    @FXML
    private JFXTextField txtPriceVR;

    @FXML
    private JFXTextField txtModelVR;

    @FXML
    private JFXDatePicker dpDateFR;

    @FXML
    private JFXTextField txtAmountDiasR;

    @FXML
    private JFXTextField dpDateIF;

    @FXML
    private TextField txtTicketR;

    @FXML
    private TextField txtTotalPrice;

    private boolean today;

    private RentingCar rc;
    private FXController fxGUI;
    DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /**
     *
     * @param rc
     * @param fxGUI
     */
    public FXRent(RentingCar rc, FXController fxGUI) {
        this.rc = rc;
        this.fxGUI = fxGUI;
    }

    /**
     *
     */
    public void setImagesButton() {
        Image iAddRentPNG = new Image("Images/add-file.png");
        Image iRefreshRentPNG = new Image("Images/return-sign.png");
        Image iSelectClientRentPNG = new Image("Images/clients.png");
        Image iSelectVehicleRentPNG = new Image("Images/vehicles.png");
        iAddRent.setImage(iAddRentPNG);
        iRefreshRent.setImage(iRefreshRentPNG);
        iSelectClientRent.setImage(iSelectClientRentPNG);
        iSelectVehicleRent.setImage(iSelectVehicleRentPNG);
    }

    /**
     *
     * @return
     */
    public Pane getPane() {
        return rPane;
    }

    /**
     *
     */
    public void btnInitialize() {
        btnNewR.setDisable(false);
        btnReverseR.setDisable(true);
        btnSearchCarR.setDisable(true);
        btnSearchClientR.setDisable(true);
        btnAddDateRent.setDisable(true);
        btnCleanDateR.setDisable(true);
        btnAddRent.setDisable(true);
    }

    /**
     *
     * @param stat
     */
    public void statButtonsWhenNew(boolean stat) {
        btnNewR.setDisable(!stat);
        btnReverseR.setDisable(stat);
        btnSearchCarR.setDisable(stat);
        btnSearchClientR.setDisable(stat);
        btnAddDateRent.setDisable(stat);
        btnCleanDateR.setDisable(stat);
        btnAddRent.setDisable(stat);
    }

    /**
     *
     * @param event
     */
    @FXML
    public void onNewR(ActionEvent event) {
        statButtonsWhenNew(false);
        txtTicketR.setText(PREFTICKET + rc.getCodeTicket());
        dpDateIF.setText(formatDate.format(LocalDate.now()));
    }

    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    public void onSearchClientsInRent(ActionEvent event) throws IOException {
        fxGUI.disablePane(rPane, true);
        fxGUI.showListClient(false);
        fxGUI.setOtherWindowSelected(true);
    }

    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    public void onSearchVehicleInRent(ActionEvent event) throws IOException {
        fxGUI.disablePane(rPane, true);
        fxGUI.showListVehicle(false);
        fxGUI.setOtherWindowSelected(true);
    }

    /**
     *
     * @param clientSelected
     */
    public void setTextClient(Client clientSelected) {
        txtCodeCR.setText(clientSelected.getCodeP() + "");
        txtNameCR.setText(clientSelected.getNameLN());
        txtAddresCR.setText(clientSelected.getAddressC());
        txtPhoneCR.setText(clientSelected.getPhoneC() + "");
    }

    /**
     *
     * @param carSelected
     */
    public void setTextCar(Car carSelected) {
        txtCodeVR.setText(carSelected.getCodeV() + "");
        txtPlateVR.setText(carSelected.getPlate());
        txtModelVR.setText(carSelected.getModel());
        txtPriceVR.setText(carSelected.getPriceXDay() + "");
        txtBrandVR.setText(carSelected.getNameBrand());
    }

    /**
     *
     * @param event
     */
    @FXML
    public void onAddDateRent(ActionEvent event) {
        try {
            Duration diff = Duration.between(LocalDate.now().atStartOfDay(), dpDateFR.getValue().atStartOfDay());
            Long days = diff.toDays();
            if (days == 0) {
                today = true;
                days = Long.parseLong(1 + "");
            }
            txtAmountDiasR.setText(days + "");
            int total = (int) (Double.parseDouble(txtPriceVR.getText()) * days);
            txtTotalPrice.setText(total + "");
        } catch (NullPointerException e) {
            fxGUI.showAlert(false, "Debes seleccionar una fecha final", stackPane);
        }
    }

    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    public void onAddRent(ActionEvent event) throws IOException {
        if (!txtTicketR.getText().equals("") && !txtCodeCR.getText().equals("") && !txtCodeVR.getText().equals("") && !txtAmountDiasR.getText().equals("")) {
            Status stat;
            if (today) {
                stat = Status.EXPIRES_TODAY;
            } else {
                stat = Status.DEFERRED;
            }
            if (rc.addRent(rc.getCode(), rc.getCodeTicket(), rc.searchClientSelected(Integer.parseInt(txtCodeCR.getText())),
                    rc.findCar(Integer.parseInt(txtCodeVR.getText())), LocalDate.now(), dpDateFR.getValue(),
                    Integer.parseInt(txtAmountDiasR.getText()), stat, 0, 0, Integer.parseInt(txtTotalPrice.getText()))) {
                fxGUI.showAlert(true, "Se ha agregado el alquiler", stackPane);
                fxGUI.saveData();
                btnInitialize();
                txtTicketR.setText(null);
                onReverseRent(event);
                txtCodeVR.clear();
            } else {
                fxGUI.showAlert(false, "Por favor ingresa una fecha validad", stackPane);
                onCleanDateRent(event);
            }
        } else {
            fxGUI.showAlert(false, "Debes de seleccionar un vehículo y un cliente para realizar el alquiler", stackPane);
        }
    }

    /**
     *
     * @param event
     */
    @FXML
    public void onCleanDateRent(ActionEvent event) {
        dpDateFR.setValue(null);
        txtAmountDiasR.setText(null);
        txtTotalPrice.setText(null);
    }

    /**
     *
     * @param event
     */
    @FXML
    public void onReverseRent(ActionEvent event) {
        onCleanDateRent(event);
        txtCodeCR.setText(null);
        txtNameCR.setText(null);
        txtAddresCR.setText(null);
        txtPhoneCR.setText(null);
        txtCodeCR.setText(null);
        txtModelVR.setText(null);
        txtBrandVR.setText(null);
        txtPriceVR.setText(null);
        txtPlateVR.setText(null);
    }
}
