package fr.g2.s201_projetseisme;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import javafx.scene.control.ChoiceBox;

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

        //Initialization du BarChart
        barChartData = DataCalcul.initBarChartData(sortedData);
        barChart.getData().clear();
        barChart.getData().add(barChartData);

        //Initialization du LineChart
        XYChart.Series<String, Float> lineChartData = DataCalcul.initLineChartData(sortedData);
        lineChart.getData().clear();
        lineChart.getData().add(lineChartData);
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

                //Initialization du BarChart
                barChartData = DataCalcul.initBarChartData(sortedData);
                barChart.getData().clear();
                barChart.getData().add(barChartData);

                //Initialization du LineChart
                XYChart.Series<String, Float> lineChartData = DataCalcul.initLineChartData(sortedData);
                lineChart.getData().clear();
                lineChart.getData().add(lineChartData);
                }
            }


        }
    }