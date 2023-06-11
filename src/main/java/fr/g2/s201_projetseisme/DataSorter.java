package fr.g2.s201_projetseisme;

import javafx.scene.chart.XYChart;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Cette classe permet d'initialiser tous les indexes importants utiles à la recherche de données dans DataCalcul.
 * Elle contient également l'attribut data, qui contient toutes les données lues sur le fichier csv sélectionné
 */
public class DataSorter {

    /**
     * data est une liste de liste de String qui contient toutes les données issues du fichier csv sélectionné. Cet attribut est initialisé dans la fonction chooseFile() de
     * la classe AccueilController. Il contient toutes les données renseignées dans le fichier csv sélectionné.
     */
    public static ArrayList<ArrayList<String>> data;

    /**
     * dateColumnIndex est un entier accessible dans toutes les classes. Il représente l'index correspondant à la colonne qui contient les dates des séismes dans data.
     * Cet attribut est initialisé dans la fonction chooseFile() de la classe AccueilController
     */
    public static int dateColumnIndex;
    /**
     * regionColumnIndex est un entier accessible dans toutes les classes. Il représente l'index correspondant à la colonne qui contient les régions des séismes dans data.
     * Cet attribut est initialisé dans la fonction chooseFile() de la classe AccueilController
     */
    public static int regionColumnIndex;
    /**
     * latitudeColumnIndex est un entier accessible dans toutes les classes. Il représente l'index correspondant à la colonne qui contient les latitudes des séismes dans data.
     * Cet attribut est initialisé dans la fonction chooseFile() de la classe AccueilController
     */
    public static int latitudeColumnIndex;
    /**
     * longitudeColumnIndex est un entier accessible dans toutes les classes. Il représente l'index correspondant à la colonne qui contient les longitudes des séismes dans data.
     * Cet attribut est initialisé dans la fonction chooseFile() de la classe AccueilController
     */
    public static int longitudeColumnIndex;

    /**
     * initDateColumnIndex est une fonction qui initialise la valeur de l'attribut dateColumnIndex en fonction de son paramètre data
     * @param data est une liste de liste de String qui fait référence à l'attribut data
     */
    public static void initDateColumnIndex(ArrayList<ArrayList<String>> data) {
        for (int i = 0 ; i < data.get(0).size() ; ++i) {
            if (data.get(0).get(i).equals("\"Date (AAAA/MM/JJ)\"")) {
                dateColumnIndex = i;
            }
        }
    }

    /**
     * initRegionColumnIndex est une fonction qui initialise la valeur de l'attribut regionColumnIndex en fonction de son paramètre data
     * @param data est une liste de liste de String qui fait référence à l'attribut data
     */
    public static void initRegionColumnIndex(ArrayList<ArrayList<String>> data) {
        for (int i = 0 ; i < data.get(0).size() ; ++i) {
            if (data.get(0).get(i).equals("\"Région épicentrale\"")) {
                regionColumnIndex = i;
            }
        }
    }

    /**
     * initLatitudeColumnIndex est une fonction qui initialise la valeur de l'attribut latitudeColumnIndex en fonction de son paramètre data
     * @param data est une liste de liste de String qui fait référence à l'attribut data
     */
    public static void initLatitudeColumnIndex(ArrayList<ArrayList<String>> data) {
        for (int i = 0 ; i < data.get(0).size() ; ++i) {
            if (data.get(0).get(i).equals("\"Latitude en WGS 84\"")) {
                latitudeColumnIndex = i;
            }
        }
    }

    /**
     * initLongitudeColumnIndex est une fonction qui initialise la valeur de l'attribut longitudeColumnIndex en fonction de son paramètre data
     * @param data est une liste de liste de String qui fait référence à l'attribut data
     */
    public static void initLongitudeColumnIndex(ArrayList<ArrayList<String>> data) {
        for (int i = 0 ; i < data.get(0).size() ; ++i) {
            if (data.get(0).get(i).equals("\"Longitude en WGS 84\"")) {
                longitudeColumnIndex = i;
            }
        }
    }

}
