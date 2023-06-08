package fr.g2.s201_projetseisme;

import java.util.ArrayList;

public class DataSorter {

    public static int dateColumnIndex;
    public static int regionColumnIndex;
    public static int latitudeColumnIndex;
    public static int longitudeColumnIndex;

    public static void printData(ArrayList<ArrayList<String>> data) {
        for (int i = 0 ; i < data.size() ; ++i) {
            for (String str : data.get(i)) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }

    public static void initDateColumnIndex(ArrayList<ArrayList<String>> data) {
        for (int i = 0 ; i < data.get(0).size() ; ++i) {
            if (data.get(0).get(i).equals("\"Date (AAAA/MM/JJ)\"")) {
                dateColumnIndex = i;
            }
        }
    }

    public static void initRegionColumnIndex(ArrayList<ArrayList<String>> data) {
        for (int i = 0 ; i < data.get(0).size() ; ++i) {
            if (data.get(0).get(i).equals("\"Région épicentrale\"")) {
                regionColumnIndex = i;
            }
        }
    }

    public static void initLatitudeColumnIndex(ArrayList<ArrayList<String>> data) {
        for (int i = 0 ; i < data.get(0).size() ; ++i) {
            if (data.get(0).get(i).equals("\"Latitude en WGS 84\"")) {
                latitudeColumnIndex = i;
            }
        }
    }

    public static void initLongitudeColumnIndex(ArrayList<ArrayList<String>> data) {
        for (int i = 0 ; i < data.get(0).size() ; ++i) {
            if (data.get(0).get(i).equals("\"Longitude en WGS 84\"")) {
                longitudeColumnIndex = i;
            }
        }
    }

}
