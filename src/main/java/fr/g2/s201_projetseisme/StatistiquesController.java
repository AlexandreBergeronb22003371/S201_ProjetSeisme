package fr.g2.s201_projetseisme;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StatistiquesController extends Controller implements Initializable {

    @FXML
    BarChart barChart;
    @FXML
    PieChart pieChart;
    @FXML
    LineChart lineChart;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}