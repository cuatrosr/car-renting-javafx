package ui;

import com.jfoenix.controls.*;
import exception.Email;
import exception.Reference;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import model.*;

public class FXClient {

    private static final long serialVersionUID = 1;

    @FXML
    private StackPane stackPane;

    @FXML
    private StackPane stackPane1;

    @FXML
    private Pane pClient;

    //********* Set Images *********\\
    @FXML
    private ImageView iAddClient;

    @FXML
    private ImageView iSaveClient;

    @FXML
    private ImageView iEditClient;

    @FXML
    private ImageView iRemoveClient;

    @FXML
    private ImageView iOpenCity;

    @FXML
    private ImageView iSearchClient;

    @FXML
    private ImageView iSearchInListClient;

    //********* Buttons Client *********\\
    @FXML
    private Button btnNewClient;

    @FXML
    private Button btnSaveClient;

    @FXML
    private Button btnEditClient;

    @FXML
    private Button btnRemovClient;

    @FXML
    private Button btnListClients;

    @FXML
    private Button btnCityClient;

    //********* Text Field *********\\
    @FXML
    private JFXTextField txtNameClient;

    @FXML
    private JFXTextField txtLastNameClient;

    @FXML
    private JFXTextField txtAddressClient;

    @FXML
    private JFXTextField txtCodeClient;

    @FXML
    private JFXTextField txtIDClient;

    @FXML
    private JFXTextField txtPhoneClient;

    @FXML
    private JFXTextField txtEmailClient;

    @FXML
    private JFXComboBox<String> cbCityClient;

    //*********** Table Client ************\\
    @FXML
    private TableView<Client> tblClient;

    @FXML
    private TableColumn<Client, Integer> tblcCodeClient;

    @FXML
    private TableColumn<Client, Long> tblcIDClient;

    @FXML
    private TableColumn<Client, String> tblcNameClient;

    @FXML
    private TableColumn<Client, String> tblcLastNameClient;

    @FXML
    private TableColumn<Client, Long> tblcPhoneClient;

    @FXML
    private TableColumn<Client, String> tblcAddressClient;

    @FXML
    private TableColumn<Client, String> tblcCity;

    @FXML
    private TableColumn<Client, String> tblcEmailClient;

    private RentingCar rc;
    private FXController fxGUI;

    public FXClient(RentingCar rc, FXController fxGUI) {
        this.rc = rc;
        this.fxGUI = fxGUI;
    }

    public void setImagesButton() {
        Image iAddClientPNG = new Image("Images/add-file.png");
        Image iSaveClientPNG = new Image("Images/save-disk.png");
        Image iEditClientPNG = new Image("Images/add-report.png");
        Image iRemoveClientPNG = new Image("Images/remove-report.png");
        Image iOpenCityPNG = new Image("Images/city.png");
        Image iSearchClientPNG = new Image("Images/search.png");
        iAddClient.setImage(iAddClientPNG);
        iSaveClient.setImage(iSaveClientPNG);
        iEditClient.setImage(iEditClientPNG);
        iRemoveClient.setImage(iRemoveClientPNG);
        iOpenCity.setImage(iOpenCityPNG);
        iSearchClient.setImage(iSearchClientPNG);
    }

    public void setImagesList() {
        Image iSearchClientPNG = new Image("Images/search.png");
        iSearchInListClient.setImage(iSearchClientPNG);
    }

    public Pane getPane() {
        return pClient;
    }

    public void btnInitialize() {
        btnNewClient.setDisable(false);
        btnSaveClient.setDisable(true);
        btnEditClient.setDisable(true);
        btnRemovClient.setDisable(true);
        btnCityClient.setDisable(false);
        btnListClients.setDisable(false);
        cbCityClient.setDisableAnimation(true);
    }

    public void statButtonsWhenNew(boolean stat) {
        btnNewClient.setDisable(stat);
        btnSaveClient.setDisable(!stat);
        btnEditClient.setDisable(stat);
        btnRemovClient.setDisable(stat);
        btnCityClient.setDisable(stat);
        btnListClients.setDisable(stat);
    }

    public void finishedAction() {
        fxGUI.setSelectObjectCode(0);
        fxGUI.setSelectedInOtherWindow(false);
        txtCodeClient.clear();
        txtIDClient.clear();
        txtNameClient.clear();
        txtLastNameClient.clear();
        txtPhoneClient.clear();
        txtAddressClient.clear();
        txtEmailClient.clear();
        cbCityClient.setValue(null);
        onTableListClient();
        btnInitialize();
    }

    @FXML
    public void onGCity(ActionEvent event) throws IOException {
        fxGUI.disablePane(pClient, true);
        fxGUI.showGCity(false);
    }

    @FXML
    public void onListClients(ActionEvent event) throws IOException {
        fxGUI.disablePane(pClient, true);
        fxGUI.showListClient(true);
    }

    @FXML
    public void onNewClient(ActionEvent event) {
        statButtonsWhenNew(true);
        txtCodeClient.setText(rc.getCode() + "");
        showCitiesDisp();
    }

    @FXML
    public void onSaveClient(ActionEvent event) throws IOException {
        if (!txtIDClient.getText().equals("") && !txtNameClient.getText().equals("") && !txtLastNameClient.getText().equals("")
                && !txtAddressClient.getText().equals("") && !txtPhoneClient.getText().equals("") && !txtEmailClient.getText().equals("")
                && cbCityClient.getValue() != null) {
            try {
                if (rc.addClient(txtAddressClient.getText(), Long.parseLong(txtPhoneClient.getText()), txtEmailClient.getText(),
                        rc.findCitySelected(cbCityClient.getValue()), rc.getCode(), 0, txtNameClient.getText(),
                        txtLastNameClient.getText(), Long.parseLong(txtIDClient.getText()))) {
                    fxGUI.showAlert(true, "Se ha creado el cliente correctamente", stackPane);
                    fxGUI.saveData();
                    btnInitialize();
                    txtCodeClient.clear();
                    txtIDClient.clear();
                    txtNameClient.clear();
                    txtLastNameClient.clear();
                    txtPhoneClient.clear();
                    txtAddressClient.clear();
                    txtEmailClient.clear();
                    cbCityClient.setValue(null);
                } else {
                    fxGUI.showAlert(false, "Ya se encuentra un cliente con esta ID, no se creo el cliente", stackPane);
                    txtIDClient.clear();
                }
            } catch (Email e) {
                fxGUI.showAlert(false, "El correo debe de contener una arroba '@'", stackPane);
                txtEmailClient.clear();
            } catch (NumberFormatException e) {
                fxGUI.showAlert(false, "No puedes ingresar letras en la ID o en el telefono", stackPane);
                txtIDClient.clear();
                txtPhoneClient.clear();
            }
        } else {
            fxGUI.showAlert(false, "Por favor llena todos los campos, no se creo el cliente", stackPane);
        }
    }

    @FXML
    public void onEditClient(ActionEvent event) throws IOException {
        if (!txtIDClient.getText().equals("") && !txtNameClient.getText().equals("") && !txtLastNameClient.getText().equals("")
                && !txtAddressClient.getText().equals("") && !txtPhoneClient.getText().equals("") && !txtEmailClient.getText().equals("")
                && cbCityClient.getValue() != null) {
            try {
                if (rc.uptadeClient(txtAddressClient.getText(), Long.parseLong(txtPhoneClient.getText()), txtEmailClient.getText(),
                        rc.findCitySelected(cbCityClient.getValue()), Integer.parseInt(txtCodeClient.getText()), txtNameClient.getText(),
                        txtLastNameClient.getText(), Long.parseLong(txtIDClient.getText()))) {
                    fxGUI.showAlert(true, "Se actualizo el cliente con exito", stackPane);
                    fxGUI.saveData();
                } else {
                    fxGUI.showAlert(false, "Ya existe otra cliente con la misma ID, no se actualizo", stackPane);
                }
            } catch (NumberFormatException e) {
                fxGUI.showAlert(false, "No puedes ingresar letras en la Id o telefono, no se actualizo", stackPane);
            } catch (Email e) {
                fxGUI.showAlert(false, "El email debe de contoner una arroba '@', no se actualizo", stackPane);
            }
        } else {
            fxGUI.showAlert(false, "Por favor llena todos los campos, no se actualizo", stackPane);
        }
        finishedAction();
    }

    @FXML
    public void onRemoveClient(ActionEvent event) throws IOException {
        try {
            rc.removeClient(fxGUI.getSelectObjectCode());
            fxGUI.showAlert(true, "Se ha elminado el cliente con exito", stackPane);
            fxGUI.saveData();
        } catch (Reference e) {
            fxGUI.showAlert(false, "Este cliente esta referenciado en otro objeto\nNo se elimino", stackPane);
        }
        finishedAction();
    }

    @FXML
    public void onSelecteClient(MouseEvent event) {
        Client clientSelected;
        if (event.getClickCount() == 2) {
            clientSelected = tblClient.getSelectionModel().getSelectedItem();
            if (clientSelected != null) {
                fxGUI.showAlert(true, "Se ha seleccionado correctamente el cliente", stackPane1);
                fxGUI.setSelectObjectCode(clientSelected.getCodeP());
                fxGUI.setSelectedInOtherWindow(true);
                txtCodeClient.setText(clientSelected.getCodeP() + "");
                txtNameClient.setText(clientSelected.getName());
                txtLastNameClient.setText(clientSelected.getLastName());
                txtIDClient.setText(clientSelected.getId() + "");
                txtPhoneClient.setText(clientSelected.getPhoneC() + "");
                txtAddressClient.setText(clientSelected.getAddressC());
                txtEmailClient.setText(clientSelected.getEmailC());
                cbCityClient.setValue(clientSelected.getNameCity());
                btnNewClient.setDisable(true);
                btnSaveClient.setDisable(true);
                btnEditClient.setDisable(false);
                btnRemovClient.setDisable(false);
                btnCityClient.setDisable(true);
            }
        }
    }

    public void onTableListClient() {
        List<Client> clients = rc.getListClients();
        ObservableList<Client> newTableClient;
        newTableClient = FXCollections.observableArrayList(clients);

        tblClient.setItems(newTableClient);
        tblcCodeClient.setCellValueFactory(new PropertyValueFactory<>("codeP"));
        tblcIDClient.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblcNameClient.setCellValueFactory(new PropertyValueFactory<>("name"));
        tblcLastNameClient.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        tblcPhoneClient.setCellValueFactory(new PropertyValueFactory<>("phoneC"));
        tblcAddressClient.setCellValueFactory(new PropertyValueFactory<>("addressC"));
        tblcCity.setCellValueFactory(new PropertyValueFactory<>("nameCity"));
        tblcEmailClient.setCellValueFactory(new PropertyValueFactory<>("emailC"));

        tblClient.refresh();
    }

    public void showCitiesDisp() {
        try {
            List<String> citiesName = new ArrayList<>();
            for (int i = 0; i < rc.getListCities().size(); i++) {
                citiesName.add(rc.getListCities().get(i).getNameCi());
            }

            ObservableList<String> obs;
            obs = FXCollections.observableArrayList(citiesName);
            cbCityClient.setItems(obs);
        } catch (NullPointerException e) {
        }
    }
}
