package ui;

import java.io.IOException;
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
import model.*;

public class FXDevol {

    private static final long serialVersionUID = 1;
    @FXML
    private Pane dPane;

    //********* Set Images *********\\
    @FXML
    private ImageView iSelectRentDevol;

    @FXML
    private ImageView iPayDevol;

    @FXML
    private ImageView iSearchTicketRent;

    @FXML
    private ImageView iSearchIDRent;

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
        fxGUI.disablePane(dPane, true);
        fxGUI.showSavePay();
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
    void onSelectRent(MouseEvent event) {

    }

}
