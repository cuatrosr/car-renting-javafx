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
import thread.ThreadCarMove;
import thread.ThreadVelocity;

public class FXSpeed implements Initializable {

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
    private ThreadVelocity tv;
    private ThreadCarMove tc;

    public FXSpeed(RentingCar rc, FXController fxGUI) {
        this.rc = rc;
        this.fxGUI = fxGUI;
    }

    public Pane getPane() {
        return pSpeed;
    }

    public ThreadVelocity getTv() {
        return tv;
    }

    public ThreadCarMove getTc() {
        return tc;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setImages();
    }

    public void setImages() {
        ivCar.setImage(new Image("Images/Wkisby.gif"));
        txtResult.setVisible(false);
    }

    @FXML
    public void onTestBtn(ActionEvent event) {
        ivCar.setLayoutX(0);
        if (!txtSpeed.getText().equals("")) {
            try {
                int velocity = Integer.parseInt(txtSpeed.getText());
                if (velocity > 0) {
                    tv = new ThreadVelocity(this, rc, velocity);
                    tc = new ThreadCarMove(this, rc, velocity);
                    tv.start();
                    tc.start();
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

    public void moveCar() {
        ivCar.setLayoutX(ivCar.getLayoutX() + 1);
    }
    
    @SuppressWarnings("deprecation")
	public void interrupThreads() {
        tc.stop();
    }
}
