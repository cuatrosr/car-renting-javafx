package ui;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.*;

public class FXEmployee {

    private static final long serialVersionUID = 1;
    @FXML
    private ImageView iSearchEmployee;

    @FXML
    private ImageView iSearchTopEmployee;

    private RentingCar rc;
    private FXController fxGUI;

    public FXEmployee(RentingCar rc, FXController fxGUI) {
        this.rc = rc;
        this.fxGUI = fxGUI;
    }

    public Image getImageButton() {
        Image iSearchEmployee = new Image("Images/search.png");
        return iSearchEmployee;
    }

    public void setImageEmployee() {
        iSearchEmployee.setImage(getImageButton());
    }

    public void setImageTopEmployee() {
        iSearchTopEmployee.setImage(getImageButton());
    }
}
