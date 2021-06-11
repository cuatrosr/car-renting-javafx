package ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;
import model.*;

public class FXShapes {

    @FXML
    private Pane pStatRent;

    @FXML
    private PieChart pieChart;

    @FXML
    private Pane barChartPane;

    @FXML
    private BarChart<?, ?> barChart;

    private RentingCar rc;
    private FXController fxGUI;

    public FXShapes(RentingCar rc, FXController fxGUI) {
        this.rc = rc;
        this.fxGUI = fxGUI;
    }

    public void loadPieChart() {
        ObservableList<PieChart.Data> pieChartData
                = FXCollections.observableArrayList(
                        new PieChart.Data("A tiempo", rc.amountStatRent()[0]),
                        new PieChart.Data("Expira hoy", rc.amountStatRent()[1]),
                        new PieChart.Data("Expirado", rc.amountStatRent()[2]),
                        new PieChart.Data("Pagado", rc.amountStatRent()[3]));
        final PieChart chart = new PieChart(pieChartData);
        pieChart.setData(pieChartData);
    }

    public void loadBarChart() {
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Ciudades");
        series1.getData().add(new XYChart.Data("", rc.getListCities().size()));

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Tipos de vehiculos");
        series2.getData().add(new XYChart.Data("", rc.getListTypeV().size()));

        XYChart.Series series3 = new XYChart.Series();
        series3.setName("Marcas");
        series3.getData().add(new XYChart.Data("", rc.getListBrand().size()));

        XYChart.Series series4 = new XYChart.Series();
        series4.setName("Clientes");
        series4.getData().add(new XYChart.Data("", rc.getListClients().size()));

        XYChart.Series series5 = new XYChart.Series();
        series5.setName("Vehiculos");
        series5.getData().add(new XYChart.Data("", rc.getShowRootCar().size()));

        XYChart.Series series6 = new XYChart.Series();
        series6.setName("Rentas");
        series6.getData().add(new XYChart.Data("", rc.getListRent().size()));

        barChart.getData().add(series1);
        barChart.getData().add(series2);
        barChart.getData().add(series3);
        barChart.getData().add(series4);
        barChart.getData().add(series5);
        barChart.getData().add(series6);
    }
}
