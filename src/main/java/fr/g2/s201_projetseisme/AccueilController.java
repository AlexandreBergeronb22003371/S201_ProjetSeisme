package fr.g2.s201_projetseisme;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Cette classe est le Controller de la vue accueil-view.fxml. Elle contient toutes les fonctions relatives à l'activation de boutons sur cette vue.
 */
public class AccueilController extends Controller implements Initializable {
    /**
     * pathLabel est le label qui affiche la String Controller.pathString.
     * Il est initialisé dans la fonction initialize(...) et est modifié dans la chooseFile() lors de la sélection (ou déselection) d'un fichier
     */
    @FXML
    private Label pathLabel;

    /**
     * Elle initialise le label pathLabel lors du lancement de la fenêtre.
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (pathString != "aucun") {
            pathLabel.setText(pathString);
            pathLabel.setStyle("-fx-text-fill: green");
        }
        else {
            pathString = "aucun";
            pathLabel.setText(pathString);
            pathLabel.setStyle("-fx-text-fill: red");
        }
    }

    /**
     * Cette fonction exécute tout le code relatif à la lecture d'un fichier csv.
     * Après lecture et placement des données du csv dans le ArrayList<ArrayList<String>> DataSorter.data,
     * elle initialise les indexes importants attributs de la classe DataSorter.
     * Si aucun fichier n'est sélectionné, elle vide le contenu de DataSorter.data et
     * réinitialise la String Controller.pathString ainsi que le label pathLabel la contenant.
     */
    public void chooseFile() {
        DataSorter.data = new ArrayList<ArrayList<String>>();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Sélectionnez un fichier");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Fichiers CSV", "*.csv"));
        Stage stage = (Stage) MainApp.stage;
        java.io.File selectedFile = fileChooser.showOpenDialog(stage);

        if (selectedFile != null) {
            pathString = selectedFile.getAbsolutePath();
            System.out.println("Fichier sélectionné : " + pathString);
            pathLabel.setText(pathString);
            pathLabel.setStyle("-fx-text-fill: green");
            try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
                String line;
                String[] tempArr;
                String delimiter = ",";
                while ((line = reader.readLine()) != null) {
                    tempArr = line.split(delimiter);
                    ArrayList<String> tempInsideArr = new ArrayList<String>();
                    for (String tempStr : tempArr) {
                        tempInsideArr.add(tempStr);
                    }
                    DataSorter.data.add(tempInsideArr);
                }

                //Initialisation des index importants

                DataSorter.initDateColumnIndex(DataSorter.data);
                DataSorter.initRegionColumnIndex(DataSorter.data);
                DataSorter.initLatitudeColumnIndex(DataSorter.data);
                DataSorter.initLongitudeColumnIndex(DataSorter.data);

            } catch (IOException e) {
                System.out.println("Erreur lors de la lecture du fichier : " + e.getMessage());
            }
        } else {
            pathString = "aucun";
            System.out.println("Aucun fichier sélectionné.");
            pathLabel.setText(pathString);
            pathLabel.setStyle("-fx-text-fill: red");
            DataSorter.data.clear();
        }
    }
}