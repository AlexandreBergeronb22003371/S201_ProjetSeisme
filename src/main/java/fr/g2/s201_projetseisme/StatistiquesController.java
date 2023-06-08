package fr.g2.s201_projetseisme;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StatistiquesController extends Controller implements Initializable {

    //Choice Boxes
    @FXML
    private ChoiceBox<String> periodChoiceBox;

    //barChart
    @FXML
    private BarChart<String, Float> barChart;
    @FXML
    private NumberAxis barChartYAxis;
    @FXML
    private CategoryAxis barChartXAxis;
    private XYChart.Series<String, Float> barChartData;

    //pieChart
    @FXML
    private PieChart pieChart;
    private ObservableList<PieChart.Data> pieChartData;

    //lineChart
    @FXML
    private LineChart lineChart;
    @FXML
    private NumberAxis lineChartYAxis;
    @FXML
    private CategoryAxis lineChartXAxis;

    @FXML
    public void periodChoiceBoxChanged() {
        String initDates = periodChoiceBox.getValue();
        String[] tempArr = initDates.split(" - ");
        String initDate1 = tempArr[0];
        String initDate2 = tempArr[1];
        ArrayList<ArrayList<String>> sortedData = new ArrayList<ArrayList<String>>();
        sortedData = DataCalcul.initDataBetween(DataSorter.data, initDate1, initDate2);

        //Initialization du PieChart
        pieChartData = DataCalcul.initPieChartData(sortedData);
        pieChart.setData(pieChartData);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        if (DataSorter.data != null) {

            if (!(DataSorter.data.isEmpty())) {

                //Initialization des ChoiceBoxes
                ArrayList<String> periodChoiceBoxList = new ArrayList<String>();
                periodChoiceBoxList = DataCalcul.initChoiceBoxItems(DataSorter.data);
                for (String str : periodChoiceBoxList) {
                    periodChoiceBox.getItems().add(str);
                }
                periodChoiceBox.setValue(periodChoiceBoxList.get(0));
                periodChoiceBox.setOnAction(actionEvent -> {
                    periodChoiceBoxChanged();
                });

                //Initialization de data en fonction des ChoiceBoxes
                String initDates = periodChoiceBox.getValue();
                String[] tempArr = initDates.split(" - ");
                String initDate1 = tempArr[0];
                String initDate2 = tempArr[1];
                ArrayList<ArrayList<String>> sortedData = new ArrayList<ArrayList<String>>();
                sortedData = DataCalcul.initDataBetween(DataSorter.data, initDate1, initDate2);

                //Initialization du PieChart
                pieChartData = DataCalcul.initPieChartData(sortedData);
                pieChart.setData(pieChartData);

            }


        }

        //Exemple de remplissage du barChart
        barChartData = new XYChart.Series<>();
        barChartData.getData().add(new XYChart.Data("Ville 1",10));
        barChartData.getData().add(new XYChart.Data("Ville 2",10));
        barChartData.getData().add(new XYChart.Data("Ville 3",10));
        barChart.getData().add(barChartData);

        //Exemple de remplissage du pieChart
        //pieChartData = FXCollections.observableArrayList(
        //        new PieChart.Data("2000", 10),
        //        new PieChart.Data("2001", 10),
        //        new PieChart.Data("2002", 10)
        //);


        //Exemple de remplissage du lineChart
        XYChart.Series<String, Float> lineChartData1 = new XYChart.Series<>();
        XYChart.Series<String, Float> lineChartData2 = new XYChart.Series<>();
        XYChart.Series<String, Float> lineChartData3 = new XYChart.Series<>();
        lineChartData1.getData().add(new XYChart.Data("2000",10));
        lineChartData1.getData().add(new XYChart.Data("2001",20));
        lineChartData1.getData().add(new XYChart.Data("2002",10));
        lineChartData2.getData().add(new XYChart.Data("2000",20));
        lineChartData2.getData().add(new XYChart.Data("2001",10));
        lineChartData2.getData().add(new XYChart.Data("2002",20));
        lineChartData3.getData().add(new XYChart.Data("2000",5));
        lineChartData3.getData().add(new XYChart.Data("2001",10));
        lineChartData3.getData().add(new XYChart.Data("2002",15));
        lineChartData1.setName("Ville 1");
        lineChartData2.setName("Ville 2");
        lineChartData3.setName("Ville 3");
        lineChart.getData().addAll(lineChartData1, lineChartData2, lineChartData3);
    }
}