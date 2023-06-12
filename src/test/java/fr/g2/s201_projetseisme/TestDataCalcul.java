package fr.g2.s201_projetseisme;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestDataCalcul {
    public static ArrayList<ArrayList<String>> initData() {
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        data.add(new ArrayList<>());
        data.get(0).add("\"Date (AAAA/MM/JJ)\"");
        data.get(0).add("\"Région épicentrale\"");
        data.get(0).add("\"Latitude en WGS 84\"");
        data.get(0).add("\"Longitude en WGS 84\"");
        for (int i = 1 ; i < 11 ; ++i) {
            data.add(new ArrayList<>());
            data.get(i).add("1900/01/01");
            data.get(i).add("PROVENCE");
            data.get(i).add("0");
            data.get(i).add("0");
        }
        for (int i = 11 ; i < 21 ; ++i) {
            data.add(new ArrayList<>());
            data.get(i).add("1900/01/01");
            data.get(i).add("DROME");
            data.get(i).add("0");
            data.get(i).add("0");
        }
        for (int i = 21 ; i < 31 ; ++i) {
            data.add(new ArrayList<>());
            data.get(i).add("1910/01/01");
            data.get(i).add("PROVENCE");
            data.get(i).add("0");
            data.get(i).add("0");
        }
        for (int i = 31 ; i < 41 ; ++i) {
            data.add(new ArrayList<>());
            data.get(i).add("1910/01/01");
            data.get(i).add("DROME");
            data.get(i).add("0");
            data.get(i).add("0");
        }
        DataSorter.initDateColumnIndex(data);
        DataSorter.initRegionColumnIndex(data);
        DataSorter.initLatitudeColumnIndex(data);
        DataSorter.initLongitudeColumnIndex(data);
        return data;
    }
    public static boolean pieChartDataEquals(ObservableList<PieChart.Data> pieChartData1, ObservableList<PieChart.Data> pieChartData2) {
        if (pieChartData1.size() != pieChartData2.size()) {
            return false;
        }
        for (int i = 0; i < pieChartData1.size(); i++) {
            PieChart.Data data1 = pieChartData1.get(i);
            PieChart.Data data2 = pieChartData2.get(i);
            if (!data1.getName().equals(data2.getName())) {
                return false;
            }
            if (data1.getPieValue() != data2.getPieValue()) {
                return false;
            }
        }
        return true;
    }

    @Test
    public final void testInitPieChartData() {
        ObservableList<PieChart.Data> expectedPieChartData = FXCollections.observableArrayList();
        expectedPieChartData.add(new PieChart.Data("1900", 20));
        expectedPieChartData.add(new PieChart.Data("1910", 20));

        ArrayList<ArrayList<String>> data = initData();
        ObservableList<PieChart.Data> actualPieChartData = DataCalcul.initPieChartData(data);
        assertTrue(pieChartDataEquals(expectedPieChartData, actualPieChartData));
    }

    @Test
    public final void testInitDates() {
        ArrayList<Integer> expectedDateList = new ArrayList<>();
        expectedDateList.add(1900);
        expectedDateList.add(1910);

        ArrayList<ArrayList<String>> data = initData();
        ArrayList<Integer> actualDateList = DataCalcul.initDatesInt(data);
        assertEquals(expectedDateList, actualDateList);
    }

    @Test
    public final void testInitChoiceBoxItems() {
        ArrayList<String> expectedItems = new ArrayList<>();
        expectedItems.add("1900 - 1910");
        expectedItems.add("1910 - 1920");

        ArrayList<ArrayList<String>> data = initData();
        ArrayList<String> actualItems = DataCalcul.initChoiceBoxItems(data);
        assertEquals(expectedItems, actualItems);
    }

    @Test
    public final void testInitDataBetween() {
        ArrayList<ArrayList<String>> expectedData = new ArrayList<>();
        for (int i = 0 ; i < 10 ; ++i) {
            expectedData.add(new ArrayList<>());
            expectedData.get(i).add("1900/01/01");
            expectedData.get(i).add("PROVENCE");
            expectedData.get(i).add("0");
            expectedData.get(i).add("0");
        }
        for (int i = 10 ; i < 20 ; ++i) {
            expectedData.add(new ArrayList<>());
            expectedData.get(i).add("1900/01/01");
            expectedData.get(i).add("DROME");
            expectedData.get(i).add("0");
            expectedData.get(i).add("0");
        }

        ArrayList<ArrayList<String>> data = initData();
        ArrayList<ArrayList<String>> actualData = DataCalcul.initDataBetween(data, "1900", "1910");
        assertEquals(expectedData, actualData);
    }

    public static boolean xYChartDataEquals(XYChart.Series<String, Float> barChartData1, XYChart.Series<String, Float> barChartData2) {
        if (barChartData1.getData().size() != barChartData2.getData().size()) {
            return false;
        }
        for (int i = 0; i < barChartData1.getData().size(); i++) {
            XYChart.Data<String, Float> data1 = barChartData1.getData().get(i);
            XYChart.Data<String, Float> data2 = barChartData2.getData().get(i);
            if (!data1.getXValue().equals(data2.getXValue())) {
                return false;
            }
            if (!(data1.getYValue() == data2.getYValue())) {
                return false;
            }
        }
        return true;
    }

    @Test
    public final void testInitBarChartData() {
        XYChart.Series<String, Float> expectedBarChartData = new XYChart.Series<>();
        expectedBarChartData.getData().add(new XYChart.Data("PROVENCE",20));
        expectedBarChartData.getData().add(new XYChart.Data("DROME",20));

        ArrayList<ArrayList<String>> data = initData();
        XYChart.Series<String, Float> actualBarChartData = DataCalcul.initBarChartData(data);
        assertTrue(xYChartDataEquals(expectedBarChartData, actualBarChartData));
    }

    @Test
    public final void testInitLineChartData() {
        XYChart.Series<String, Float> expectedLineChartData = new XYChart.Series<>();
        expectedLineChartData.getData().add(new XYChart.Data("1900",20));
        expectedLineChartData.getData().add(new XYChart.Data("1910",20));

        ArrayList<ArrayList<String>> data = initData();
        XYChart.Series<String, Float> actualLineChartData = DataCalcul.initLineChartData(data);
        assertTrue(xYChartDataEquals(expectedLineChartData, actualLineChartData));
    }
}
