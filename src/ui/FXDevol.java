package ui;

import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import model.*;

public class FXDevol {

    private static final long serialVersionUID = 1;
    @FXML
    private Pane dPane;

    @FXML
    private StackPane stackPane;

    @FXML
    private StackPane stackPane1;

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

    private RentingCar rc;
    private FXController fxGUI;

    public FXDevol(RentingCar rc, FXController fxGUI) {
        this.rc = rc;
        this.fxGUI = fxGUI;
    }

    public void setImagesButton() {
        Image iSelectRentDevolPNG = new Image("Images/car-key.png");
        Image iPayDevolPNG = new Image("Images/pay-check.png");
        iSelectRentDevol.setImage(iSelectRentDevolPNG);
        iPayDevol.setImage(iPayDevolPNG);
    }

    public void setImagesList() {
        Image iSearchRentPNG = new Image("Images/search.png");
        iSearchIDRent.setImage(iSearchRentPNG);
        iSearchTicketRent.setImage(iSearchRentPNG);
    }

    public Pane getPane() {
        return dPane;
    }

    @FXML
    public void onListRentoinDevol(ActionEvent event) throws IOException {
        fxGUI.disablePane(dPane, true);
        fxGUI.showListRent();
    }

    @FXML
    public void onSavePay(ActionEvent event) throws IOException {
        /*
        fxGUI.disablePane(dPane, true);
        fxGUI.showSavePay();
        
*/
        System.out.println("FFF");
    }

    public void onTableListRent() {
        List<Rent> rents = rc.getListRent();
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

    @FXML
    public void onSelectRent(MouseEvent event) {
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

    public void showSelectedRentInTable(int code) {
        List<Rent> rentSelect = new ArrayList<>();
        rentSelect.add(rc.findRentSelected(code));
        if (rentSelect.size() == 1) {
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

            setTextDevolPay(rentSelect.get(0));
        }
    }

    public void setTextDevolPay(Rent selected) {
        txtDaysD.setText(selected.getDays() + "");
        txtPriceCD.setText(selected.getCarR().getPriceXDay() + "");
        txtSubPriceD.setText((selected.getPriceTotal() - selected.getMult()) + "");
        txtDealyD.setText(selected.getDelay() + "");
        txtMultD.setText(selected.getMult() + "");
        txtPriceTotalD.setText(selected.getPriceTotal() + "");
    }

}
