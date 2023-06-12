package fr.g2.s201_projetseisme;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDataSorter {

    public static ArrayList<ArrayList<String>> initData1() {
        ArrayList<ArrayList<String>> data1 = new ArrayList<>();
        data1.add(new ArrayList<>());
        data1.get(0).add("\"Date (AAAA/MM/JJ)\"");
        data1.get(0).add("\"Région épicentrale\"");
        data1.get(0).add("\"Latitude en WGS 84\"");
        data1.get(0).add("\"Longitude en WGS 84\"");
        return data1;
    }
    public static ArrayList<ArrayList<String>> initData2() {
        ArrayList<ArrayList<String>> data2 = new ArrayList<>();
        data2.add(new ArrayList<>());
        data2.get(0).add("\"Longitude en WGS 84\"");
        data2.get(0).add("\"Latitude en WGS 84\"");
        data2.get(0).add("\"Région épicentrale\"");
        data2.get(0).add("\"Date (AAAA/MM/JJ)\"");
        return data2;
    }
    public static ArrayList<ArrayList<String>> initData3() {
        ArrayList<ArrayList<String>> data3 = new ArrayList<>();
        data3.add(new ArrayList<>());
        data3.get(0).add("None");
        data3.get(0).add("None");
        data3.get(0).add("None");
        data3.get(0).add("None");
        return data3;
    }
    @Test
    public final void testInitDateColumnIndex() {
        ArrayList<ArrayList<String>> data1 = initData1();
        ArrayList<ArrayList<String>> data2 = initData2();
        ArrayList<ArrayList<String>> data3 = initData3();

        DataSorter.initDateColumnIndex(data1);
        assertEquals(0 ,DataSorter.dateColumnIndex);

        DataSorter.initDateColumnIndex(data2);
        assertEquals(3, DataSorter.dateColumnIndex);

        DataSorter.initDateColumnIndex(data3);
        assertEquals(3, DataSorter.dateColumnIndex);
    }

    @Test
    public final void testInitRegionColumnIndex() {
        ArrayList<ArrayList<String>> data1 = initData1();
        ArrayList<ArrayList<String>> data2 = initData2();
        ArrayList<ArrayList<String>> data3 = initData3();

        DataSorter.initRegionColumnIndex(data1);
        assertEquals(1 ,DataSorter.regionColumnIndex);

        DataSorter.initRegionColumnIndex(data2);
        assertEquals(2, DataSorter.regionColumnIndex);

        DataSorter.initRegionColumnIndex(data3);
        assertEquals(2, DataSorter.regionColumnIndex);
    }

    @Test
    public final void testInitLatitudeColumnIndex() {
        ArrayList<ArrayList<String>> data1 = initData1();
        ArrayList<ArrayList<String>> data2 = initData2();
        ArrayList<ArrayList<String>> data3 = initData3();

        DataSorter.initLatitudeColumnIndex(data1);
        assertEquals(2 ,DataSorter.latitudeColumnIndex);

        DataSorter.initLatitudeColumnIndex(data2);
        assertEquals(1, DataSorter.latitudeColumnIndex);

        DataSorter.initLatitudeColumnIndex(data3);
        assertEquals(1, DataSorter.latitudeColumnIndex);
    }

    @Test
    public final void testInitLongitudeColumnIndex() {
        ArrayList<ArrayList<String>> data1 = initData1();
        ArrayList<ArrayList<String>> data2 = initData2();
        ArrayList<ArrayList<String>> data3 = initData3();

        DataSorter.initLongitudeColumnIndex(data1);
        assertEquals(3 ,DataSorter.longitudeColumnIndex);

        DataSorter.initLongitudeColumnIndex(data2);
        assertEquals(0, DataSorter.longitudeColumnIndex);

        DataSorter.initLongitudeColumnIndex(data3);
        assertEquals(0, DataSorter.longitudeColumnIndex);
    }


}
