package ui;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.*;

public class FXEmployee {

    private static final long serialVersionUID = 1;

    //********** Label **************\\
    @FXML
    private Label lblTotalEmployee;

    //********** Set Images ***********\\
    @FXML
    private ImageView iSearchEmployee;

    @FXML
    private ImageView iSearchTopEmployee;

    //********** Table Employee ************\\
    @FXML
    private TableView<Employee> tblEmployee;

    @FXML
    private TableColumn<Employee, Integer> tblcCodeEmploye;

    @FXML
    private TableColumn<Employee, Long> tblcIDEmployee;

    @FXML
    private TableColumn<Employee, String> tblcNameEmployee;

    @FXML
    private TableColumn<Employee, String> tblcLastNameEmployee;

    @FXML
    private TableColumn<Employee, String> tblcUserEmployee;

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

    public void onTableEmployeeName() {
        rc.showBinaryTreeNameEmployee(rc.getRootName());
        
        List<Employee> employees = rc.getShowRootName();
        ObservableList<Employee> newTableEmployee;
        newTableEmployee = FXCollections.observableArrayList(employees);
        
        tblEmployee.setItems(newTableEmployee);
        tblcCodeEmploye.setCellValueFactory(new PropertyValueFactory<>("codeP"));
        tblcIDEmployee.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblcNameEmployee.setCellValueFactory(new PropertyValueFactory<>("name"));
        tblcLastNameEmployee.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        tblcUserEmployee.setCellValueFactory(new PropertyValueFactory<>("username"));
        
        tblEmployee.refresh();
        lblTotalEmployee.setText(lblTotalEmployee.getText()+" "+rc.getShowRootName().size());
    }
}
