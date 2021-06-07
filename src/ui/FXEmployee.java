package ui;

import com.jfoenix.controls.JFXTextField;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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

    @FXML
    private JFXTextField txtParamEmployee;

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

    //************** Top Employee ***************\\
    @FXML
    private JFXTextField txtParamTopE;

    @FXML
    private TableView<Employee> tblTopEmployee;

    @FXML
    private TableColumn<Employee, Long> tblcIDTopE;

    @FXML
    private TableColumn<Employee, String> tblcNameTopE;

    @FXML
    private TableColumn<Employee, String> tblcLastNameTopE;

    @FXML
    private TableColumn<Employee, Integer> tblcNSoldTopE;

    @FXML
    private TableColumn<Employee, Double> tblcComisionTopE;

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
        tblEmployee.getItems().clear();

        rc.showBinaryTreeNameEmployee(rc.getRootNameE());

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
        lblTotalEmployee.setText(lblTotalEmployee.getText() + " " + rc.getShowRootName().size());
    }

    public void onTableEmployeeSearch(boolean out, String name) {
        tblEmployee.getItems().clear();

        List<Employee> employees = rc.binaryEmployee(out, name);
        ObservableList<Employee> newTableEmployee;
        newTableEmployee = FXCollections.observableArrayList(employees);

        tblEmployee.setItems(newTableEmployee);
        tblcCodeEmploye.setCellValueFactory(new PropertyValueFactory<>("codeP"));
        tblcIDEmployee.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblcNameEmployee.setCellValueFactory(new PropertyValueFactory<>("name"));
        tblcLastNameEmployee.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        tblcUserEmployee.setCellValueFactory(new PropertyValueFactory<>("username"));
    }

    @FXML
    public void onSearchEmployee(ActionEvent event) {
        try {
            Long id = Long.parseLong(txtParamEmployee.getText());
            onTableEmployeeSearch(false, txtParamEmployee.getText());
        } catch (NumberFormatException e) {
            onTableEmployeeSearch(true, txtParamEmployee.getText());
        }
    }

    @FXML
    public void onShowAllEmployee(ActionEvent event) {
        rc.setShowRootName();
        tblEmployee.getItems().clear();
        onTableEmployeeName();
    }

    public void onTableTopEmployee() {
        rc.showBinaryTreeNameEmployee(rc.getRootNameE());
        List<Employee> employeestest = rc.getShowRootName();

        List<Employee> employees = rc.sortComisionEmployee();
        ObservableList<Employee> newTableEmployee;
        newTableEmployee = FXCollections.observableArrayList(employees);

        tblTopEmployee.setItems(newTableEmployee);
        tblcIDTopE.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblcNameTopE.setCellValueFactory(new PropertyValueFactory<>("name"));
        tblcLastNameTopE.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        tblcNSoldTopE.setCellValueFactory(new PropertyValueFactory<>("nSold"));
        tblcComisionTopE.setCellValueFactory(new PropertyValueFactory<>("vComision"));
    }

    public void onTableTopEmployeeSearch(boolean out, String name) {
        tblTopEmployee.getItems().clear();

        List<Employee> employees = rc.binaryEmployee(out, name);
        ObservableList<Employee> newTableEmployee;
        newTableEmployee = FXCollections.observableArrayList(employees);

        tblTopEmployee.setItems(newTableEmployee);
        tblcIDTopE.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblcNameTopE.setCellValueFactory(new PropertyValueFactory<>("name"));
        tblcLastNameTopE.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        tblcNSoldTopE.setCellValueFactory(new PropertyValueFactory<>("nSold"));
        tblcComisionTopE.setCellValueFactory(new PropertyValueFactory<>("vComision"));
    }

    @FXML
    public void onSearchTopE(ActionEvent event) {
        try {
            Long id = Long.parseLong(txtParamTopE.getText());
            onTableTopEmployeeSearch(false, txtParamTopE.getText());
        } catch (NumberFormatException e) {
            onTableTopEmployeeSearch(true, txtParamTopE.getText());
        }
    }

    @FXML
    public void onShowAllTopE(ActionEvent event) {
        rc.setShowRootName();
        tblTopEmployee.getItems().clear();
        onTableTopEmployee();
    }
}
