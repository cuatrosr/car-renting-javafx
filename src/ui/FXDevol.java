package ui;

import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import exception.Payed;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import model.*;

/**
 *
 * @author usuario
 */
public class FXDevol {

    private static final long serialVersionUID = 1;
    @FXML
    private Pane dPane;

    @FXML
    private Pane paneCardP;

    @FXML
    private Pane paneMoneyP;

    @FXML
    private StackPane stackPane;

    @FXML
    private StackPane stackPane1;

    @FXML
    private StackPane stackPane2;

    //********* Set Images *********\\
    @FXML
    private ImageView iSelectRentDevol;

    @FXML
    private ImageView iPayDevol;

    @FXML
    private ImageView iSearchTicketRent;

    @FXML
    private ImageView iSearchIDRent;

    //********* TextField Devol ***********\\
    @FXML
    private JFXTextField txtCodeClientD;

    @FXML
    private JFXTextField txtNameClientD;

    @FXML
    private JFXTextField txtSearchIDCR;

    @FXML
    private JFXTextField txtSearchTicketR;

    //******** Table Rent Total *********\\
    @FXML
    private TableView<Rent> tblRent;

    @FXML
    private TableColumn<Rent, String> tblcTicketR;

    @FXML
    private TableColumn<Rent, Long> tblcIDCR;

    @FXML
    private TableColumn<Rent, String> tblcNameCR;

    @FXML
    private TableColumn<Rent, Long> tblcPhoneCR;

    @FXML
    private TableColumn<Rent, Integer> tblcCodeVR;

    @FXML
    private TableColumn<Rent, String> tblcPlateVR;

    @FXML
    private TableColumn<Rent, String> tblcModelVR;

    @FXML
    private TableColumn<Rent, String> tblcTypeVR;

    @FXML
    private TableColumn<Rent, Integer> tblcDaysR;

    @FXML
    private TableColumn<Rent, Double> tblcTotalR;

    //************** Table Rent Selected **************\\
    @FXML
    private TableView<Rent> tblDevol;

    @FXML
    private TableColumn<Rent, String> tblcTicketD;

    @FXML
    private TableColumn<Rent, String> tblcNameCD;

    @FXML
    private TableColumn<Rent, Integer> tblcIDVD;

    @FXML
    private TableColumn<Rent, String> tblcPlateVD;

    @FXML
    private TableColumn<Rent, String> tblcDateID;

    @FXML
    private TableColumn<Rent, String> tblcDateFD;

    @FXML
    private TableColumn<Rent, Integer> tblcDaysD;

    @FXML
    private TableColumn<Rent, Integer> tblcDelayD;

    @FXML
    private TableColumn<Rent, Integer> tblcMultD;

    @FXML
    private TableColumn<Rent, Status> tblcStatD;

    @FXML
    private TableColumn<Rent, Integer> tblcTotal;

    //******* TextFields Value Pay ****************\\
    @FXML
    private JFXTextField txtDaysD;

    @FXML
    private JFXTextField txtSubPriceD;

    @FXML
    private JFXTextField txtPriceCD;

    @FXML
    private JFXTextField txtDealyD;

    @FXML
    private JFXTextField txtMultD;

    @FXML
    private JFXTextField txtPriceTotalD;

    //************ Radio Button Paid ************\\
    @FXML
    private JFXRadioButton rbCardP;

    @FXML
    private ToggleGroup formPaid;

    @FXML
    private JFXRadioButton rbMoneyP;

    //*********** TextFeilds Paid ***********\\
    @FXML
    private JFXTextField txtNameTCP;

    @FXML
    private JFXTextField txtCodeSegurityCP;

    @FXML
    private JFXTextField txtValueCP;

    @FXML
    private JFXTextField txtNameMP;

    @FXML
    private JFXTextField txtValueMP;

    private int codeToPay;
    private Rent rentToPay;
    private Card cardToPay;
    private Money moneyToPay;

    private RentingCar rc;
    private FXController fxGUI;

    /**
     *
     * @param rc
     * @param fxGUI
     */
    public FXDevol(RentingCar rc, FXController fxGUI) {
        this.rc = rc;
        this.fxGUI = fxGUI;
    }

    /**
     *
     */
    public void setImagesButton() {
        Image iSelectRentDevolPNG = new Image("Images/car-key.png");
        Image iPayDevolPNG = new Image("Images/pay-check.png");
        iSelectRentDevol.setImage(iSelectRentDevolPNG);
        iPayDevol.setImage(iPayDevolPNG);
    }

    /**
     *
     */
    public void setImagesList() {
        Image iSearchRentPNG = new Image("Images/search.png");
        iSearchIDRent.setImage(iSearchRentPNG);
        iSearchTicketRent.setImage(iSearchRentPNG);
    }

    /**
     *
     * @return
     */
    public Pane getPane() {
        return dPane;
    }

    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    public void onListRentoinDevol(ActionEvent event) throws IOException {
        fxGUI.disablePane(dPane, true);
        fxGUI.showListRent();
    }

    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    public void onSavePay(ActionEvent event) throws IOException {
        if (rc.findRentSelected(codeToPay) != null) {
            if (rc.findRentSelected(codeToPay).getStatus() == Status.PAID) {
                fxGUI.showAlert(false, "Esta renta ya se pago, selecciona otra", stackPane);
                codeToPay = 0;
                moneyToPay = null;
                cardToPay = null;
                rentToPay = null;
            } else {
                fxGUI.disablePane(dPane, true);
                fxGUI.showSavePay();
            }
        } else {
            fxGUI.showAlert(false, "Por favor selecciona una renta para pagar", stackPane);
        }
    }

    /**
     *
     */
    public void onTableListRent() {
        List<Rent> rents = rc.sortRentTicket();
        ObservableList<Rent> newTableRent;
        newTableRent = FXCollections.observableArrayList(rents);

        tblRent.setItems(newTableRent);
        tblcTicketR.setCellValueFactory(new PropertyValueFactory<>("nameTicket"));
        tblcIDCR.setCellValueFactory(new PropertyValueFactory<>("idClient"));
        tblcNameCR.setCellValueFactory(new PropertyValueFactory<>("nameClient"));
        tblcPhoneCR.setCellValueFactory(new PropertyValueFactory<>("phoneClient"));
        tblcCodeVR.setCellValueFactory(new PropertyValueFactory<>("idCar"));
        tblcPlateVR.setCellValueFactory(new PropertyValueFactory<>("plateCar"));
        tblcModelVR.setCellValueFactory(new PropertyValueFactory<>("nameModel"));
        tblcTypeVR.setCellValueFactory(new PropertyValueFactory<>("nameType"));
        tblcDaysR.setCellValueFactory(new PropertyValueFactory<>("days"));
        tblcTotalR.setCellValueFactory(new PropertyValueFactory<>("priceTotal"));

    }

    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    public void onSelectRent(MouseEvent event) throws IOException {
        Rent rentSelected;
        if (event.getClickCount() == 2) {
            rentSelected = tblRent.getSelectionModel().getSelectedItem();
            if (rentSelected != null) {
                fxGUI.showAlert(true, "Se ha seleccionado correctamente el objeto", stackPane1);
                fxGUI.setSelectObjectCode(rentSelected.getCodeR());
                txtNameClientD.setText(rentSelected.getNameClient());
                txtCodeClientD.setText(rentSelected.getNameClient());
                rc.uptadeStatRent(rentSelected.getCodeR());
                showSelectedRentInTable(rentSelected.getCodeR());
            }
        }
    }

    /**
     *
     * @param code
     * @throws IOException
     */
    public void showSelectedRentInTable(int code) throws IOException {
        List<Rent> rentSelect = new ArrayList<>();
        rentSelect.add(rc.findRentSelected(code));
        if (rentSelect.size() == 1) {
            rentToPay = rentSelect.get(0);
            ObservableList<Rent> newTableRentSelected;
            newTableRentSelected = FXCollections.observableArrayList(rentSelect);

            tblDevol.setItems(newTableRentSelected);
            tblcTicketD.setCellValueFactory(new PropertyValueFactory<>("nameTicket"));
            tblcNameCD.setCellValueFactory(new PropertyValueFactory<>("nameClient"));
            tblcIDVD.setCellValueFactory(new PropertyValueFactory<>("idCar"));
            tblcPlateVD.setCellValueFactory(new PropertyValueFactory<>("plateCar"));
            tblcDateID.setCellValueFactory(new PropertyValueFactory<>("stringFinitial"));
            tblcDateFD.setCellValueFactory(new PropertyValueFactory<>("stringFfinal"));
            tblcDaysD.setCellValueFactory(new PropertyValueFactory<>("days"));
            tblcDelayD.setCellValueFactory(new PropertyValueFactory<>("delay"));
            tblcMultD.setCellValueFactory(new PropertyValueFactory<>("mult"));
            tblcStatD.setCellValueFactory(new PropertyValueFactory<>("status"));
            tblcTotal.setCellValueFactory(new PropertyValueFactory<>("priceTotal"));

            codeToPay = rentSelect.get(0).getCodeR();
            setTextDevolPay(rentSelect.get(0));
            fxGUI.saveData();
        }
    }

    /**
     *
     * @param selected
     */
    public void setTextDevolPay(Rent selected) {
        txtDaysD.setText(selected.getDays() + "");
        txtPriceCD.setText(selected.getCarR().getPriceXDay() + "");
        txtSubPriceD.setText((selected.getPriceTotal() - selected.getMult()) + "");
        txtDealyD.setText(selected.getDelay() + "");
        txtMultD.setText(selected.getMult() + "");
        txtPriceTotalD.setText(selected.getPriceTotal() + "");
    }

    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    public void onPayDevol(ActionEvent event) throws IOException {
        if (rc.findRentSelected(codeToPay).getStatus() == Status.PAID) {
        } else {
            selectOption();
            fxGUI.saveData();
        }

    }

    /**
     *
     */
    public void selectOption() {
        if (rbCardP.isSelected()) {
            try {
                optionCard();
                fxGUI.showAlert(true, "Se ha pagado con extio esta renta", stackPane2);
                rc.payRent(codeToPay);
                tblDevol.refresh();
            } catch (Payed e) {
                fxGUI.showAlert(false, "El pago no fue exitoso, dinero insuficiente", stackPane2);
            }
        } else if (rbMoneyP.isSelected()) {
            try {
                optionMoney();
                fxGUI.showAlert(true, "Se ha pagado con extio esta renta", stackPane2);
                rc.payRent(codeToPay);
                tblDevol.refresh();
            } catch (Payed e) {
                fxGUI.showAlert(false, "El pago no fue exitoso, dinero insuficiente", stackPane2);
            }
        } else {
            fxGUI.showAlert(false, "Por favor selecciona una opción a pagar", stackPane2);
        }
    }

    /**
     *
     * @throws Payed
     */
    public void optionCard() throws Payed {
        if (!txtNameTCP.getText().equals("") && !txtCodeSegurityCP.getText().equals("") && !txtValueCP.getText().equals("")) {
            try {
                cardToPay = rc.addCard(Integer.parseInt(txtCodeSegurityCP.getText()), Double.parseDouble(txtValueCP.getText()), txtNameTCP.getText(), Double.parseDouble(txtPriceTotalD.getText()));
            } catch (NumberFormatException e) {
                fxGUI.showAlert(false, "No puedes ingresar letras en el apartdo de saldo o codigo", stackPane2);
            }
        } else {
            fxGUI.showAlert(false, "Por favor llena todos los campos", stackPane2);
        }
    }

    /**
     *
     * @throws Payed
     */
    public void optionMoney() throws Payed {
        if (!txtNameMP.getText().equals("") && !txtValueMP.getText().equals("")) {
            try {
                moneyToPay = rc.addMoney(Double.parseDouble(txtValueMP.getText()), txtNameMP.getText(), Double.parseDouble(txtPriceTotalD.getText()));
            } catch (NumberFormatException e) {
                fxGUI.showAlert(false, "No puedes ingresar letras en el apartdo de saldo", stackPane2);
            }
        } else {
            fxGUI.showAlert(false, "Por favor llena todos los campos", stackPane2);
        }
    }

    /**
     *
     * @param event
     */
    @FXML
    public void onSelectCard(MouseEvent event) {
        paneCardP.setDisable(false);
        paneMoneyP.setDisable(true);
    }

    /**
     *
     * @param event
     */
    @FXML
    public void onSelectMoney(MouseEvent event) {
        paneCardP.setDisable(true);
        paneMoneyP.setDisable(false);
    }

    /**
     *
     * @param id
     */
    public void onTableSearchIDCR(long id) {
        tblRent.getItems().clear();

        List<Rent> rents = rc.searchIDCR(id, rc.sortRentIDClient());
        ObservableList<Rent> newTableRent;
        newTableRent = FXCollections.observableArrayList(rents);

        tblRent.setItems(newTableRent);
        tblcTicketR.setCellValueFactory(new PropertyValueFactory<>("nameTicket"));
        tblcIDCR.setCellValueFactory(new PropertyValueFactory<>("idClient"));
        tblcNameCR.setCellValueFactory(new PropertyValueFactory<>("nameClient"));
        tblcPhoneCR.setCellValueFactory(new PropertyValueFactory<>("phoneClient"));
        tblcCodeVR.setCellValueFactory(new PropertyValueFactory<>("idCar"));
        tblcPlateVR.setCellValueFactory(new PropertyValueFactory<>("plateCar"));
        tblcModelVR.setCellValueFactory(new PropertyValueFactory<>("nameModel"));
        tblcTypeVR.setCellValueFactory(new PropertyValueFactory<>("nameType"));
        tblcDaysR.setCellValueFactory(new PropertyValueFactory<>("days"));
        tblcTotalR.setCellValueFactory(new PropertyValueFactory<>("priceTotal"));
    }

    /**
     *
     * @param event
     */
    @FXML
    public void onSearchIDCR(ActionEvent event) {
        if (!txtSearchIDCR.getText().equals("")) {
            try {
                onTableSearchIDCR(Long.parseLong(txtSearchIDCR.getText()));
            } catch (NumberFormatException e) {
                fxGUI.showAlert(false, "No puedes ingresar letrar en este criterio de busquedad", stackPane1);
            }
        } else {
            fxGUI.showAlert(false, "Por favor ingresa un criterio de busquedad", stackPane1);
        }
    }

    /**
     *
     * @param event
     */
    @FXML
    public void onShowAllRent(ActionEvent event) {
        tblRent.getItems().clear();
        onTableListRent();
    }

    /**
     *
     * @param ticket
     */
    public void onTableSearchTicket(int ticket) {
        tblRent.getItems().clear();

        List<Rent> rents = rc.binaryRent(ticket, rc.sortRentTicket());
        ObservableList<Rent> newTableRent;
        newTableRent = FXCollections.observableArrayList(rents);

        tblRent.setItems(newTableRent);
        tblcTicketR.setCellValueFactory(new PropertyValueFactory<>("nameTicket"));
        tblcIDCR.setCellValueFactory(new PropertyValueFactory<>("idClient"));
        tblcNameCR.setCellValueFactory(new PropertyValueFactory<>("nameClient"));
        tblcPhoneCR.setCellValueFactory(new PropertyValueFactory<>("phoneClient"));
        tblcCodeVR.setCellValueFactory(new PropertyValueFactory<>("idCar"));
        tblcPlateVR.setCellValueFactory(new PropertyValueFactory<>("plateCar"));
        tblcModelVR.setCellValueFactory(new PropertyValueFactory<>("nameModel"));
        tblcTypeVR.setCellValueFactory(new PropertyValueFactory<>("nameType"));
        tblcDaysR.setCellValueFactory(new PropertyValueFactory<>("days"));
        tblcTotalR.setCellValueFactory(new PropertyValueFactory<>("priceTotal"));
    }

    /**
     * Search Ticke rent 
     * @param event
     */
    @FXML
    public void onSearchTicketR(ActionEvent event) {
        if(!txtSearchTicketR.getText().equals("")){
            try {
                onTableSearchTicket(Integer.parseInt(txtSearchTicketR.getText()));
            } catch (NumberFormatException e) {
                fxGUI.showAlert(false, "No puedes ingresas letras en este espacio\nSí estas ingresando todo el ticket completo,\n"
                        + "prueba sin el Prefijo, es decir, sin el TRC", stackPane1);
            }
        } else {
            fxGUI.showAlert(false, "Por favor ingresa un criterio de busqueda", stackPane1);
        }
    }
    
    
}
