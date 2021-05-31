package ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.*;

public class FXDevol implements Initializable {

    private static final long serialVersionUID = 1;
    @FXML
    private Pane dPane;

    //********* Set Images *********\\
    @FXML
    private ImageView iSelectRentDevol;

    @FXML
    private ImageView iPayDevol;

    private RentingCar rc;
    private FXController fxGUI;

    public FXDevol(RentingCar rc, FXController fxGUI) {
        this.rc = rc;
        this.fxGUI = fxGUI;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setImagesButton();
    }

    public void setImagesButton() {
        Image iSelectRentDevolPNG = new Image("Images/car-key.png");
        Image iPayDevolPNG = new Image("Images/pay-check.png");
        iSelectRentDevol.setImage(iSelectRentDevolPNG);
        iPayDevol.setImage(iPayDevolPNG);
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

}
