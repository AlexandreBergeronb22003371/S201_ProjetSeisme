package fr.g2.s201_projetseisme;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Cette classe va
 */
public class DataCalcul {
    /**
     *
     * @param data Cette fonction va initialiser
     * @return ObservableList<PieChart.Data> qui est
     */
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

    /**
     *
     * @param data est une liste de liste de String
     * @return une liste de nombres entiers
     */
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

    /**
     *
     * @param data est une liste de liste de String
     * @return une liste de String
     */
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

    /**
     *
     * @param data est une liste de liste de String
     * @param date1 est une String
     * @param date2 est une String
     * @return est une liste de liste de String
     */
    public static ArrayList<ArrayList<String>> initDataBetween(ArrayList<ArrayList<String>> data, String date1, String date2) {
        ArrayList<ArrayList<String>> newData = new ArrayList<ArrayList<String>>();
        ArrayList<Integer> dateList = new ArrayList<Integer>();
        Integer minDate = Integer.valueOf(date1);
        Integer maxDate = Integer.valueOf(date2);
        for (int i = 0 ; i < data.size() ; ++i) {
            if (i == 0) {
                dateList.add(0);
            }
            else {
                String tempDateComplete = data.get(i).get(DataSorter.dateColumnIndex);
                String[] tempArr = tempDateComplete.split("/");
                String tempDate = tempArr[0];
                dateList.add(Integer.valueOf(tempDate));
            }
        }
        for (int i = 1 ; i < data.size() ; ++i) {
            if ((dateList.get(i) >= minDate) && (dateList.get(i) < maxDate)) {
                newData.add(data.get(i));
            }
        }
        return newData;
    }

    /**
     *
     * @param data est une liste de liste de String
     * @return XYChart.Series<String, Float>
     */
    public static XYChart.Series<String, Float> initBarChartData(ArrayList<ArrayList<String>> data) {
        XYChart.Series<String, Float> barChartData = new XYChart.Series<>();
        ArrayList<String> regionList = new ArrayList<String>();
        ArrayList<String> distinctRegionList = new ArrayList<String>();
        ArrayList<Integer> countList = new ArrayList<>();
        for (int i = 1 ; i < data.size() ; ++i) {
            String tempData = data.get(i).get(DataSorter.regionColumnIndex);
            if (tempData.length() < 10) {
                regionList.add(tempData);
            }
            else {
                tempData = tempData.substring(0, 10);
                regionList.add(tempData);
            }
        }
        for (String str : regionList) {
            if (!(distinctRegionList.contains(str))) {
                distinctRegionList.add(str);
            }
        }
        for (String str : distinctRegionList) {
            countList.add(0);
        }
        for (int i = 0 ; i < distinctRegionList.size() ; ++i) {
            for (String str : regionList) {
                if (str.equals(distinctRegionList.get(i))) {
                    int tempInt = countList.get(i);
                    countList.set(i, tempInt+1);
                }
            }
        }
        for (int i = 0 ; i < distinctRegionList.size() ; ++i) {
            barChartData.getData().add(new XYChart.Data(distinctRegionList.get(i), countList.get(i)));
        }
        return barChartData;
    }

    /**
     *
     * @param data est une liste de liste de String
     * @return  ArrayList<XYChart.Series<String, Float>>
     */
    public static XYChart.Series<String, Float> initLineChartData(ArrayList<ArrayList<String>> data) {

        XYChart.Series<String, Float> lineChartData = new XYChart.Series<>();
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
            lineChartData.getData().add(new XYChart.Data(distinctDateList.get(i), countList.get(i)));
        }
        return lineChartData;
    }
}
