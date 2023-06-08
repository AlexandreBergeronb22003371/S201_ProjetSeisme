package fr.g2.s201_projetseisme;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

import java.util.ArrayList;
import java.util.Collections;

public class DataCalcul {

    public static ObservableList<PieChart.Data> initPieChartData(ArrayList<ArrayList<String>> data) {
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        ArrayList<String> dateList = new ArrayList<String>();
        ArrayList<String> distinctDateList = new ArrayList<String>();
        ArrayList<Integer> countList = new ArrayList<>();
        for (int i = 1 ; i < data.size() ; ++i) {
            String tempDateComplete = data.get(i).get(DataSorter.dateColumnIndex);
            String[] tempArr = tempDateComplete.split("/");
            String tempDate = tempArr[0];
            dateList.add(tempDate);
        }
        for (String str : dateList) {
            if (!(distinctDateList.contains(str))) {
                distinctDateList.add(str);
            }
        }
        for (String str : distinctDateList) {
            countList.add(0);
        }
        for (int i = 0 ; i < distinctDateList.size() ; ++i) {
            for (String str : dateList) {
                if (str.equals(distinctDateList.get(i))) {
                    int tempInt = countList.get(i);
                    countList.set(i, tempInt+1);
                }
            }
        }
        for (int i = 0 ; i < distinctDateList.size() ; ++i) {
            pieChartData.add(new PieChart.Data(distinctDateList.get(i), countList.get(i)));
        }
        return pieChartData;
    }

    public static ArrayList<Integer> initDatesInt(ArrayList<ArrayList<String>> data) {
        ArrayList<String> dateList = new ArrayList<String>();
        ArrayList<String> distinctDateList = new ArrayList<String>();
        ArrayList<Integer> distinctDateListInt = new ArrayList<Integer>();
        for (int i = 1 ; i < data.size() ; ++i) {
            String tempDateComplete = data.get(i).get(DataSorter.dateColumnIndex);
            String[] tempArr = tempDateComplete.split("/");
            String tempDate = tempArr[0];
            dateList.add(tempDate);
        }
        for (String str : dateList) {
            if (!(distinctDateList.contains(str))) {
                distinctDateList.add(str);
            }
        }
        for (int i = 0 ; i < distinctDateList.size() ; ++i) {
            distinctDateListInt.add(Integer.valueOf(distinctDateList.get(i)));
        }
        Collections.sort(distinctDateListInt);
        return distinctDateListInt;
    }

    public static ArrayList<String> initChoiceBoxItems(ArrayList<ArrayList<String>> data) {
        ArrayList<String> choiceBoxItems = new ArrayList<String>();
        ArrayList<Integer> dates = new ArrayList<Integer>();
        dates = initDatesInt(DataSorter.data);
        Integer minDate = dates.get(0);
        Integer maxDate = dates.get(dates.size()-1);
        for (int i = minDate ; i < maxDate ; i += 10) {
            choiceBoxItems.add(i + " - " + (i+10));
        }
        return choiceBoxItems;
    }

}
