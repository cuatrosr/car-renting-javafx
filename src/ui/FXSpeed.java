package ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import model.RentingCar;
import thread.ThreadVelocity;

public class FXSpeed implements Initializable {

    private static final long serialVersionUID = 1;

    @FXML
    private TextField txtSpeed;

    @FXML
    private ImageView ivCar;

    @FXML
    private StackPane stackPane1;

    @FXML
    private Pane pSpeed;

    @FXML
    private Label txtResult;

    private FXController fxGUI;
    private RentingCar rc;

    public FXSpeed(RentingCar rc, FXController fxGUI) {
        this.rc = rc;
        this.fxGUI = fxGUI;
    }

    public Pane getPane() {
        return pSpeed;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setImages();
    }
    
    public void setImages() {
        ivCar.setImage(new Image("Images/"));
    }
    
    @FXML
    public void onTestBtn(ActionEvent event) {
        if (!txtSpeed.getText().equals("")) {
            try {
                int velocity = Integer.parseInt(txtSpeed.getText());
                if (velocity > 0) {
                    ThreadVelocity tv = new ThreadVelocity(this, rc, velocity);
                    tv.start();
                    moveCar(velocity);
                } else {
                    fxGUI.showAlert(false, "Ingresa una velocidad valida", stackPane1);
                }
            } catch (NumberFormatException e) {
                fxGUI.showAlert(false, "No puedes colocar texto como velocidad", stackPane1);
            }
        } else {
            fxGUI.showAlert(false, "Debes llenar el campo de velocidad", stackPane1);
        }
    }

    public void showResult(String msg) {
        txtResult.setText(msg);
        txtResult.setVisible(true);
    }

    public void moveCar(int velocity) {
        int pixelMoves = 0;
        if (velocity < 100) {
            pixelMoves = 2;
        } else if (velocity < 200) {
            pixelMoves = 6;
        } else if (velocity < 300) {
            pixelMoves = 8;
        } else {
            pixelMoves = 10;
        }
        while (ivCar.getLayoutX() < 300) {
            ivCar.setLayoutX(ivCar.getLayoutX() - pixelMoves);
        }
    }
}
