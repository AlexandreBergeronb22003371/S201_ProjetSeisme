package fr.g2.s201_projetseisme;

import javafx.scene.chart.XYChart;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Cette classe permet d'initialiser toutes les colonnes de trie
 */
public class DataSorter {

    public static ArrayList<ArrayList<String>> data;

    public static int dateColumnIndex;
    public static int regionColumnIndex;
    public static int latitudeColumnIndex;
    public static int longitudeColumnIndex;

    /**
     * Cette fonction va initialiser
     * @param data est une liste de liste de String
     */
    public static void initDateColumnIndex(ArrayList<ArrayList<String>> data) {
        for (int i = 0 ; i < data.get(0).size() ; ++i) {
            if (data.get(0).get(i).equals("\"Date (AAAA/MM/JJ)\"")) {
                dateColumnIndex = i;
            }
        }
    }

    /**
     * Cette fonction va initialiser
     * @param data est une liste de liste de String
     */
    public static void initRegionColumnIndex(ArrayList<ArrayList<String>> data) {
        for (int i = 0 ; i < data.get(0).size() ; ++i) {
            if (data.get(0).get(i).equals("\"Région épicentrale\"")) {
                regionColumnIndex = i;
            }
        }
    }

    /**
     * Cette fonction va initialiser
     * @param data est une liste de liste de String
     */
    public static void initLatitudeColumnIndex(ArrayList<ArrayList<String>> data) {
        for (int i = 0 ; i < data.get(0).size() ; ++i) {
            if (data.get(0).get(i).equals("\"Latitude en WGS 84\"")) {
                latitudeColumnIndex = i;
            }
        }
    }

    /**
     * Cette fonction va initialiser
     * @param data est une liste de liste de String
     */
    public static void initLongitudeColumnIndex(ArrayList<ArrayList<String>> data) {
        for (int i = 0 ; i < data.get(0).size() ; ++i) {
            if (data.get(0).get(i).equals("\"Longitude en WGS 84\"")) {
                longitudeColumnIndex = i;
            }
        }
    }

}
