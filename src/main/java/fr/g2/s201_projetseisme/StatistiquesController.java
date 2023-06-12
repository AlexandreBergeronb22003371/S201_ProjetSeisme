package fr.g2.s201_projetseisme;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Cette classe est le Controller de la vue statistiques-view.fxml. Elle contient toutes les fonctions relatives à l'activation de boutons sur cette vue.
 */
public class StatistiquesController extends Controller implements Initializable {

    //Choice Boxes
    /**
     * periodChoiceBox est la ChoiceBox qui contient les choix de périodes à sélectionner pour gérer les données classées par années.
     */
    @FXML
    private ChoiceBox<String> periodChoiceBox;

    //barChart
    /**
     * barChart est le graphique en barres représentant les nombres de séismes en fonction des régions.
     */
    @FXML
    private BarChart<String, Float> barChart;
    /**
     * barChartData est la série de donnée contenue dans le barChart.
     */
    private XYChart.Series<String, Float> barChartData;

    //pieChart
    /**
     * pieChart est le graphique en secteurs représentant les nombres de séismes en fonction des années.
     */
    @FXML
    private PieChart pieChart;
    /**
     * pieChartData est la liste contenant les données à afficher dans le pieChart.
     */
    private ObservableList<PieChart.Data> pieChartData;

    //lineChart
    /**
     * lineChart est le graphique présentant une courbe des nombres de séismes en fonction des années.
     */
    @FXML
    private LineChart lineChart;

    /**
     * periodChoiceBoxChanged() est la fonction activée lorsque la periodChoiceBox est "onAction".
     * Elle permet l'actualisation des données dans les graphiques en fonction du choix déterminé dans la periodChoiceBox.
     */
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

    /**
     * Cette fonction initialise l'affichage des graphiques en fonction du contenu de DataSorter.data : si DataSorter.data est vide ou nulle,
     * les graphiques seront affichés mais vides. Sinon, les graphiques affichent les données de DataSorter.data dont la date convient
     * à la fourchette sélectionnée dans periodChoiceBox : par défaut, c'est le premier choix qui est sélectionné.
     * @param url
     * @param resourceBundle
     */
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